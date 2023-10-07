package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("local")
public class AuthorizationLocalTests {

    @Test
    void verifyOpeningOfAutorizationPageLocalTest() {
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
