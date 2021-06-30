package su.auth;

import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
//import su.configuration.RobotExp;
import su.configuration.WebDriverBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import su.page.CONST.LOCATORs;
import su.page.CONST.MESSAGEs;
import su.page.CONST.URLs;

import java.awt.AWTException;

import java.awt.Robot;

import java.awt.event.KeyEvent;


public class SozPortal {

    WebDriver driver = WebDriverBuilder.of(WebDriverBuilder.DriveName.FIREFOX).build();

    @Before
    @DisplayName("Авторизация менеджер")
    public void before() {
        driver.get(URLs.MANAGER_LOGIN_MAIN_PAGE);
        driver.findElement(LOCATORs.FIELD_MANAGER_LOGIN).sendKeys(MESSAGEs.LOGIN_MANAGER);
        driver.findElement(LOCATORs.FIELD_MANAGER_PASSWORD).sendKeys(MESSAGEs.PASSWORD_MANAGER);
        driver.findElement(LOCATORs.BUTTON_LOGIN_MANAGER_PAGE).click();
    }
    @Test
    @DisplayName("Переход на социальный портал")
    public void sozPage() {
        driver.get(URLs.SOC_PORTAL_MAIN_PAGE);
        String url = driver.getCurrentUrl();
        Assert.assertEquals("Ссылка на страницу соц.портала не открывается", url, URLs.SOC_PORTAL_MAIN_PAGE);
        // если не совпадает ссылка в url с actual, то выведет message
    }
    @Test
    @DisplayName("Меры поддержки граждан в период COVID19")
    public void cobidPdfPage() {
        driver.get(URLs.SOC_PORTAL_MAIN_PAGE);
        WebElement redHeadButton = driver.findElement(LOCATORs.BUTTON_RED_COVID19);
        redHeadButton.click();
        String pdfurl = driver.getCurrentUrl();
        Assert.assertEquals("Неверная ссылка на PDF файл", pdfurl, URLs.COVID19_PDF);
    }
    @Test
    @DisplayName("Переход на страницу Социальный калькулятор")
    public void sozCalculator(){
        driver.get(URLs.SOC_PORTAL_MAIN_PAGE);
        WebElement calculatorButton = driver.findElement(LOCATORs.CALCULATOR_BUTTON);
        calculatorButton.click();
        String socCalcNamePage= driver.findElement(LOCATORs.ZAGOLOVOC_SOC_CALC).getText();
        Assert.assertEquals("Отсутствует заголовок Социальный калькулятор", socCalcNamePage ,
                "Социальный калькулятор");
        //*[@id="__layout"]/div/main/section/div/div/h2
    }
    @Test
    @DisplayName("Переход на страницу организация отдыха и оздоровления детей")
    public void deti() throws InterruptedException{
        driver.get(URLs.SOC_PORTAL_MAIN_PAGE);
        driver.findElement(LOCATORs.OZDOROVLENIE_BUTTON).click();
        Thread.sleep(5000);
        String zagolovocOzdorovlenie = driver.findElement(LOCATORs.ZAGOLOVOC_OZDOROVLENIE).getText();
        String x = "Информация о местах отдыха детей";
        Assert.assertEquals("Отсутствует заголовок Информация о местах отыдаха детей",zagolovocOzdorovlenie , x);
        // System.out.println("МОй заголовок"+ zagolovocOzdorovlenie + " " + x);
        // System.out.println(zagolovocOzdorovlenie);
        /* Assert.assertTrue("Отсутствует заголовок",driver.findElement(By.xpath("//*[@id=\"__layout\"]" +
                "/div/main/section/div/div/h2")).toString().length()>0);*/
    }
    @Test
    @DisplayName("Переход на страницу Каталог ГосУслуг")
    public void catalogGosUslug(){
        driver.get(URLs.SOC_PORTAL_MAIN_PAGE);
        driver.findElement(LOCATORs.BUTTON_CATALOG_GOS_USLUG).click();
        String zagolovocCatalogGos = driver.findElement(LOCATORs.ZAGOLOVOC_CATALOG_GOS_USLUG).getText();
        Assert.assertEquals("Отсутствует заголовок Каталог государственных услуг",zagolovocCatalogGos ,
                                                                                "Каталог государственных услуг");
    }
    @Test
    @DisplayName("Переход на страницу Каталог Мер СоцПоддержки")
    public void catalogSoz(){
        driver.get(URLs.SOC_PORTAL_MAIN_PAGE);
        driver.findElement(LOCATORs.BUTTON_CATALOG_SOC_USLUG).click();
        // попытка переделать под поиск по слову contains  driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/main/section/div[1]/div[2]/div[2]/div[2]/div/a")).click();
        // Каталог социальных услуг // примечание: хорошо сработает, толькое если это уникальные имена, защитит от ошибок, если
        // будут менять путь xpath , в идеале все делать таким поиском этот contains ищет по тексту то что задано в '*'
        String zagolovokCatalogSocUslug = driver.findElement(By.xpath("//h2[contains(text()," +
                                                                  " 'Каталог мер социальной поддержки')]")).getText();
        Assert.assertEquals("Отсутствует заголовок Каталог мер социальной поддержки",zagolovokCatalogSocUslug ,
                                                                        "Каталог мер социальной поддержки");

//        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text()," +
//                " 'Каталог мер социальной поддержки')]")).toString().length()>0);
//           //*[@id="__layout"]/div/main/section/div/div[1]/a[2]   // вместо * перед contains h2, т.к. в общем каталоге 2 записи
//           //*[@id="__layout"]/div/main/section/div/section/h2                                      с одинаковым текстом "Каталог..."
    }
    @Test
    @DisplayName("Переход на страницу Ваше Мнение")
    public void mnenie(){
        driver.get(URLs.SOC_PORTAL_MAIN_PAGE);
        driver.findElement(LOCATORs.BUTTON_MNENIE).click(); //*[@id="__layout"]/div/main/section/section/div[2]/div[1]/h2
        String zagolovocOpros = driver.findElement(LOCATORs.ZAGOLOVOC_OPROS).getText();
        Assert.assertEquals("Отсутсвтует заголовок опросы сайта", zagolovocOpros, "Опросы сайта");
    }
    @Test
    @DisplayName("Переход на страницу Ответы на ваши вопросы")
    public void otvet()  {
        driver.get(URLs.SOC_PORTAL_MAIN_PAGE);
        WebElement element = driver.findElement(LOCATORs.BUTTON_OTVET_NA_VOPROS);
        element.click();
        String zagolovokOtvetNaVopros = driver.findElement(LOCATORs.ZAGOLOVOC_OTVET_NA_VOPROS).getText();
        Assert.assertEquals("Отсутствует заголового ответы на вопросы",zagolovokOtvetNaVopros,"Ответы на вопросы");
        }
    @Test
    @DisplayName("Переход на страницу Выплаты для детей от 3 до 7 лет")
    public void viplati3_7(){
     driver.get(URLs.MINSOC_MAIN_PAGE);
     driver.findElement(LOCATORs.SLIDER_BUTTON_MAIN_PAGE).click();
     driver.findElement(LOCATORs.BUTTON_PODROBNEE).click();
     String linc = driver.getCurrentUrl();
     Assert.assertEquals("Открылась не правильная страница",linc, URLs.SOC_PORTAL_ORIG_PAGE);
    }
    @Test
    @DisplayName("НОТ ВОРКИНГ , СКИПНУЛ, вернусь позже как научусь уменьшать масштаб страниц//Редактировать заголовок виджет")
    public void changeZagolovok(){
        before();
// скоро исправлю xd
        //action.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "-")).perform();

        WebElement element =  driver.findElement(By.xpath("/html/body/" +
                "div/div/div/main/section/section[1]/div[3]/div[2]/div[1]/svg"));
//

      /*      WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementTo(element));
            element.click();*/
        Actions action = new Actions(driver);
//            action.keyDown(Keys.LEFT_CONTROL).sendKeys("-").perform();
//            action.sendKeys(Keys.LEFT_CONTROL, "-").perform();
        action.moveToElement(element).click().perform();
        driver.findElement(By.xpath("/html/body/div/" +
                "div/div/main/section/section[1]/div[1]/div[3]/" +
                "div[1]/div/div[3]/div/div[1]/div/label/input")).sendKeys("1");

        //   driver.manage().window().fullscreen();
        //     element.sendKeys(Keys.LEFT_CONTROL,"-");
        driver.findElement(By.xpath("/html/body/div/div/div/main/" +
                "section/section[1]/div[1]/div[3]/div[1]/div/div[5]/button[1]")).click();


    }

