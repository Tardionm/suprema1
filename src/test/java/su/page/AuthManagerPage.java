package su.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthManagerPage {
    public static void login(String username, String password, WebDriver driver) {
        WebElement emailAddressInput = driver.findElement(By.id("username"));
        emailAddressInput.sendKeys(username);
        String emailAddressValue = emailAddressInput.getAttribute("value");
        Assert.assertEquals("Поле имени пользователя не заполнилось", emailAddressValue, username);
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
        String passwordValue = passwordInput.getAttribute("value");
        Assert.assertEquals("Поле для ввода пароля не заполнилось", passwordValue, password);
        driver.findElement(By.id("kc-login")).click();
    }
}
