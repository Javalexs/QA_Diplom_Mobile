package tests;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.getSessionId;

public class TestBase {
    public static String testType = System.getProperty("testType");
    @BeforeAll
    public static void setup() {
        if (testType == null) {
            testType = "local";
        }

        switch (testType) {
            case "local":
                Configuration.browser = LocalMobileDriver.class.getName();
                System.out.println("local test start");
                break;
            case "remote":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                System.out.println("remote test start");
                break;
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();

    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        closeWebDriver();

        switch (testType) {
            case "remote":
                Attach.video(sessionId);
                break;
        }
    }
}