    @Test
    @DisplayName("Предпросмотр при создании добавить Страницу в подразделе")
    public void AddchangePageMap(){
        before();
        WebElement allMapButton = driver.findElement(LOCATORs.BUTTON_MAP_SITE);
        allMapButton.click();
        driver.findElement(LOCATORs.BUTTON_ADD_PAGE).click();
       WebElement name= driver.findElement(LOCATORs.FIELD_TYPE);
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.elementToBeClickable(name)).click();
       driver.findElement(LOCATORs.FIELD_TYPE_PAGE).click();
        WebElement buttonAdd = driver.findElement(LOCATORs.BUTTON_ADD_IN_BLOCKREDACTOR);
        Actions actions = new Actions(driver);
       actions.moveToElement(buttonAdd).click().perform();

    driver.findElement(LOCATORs.FIELD_ZAGOLOVOC_IN_BLOCKREDACTOR).click();
    driver.findElement(LOCATORs.FIELD_ZAGOLOVOC_IN_BLOCKREDACTOR).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"));
    driver.findElement(LOCATORs.FIELD_ZAGOLOVOC_IN_BLOCKREDACTOR).sendKeys(Keys.DELETE);
    driver.findElement(LOCATORs.FIELD_ZAGOLOVOC_IN_BLOCKREDACTOR).sendKeys(MESSAGEs.ZAGOLOVOC_IN_BLOCKREDACTOR);
    WebElement d = driver.findElement(LOCATORs.FIELD_TAG_IN_BLOCKREDACTOR);
    d.sendKeys(MESSAGEs.TAG_IN_BLOCKREDACTOR);
    driver.findElement(LOCATORs.BUTTON_OTHER_TAG_INBLOCKREDACTOR).click();
    WebElement contentField = driver.findElement(LOCATORs.FIELD_CONTENT_IN_BLOCKREDACTOR);
    contentField.click();
    contentField.sendKeys(Keys.chord(Keys.CONTROL + "a"));
    contentField.sendKeys(Keys.DELETE);
    contentField.sendKeys(MESSAGEs.CONTENT_IN_BLOCKREDACTOR);
    driver.findElement(LOCATORs.BUTTON_PREDPROSMOTR_IN_BLOCKREDACTOR).click();
    String blockReadactor = driver.findElement(LOCATORs.BUTTON_BLOCK_REDACTOR_IN_PREDMROSMOTR).getText();
    Assert.assertEquals("Отсутствует кнопка Редактор информационных блоков на странице предпросмотра",blockReadactor,
                                                                                    "Редактор информационных блоков");
    }

    @Test
    @DisplayName("Предпросмотр при создании Добавить публикацию в блог")
    public void AddPublicationInBloG(){
        before();
            // 1 Кнопка сотрудники министерства на мейн пейдже после авторизации
            // 2 выбор любого сотрудника 3 кнопка все публикации 4 добавить публикацию
        // /html/body/div/div/div/main/section/section[2]/div[2]/div[1]/div[1]/div/h2 Сотрудники Министерства
        driver.findElement(LOCATORs.BUTTON_SOTRUDNIKI_MINVA_MAIN_PAGE).click(); // 1
        driver.findElement(LOCATORs.BUTTON_SOTRUDNIK_ANTIMONOVA).click(); //2
        driver.findElement(LOCATORs.BUTTON_ALL_BLOGS).click(); //3
        WebElement addBlogButt = driver.findElement(By.xpath("//button[contains(text(),'Добавить публикацию')]")); //4 /html/body/div/div/div/main/section/div/div/section[2]/button
        addBlogButt.sendKeys(Keys.ENTER);
        WebElement publicationName = driver.findElement(By.xpath("/html/body/div/div/div/section/section/div[4]/div[1]/" +
                "div/div[3]/div/div[2]/div/label/input"));
        publicationName.sendKeys(Keys.CONTROL , "a");
        publicationName.sendKeys(Keys.DELETE);
// доработать робот, проверить уменьшается ли масштаб, как буду внутри
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.delay(15);
            r.keyPress(KeyEvent.VK_MINUS);
        } catch (AWTException e) {
            e.printStackTrace();
        }
      /*  try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.delay(50);
            r.keyPress(Integer.parseInt(KeyEvent.getKeyText(189)));
        } catch (AWTException e) {
            e.printStackTrace();
        }*/
       /* Robot r = new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.delay(50);
        r.keyPress(Integer.parseInt(KeyEvent.getKeyText(189)));
//        Actions action = new Actions(driver);
//        action.sendKeys(Keys.chord(Keys.LEFT_CONTROL,"-")).perform();*/



       // builder.sendKeys(Keys.chord(Keys.CTRL,"l")).perform(); // вид комбинации
        /*Actions actions = new Actions(driver);
        actions.moveToElement(addBlogButt).click().perform();*/
    }

    @Test
    @DisplayName("просто пробую применить робота, ибо из-за масштаба не могу в тестах выше ткнуть на нужную кнопку, она тупо за пределами экрана")
    public void testRobo(){
        driver.get(URLs.MINSOC_MAIN_PAGE);
             try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.delay(15);
            r.keyPress(KeyEvent.VK_MINUS);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    // дальше если нужно то вот xpath кнопки "Сохранить", остановился на предпросмотре
    // /html/body/div/div/div/main/div/section/div[4]/div[1]/div/div[5]/button[1]


//       wait.until(ExpectedConditions.elementToBeSelected(buttonAdd));
//       buttonAdd.click();
// /html/body/div/div/div/main/div/div[1]/div/div[2]/div[2]/button[1]
     //  driver.findElement(By.xpath("//li[text() = 'Типовая страница']")).click();

   //     /html/body/div/div/div/main/div/div[1]/div/div[2]/div[1]/div/input



/*        JavascriptExecutor js = (JavascriptExecutor)driver;
        // if the element is on top.
        js.executeScript("scroll(0, 20)");
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();*/
/*        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.elementToBeClickable(By.className("app-second-link__text"))).click();*/

 /*       driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By elem_dynamic = By.id("dynamic-element");
        wait.until(ExpectedConditions.presenceOfElementLocated(elem_dynamic));
        1
        2
        3
        4
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By elem_dynamic = By.id("dynamic-element");
        wait.until(ExpectedConditions.presenceOfElementLocated(elem_dynamic));*/

        //*[@id="__layout"]/div/main/section/section/div[2]/div[1]/h2

      //  Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(), 'Ответы на ваши вопросы')]")).toString().length()>0);

/*    @Test
    @DisplayName("ПнС Меоы социальной поддержки граждан в период COVID-19")
    public void meraCovid19(){
        sozPage();
        WebDriver driver = WebDriverBuilder.of(WebDriverBuilder.DriveName.CHROME).build();
//       WebElement redHeadButton = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div[2]/div[2]/div/a/h4"));
//       redHeadButton.click();



      *//*  WebElement serviceClass = driver.findElement(By.xpath("//span[contains(text(),'Сервисы')]/.."));

        List<WebElement> allService = driver.findElements(By.xpath("//div[contains(text(),'Сервисы')]/.."));*//*
    }

}*/
}


