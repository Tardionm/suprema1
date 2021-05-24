package su.auth;

import su.configuration.WebDriverBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import su.page.AuthManagerPage;

public class AuthManagerTest {
    @Test
    @DisplayName("Авторизация под аккаунтом Менеджера")
    public void openMainPage() throws InterruptedException  {
        WebDriver driver = WebDriverBuilder.of(WebDriverBuilder.DriveName.FIREFOX).build();
        driver.get("https://suprema63.opencode.su/api/v1/auth/auth/login?responseType=BACKOFFICE");
        AuthManagerPage.login("portal_user", "qwerty", driver);
        //driver.findElement(By.id("kc-login")).click();
        String openUrl = driver.getCurrentUrl();
        String buttonText = driver.findElement(By.xpath("//div/header/div[1]/div/div/div/button[1]/span")).getText();
        Assert.assertEquals("Ссылка на главную страницу не открывается", openUrl, "https://suprema63.opencode.su/");
        Assert.assertEquals("Выбор авторизации отсутствует", buttonText, "Менеджер");
    }
}
