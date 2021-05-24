package su.auth;

import su.configuration.WebDriverBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import su.page.EsiaPage;
import su.page.PortalIndexPage;

public class AuthEsiaTest {

    @Test
    @DisplayName("Открыть верхний бар")
    public void openMainPage() {
        WebDriver driver = WebDriverBuilder.of(WebDriverBuilder.DriveName.CHROME).build();
        driver.get("https://suprema63.opencode.su/");
        driver.findElement(PortalIndexPage.buttonLogin).click();
        String openUrl = driver.getCurrentUrl();
        String buttonText = driver.findElement(By.xpath("//div/header/section[2]/div/div/div[1]")).getText();
        Assert.assertEquals("Ссылка на главную страницу не открывается", openUrl, "https://suprema63.opencode.su/");
        Assert.assertEquals("Выбор авторизации отсутствует", buttonText, "Физические лица");
    }

    @Test
    @DisplayName("Авторизоваться через ЕСИА")
    public void openAuthenticationPage() {
        WebDriver driver = WebDriverBuilder.of(WebDriverBuilder.DriveName.CHROME).build();
        driver.get("https://suprema63.opencode.su/");
        driver.findElement(By.xpath("//span[text()='Вход через Госуслуги']")).click();
        driver.findElement(By.xpath("//div/header/section[2]/div/div/div[1]")).click();

        EsiaPage.login("EsiaTest004@yandex.ru", "11111111", driver);

        String mainText = driver.findElement(By.xpath("//div/header/div[2]/div[1]/div/div/a/h4")).getText();
        Assert.assertEquals("Наименование заголовка аутентификации не отобразилось", mainText, "Перейти на Социальный портал");

    }
}

