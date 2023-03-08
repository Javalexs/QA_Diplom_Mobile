package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ProjectConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobileBrowserType.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;


public class LocalMobileDriver implements WebDriverProvider {
    static ProjectConfig emulatorConfig = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static URL getAppiumServerUrl() {
        try {
            return new URL(emulatorConfig.getLocalDriverUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(emulatorConfig.getPlatformName())
                .setDeviceName(emulatorConfig.getDevice())
                .setPlatformVersion(emulatorConfig.getOsVersion())
                .setApp(getAppPath())
                .setAppPackage(emulatorConfig.getAppPackage())
                .setAppActivity(emulatorConfig.getAppActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private String getAppPath() {
        String appUrl = emulatorConfig.getAppUrl();
        String appPath = emulatorConfig.getAppPath();

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app.getAbsolutePath();
    }
}