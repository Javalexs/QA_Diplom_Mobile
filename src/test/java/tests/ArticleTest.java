package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class ArticleTest {
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
