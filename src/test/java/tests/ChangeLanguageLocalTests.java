package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("local")
public class ChangeLanguageLocalTests {

    @Test
    void addLanguageLocalTest() {
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
}
