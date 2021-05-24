package su.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EsiaPage {
    public static void login(String login, String password, WebDriver driver) {
        WebElement emailAddressInput = driver.findElement(By.id("login"));
        emailAddressInput.sendKeys(login);
        String emailAddressValue = emailAddressInput.getAttribute("value");
        Assert.assertEquals("Поле адреса электронной почты не заполнилось", emailAddressValue, login);
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
        String passwordValue = passwordInput.getAttribute("value");
        Assert.assertEquals("Поле для ввода пароля не заполнилось", passwordValue, password);
        driver.findElement(By.id("loginByPwdButton")).click();
    }
}
