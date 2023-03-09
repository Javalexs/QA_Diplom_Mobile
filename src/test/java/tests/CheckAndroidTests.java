package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
public class CheckAndroidTests extends TestBase{
    @Test
    @Owner("Alexsey Fadeev")
    void checkSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }
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

    @Test
    @Owner("Alexsey Fadeev")
    void checkGoToTheArticleTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        });
        step("Click on the Java article", () -> {
            $(id("org.wikipedia.alpha:id/fragment_feed_header")).click();
        });
        step("Click on the back button", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_button")).click();
        });
        step("Check visibility of the header logo", () ->
                $(id("org.wikipedia.alpha:id/single_fragment_toolbar_wordmark"))
                        .shouldBe(visible));
    }
}
