package tests.android.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserStackDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
public class TestBase {
    public static String env = System.getProperty("env");
    @BeforeAll
    static void beforeAll() {
        if (env == null) {
            env = "remote";
        }
        switch (env) {
            case "remote":
                Configuration.browser = BrowserStackDriver.class.getName();
                break;
            case "local":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
        }
        Configuration.browserSize = null;
        Configuration.pageLoadTimeout = 15000;
        Configuration.timeout = 15000;

    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = sessionId().toString();
        Attach.pageSource();
        closeWebDriver();
        if (!System.getProperty("env").equals("local")) Attach.addVideo(sessionId);
    }
}