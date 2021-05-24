package su.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBuilder {

    WebDriver driver;
    boolean maximize = true;

    public static WebDriverBuilder of(DriveName driveName) {
        WebDriverBuilder webDriverBuilder = new WebDriverBuilder();
        webDriverBuilder.driver = driveName.getWebDriver();
        return webDriverBuilder;
    }

    public WebDriverBuilder setMaximize(boolean maximize) {
        this.maximize = maximize;
        return this;
    }

    public WebDriver build() {
        if (maximize)
            driver.manage().window().maximize();
        return driver;
    }
/*


    @Before
    public void initAll() {
        System.out.println("start browser");
        driver.manage().window().maximize();
    }

    @After
    public void close() {
        System.out.println("browser close");
        // driver.quit();
    }
*/

    public enum DriveName {
        CHROME,
        FIREFOX;

        public WebDriver getWebDriver() {
            WebDriver webDriver = null;
            if (this.equals(DriveName.CHROME))
                webDriver = new ChromeDriver();

            if (this.equals(DriveName.FIREFOX))
                webDriver = new FirefoxDriver();

            return webDriver;
        }
    }
}
