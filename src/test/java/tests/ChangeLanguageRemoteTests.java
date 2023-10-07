package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("remote")
public class ChangeLanguageRemoteTests {

    @Test
    void addLanguageRemoteTest() {
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
