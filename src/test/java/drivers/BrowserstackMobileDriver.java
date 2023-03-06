package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStackConfig;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    static BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", config.userName());
        mutableCapabilities.setCapability("browserstack.key", config.passWord());

        mutableCapabilities.setCapability("app", config.app());

        mutableCapabilities.setCapability("device", config.device());
        mutableCapabilities.setCapability("os_version", config.osVersion());

        mutableCapabilities.setCapability("project", "Java Project");
        mutableCapabilities.setCapability("build", "browserstack-android-build");
        mutableCapabilities.setCapability("name", "selenide-android-test");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }
}