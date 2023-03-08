package tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
public class CheckAndroidTests extends tests.android.selenide.TestBase {

    @Owner("Alexsey Fadeev")
    @Test
    void successSearchWikiTest() {
//        step("Skip onboarding pages", () -> back());
        step("Type search", () -> {
//            $(id("org.wikipedia:id/search_container")).click();
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("JavaScript");
        });
        step("Verify content found", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });
    }


    @Owner("Alexsey Fadeev")
    @Test
    void countryPageSearchTest() {
//        step("Skip onboarding pages", () -> back());
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Argentina");
        });
        step("Verify content found", () -> {
            $$(AppiumBy.className("android.widget.TextView"))
                    .shouldHave(CollectionCondition.sizeGreaterThan(0));
        });
        step("Verify page is correct", () -> {
            $(id("org.wikipedia.alpha:id/page_list_item_title")).click();
            $(AppiumBy.className("android.webkit.WebView")).click();
            $(AppiumBy.className("android.widget.TextView")).shouldHave(text("Argentina"));
        });
    }


    @Owner("Alexsey Fadeev")
    @Test
    void onBoardingStepsTest() {
//        step("Skip onboarding pages", () -> back());

        step("Check that the text 'The Free Encyclopedia …in over 300 languages' is visible", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("Click on 'Сontinue'", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check that the text 'New ways to explore' is visible", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
        });

        step("Click on 'Сontinue'", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check that the text 'Reading lists with sync' is visible", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
        });

        step("Click on 'Сontinue'", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check that the text 'Send anonymous data' is visible", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
        });
    }

}
