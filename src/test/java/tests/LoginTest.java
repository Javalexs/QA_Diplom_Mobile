package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class LoginTest extends TestBase{
    @Test
    @Owner("Alexsey Fadeev")
    void checkTextLogInToWikipedia() {
        step("Click the user registration button", () -> {
            $(byClassName("android.support.v7.widget.LinearLayoutCompat")).click();
        });
        step("Checking the presence of the text ", () -> {
            $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).shouldHave(text("Log in to Wikipedia"));
        });
    }
}
