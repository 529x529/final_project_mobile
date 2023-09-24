package tests;


import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("remote")
public class SearchTestsRemote extends TestBase {

    @Test
    void successfulSearchTestRemote() {
        step("Ввод поискового запроса", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Проверка результатов поиска", () -> $$(AppiumBy.id("org.wikipedia.alpha:id/search_container")).shouldHave(sizeGreaterThan(0)));
    }

    @Test
    void checkErrorTestRemote() {
        step("Ввод поискового запроса", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Переход на страницу Appium", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_container")).first().click();
        });

        step("Проверка страницы", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_button")).shouldBe(visible);
            $(AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldHave(text("An error occurred"));
        });
    }

    @Test
    void addLanguageTestRemote() {
        step("Переход в action menu приложения", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });
        step("Выбор языка", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
            $$(AppiumBy.className("android.widget.TextView")).findBy(text("Wikipedia language")).click();
            $$(AppiumBy.id("org.wikipedia.alpha:id/localized_language_name")).findBy(text("Deutsch")).click();
        });
        step("Проверка, что выбранный язык добавлен", () -> {
            $$(AppiumBy.className("android.widget.TextView")).findBy(text("Deutsch")).shouldBe(visible);
        });
    }
}
