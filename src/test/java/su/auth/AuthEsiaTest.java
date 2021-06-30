package su.auth;

import su.configuration.WebDriverBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import su.page.CONST.LOCATORs;
import su.page.CONST.MESSAGEs;
import su.page.CONST.URLs;
import su.page.EsiaPage;

public class AuthEsiaTest {
    WebDriver driver = WebDriverBuilder.of(WebDriverBuilder.DriveName.FIREFOX).build();

    @Test
    @DisplayName("Открыть верхний бар")
    public void openMainPage() {

        driver.get(URLs.MINSOC_MAIN_PAGE);
        driver.findElement(LOCATORs.buttonLogin).click();
        String openUrl = driver.getCurrentUrl();
        Assert.assertEquals("Ссылка на главную страницу не открывается", openUrl, URLs.MINSOC_MAIN_PAGE);
        String buttonText = driver.findElement(By.xpath("//div/header/section[2]/div/div/div[1]")).getText();
        Assert.assertEquals("Выбор авторизации отсутствует", buttonText, "Физические лица");
    }
    @Test
    @DisplayName("Авторизоваться через ЕСИА")
    public void openAuthenticationPage() throws InterruptedException {
        driver.get(URLs.MINSOC_MAIN_PAGE);
        driver.findElement(LOCATORs.AUTHO_BUTTON).click();
        driver.findElement(LOCATORs.FIZ_LIZO_BUTTON).click();
        Thread.sleep(5000); // задержка т.к. не успевает грузиться страница, сделать "не выполнять дейсвтие
        // пока на экране не появится какой-нибудь прогруженный элемент
        EsiaPage.login(MESSAGEs.LOGIN_ESIA, MESSAGEs.PASSWORD_ESIA, driver);
        String mainText = driver.findElement(LOCATORs.ZAGOLOVOK_NAME_SOZ_PORTAL).getText();
        Assert.assertEquals("Наименование заголовка аутентификации не отобразилось", mainText, "Перейти на Социальный портал");

    }
    @Test
    @DisplayName("Переход на социальный портал")
    public void test() {

        driver.get(URLs.SOC_PORTAL_MAIN_PAGE);
        String mainText = driver.findElement(LOCATORs.ZAGOLOVOC_SOC_PORTAL).getText();
        Assert.assertEquals("Наименование заголовка не отобразилось", mainText, "СОЦИАЛЬНЫЙ ПОРТАЛ");
    }
}



