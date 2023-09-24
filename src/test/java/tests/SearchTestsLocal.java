package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("local")
public class SearchTestsLocal extends TestBase {

    @Test
    void successfulSearchTestLocal() {
        back();
        step("Ввод поискового запроса", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Проверка, что на странице найден результат поиска", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    void negativeSearchTestLocal() {
        back();
        step("Ввод поискового запроса", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("asfresgx");
        });
        step("Проверка, что на странице не найден результат поиска", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(size(0)));
    }

    @Test
    void addLanguageTestLocal() {
        back();
        step("Переход в меню приложения", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/menu_icon")).click();
        });
        step("Переход в настройки приложения", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_settings_container")).click();
        });
        step("Выбор языка", () -> {
            $$(AppiumBy.className("android.widget.TextView")).findBy(text("Wikipedia language")).click();
            $$(AppiumBy.className("android.widget.TextView")).findBy(text("Add language")).click();
            $$(AppiumBy.id("org.wikipedia.alpha:id/localized_language_name")).findBy(text("Deutsch")).click();
        });
        step("Проверка, что выбранный язык добавлен", () -> {
            $$(AppiumBy.className("android.widget.TextView")).findBy(text("Deutsch")).shouldBe(visible);
        });
    }

    @Test
    void  verifyOpeningOfAutorizationPageTestLocal() {
        back();
        step("Переход в меню приложения", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/menu_icon")).click();
        });
        step("Переход на страницу авторзиации/создания нового аккаунта", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_login_button")).click();
        });
        step("Проверка, что открыта страница авторизации/создания нового аккаунта", () -> {
            $$(AppiumBy.className("android.widget.TextView")).findBy(text("Create an account")).shouldBe(visible);
        });
    }
}
