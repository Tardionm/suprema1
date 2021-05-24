package su.auth;

import su.configuration.WebDriverBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.*;

import static java.lang.Thread.sleep;

public class SitemapPageTest extends WebDriverBuilder {
    @Test
    @DisplayName("Переход на страницу Карта сайта МСДСП СО" )
    public void openMainPage() throws InterruptedException {
        WebDriver driver = WebDriverBuilder.of(WebDriverBuilder.DriveName.FIREFOX).build();
        driver.get("https://suprema63.opencode.su/");
        String openUrl = driver.getCurrentUrl();
        Assert.assertEquals("Ссылка на главную страницу не открывается", openUrl, "https://suprema63.opencode.su/");
        sleep(199);
        //driver.executeScript("window.scrollBy(0, 1601);");
       // sleep(199);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/main/section/div[3]/div[4]"));
        element.click();
    }
}


