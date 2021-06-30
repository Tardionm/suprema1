package su.page.CONST;

import org.openqa.selenium.By;

public class LOCATORs {
    public static  By FIELD_TAG_IN_BLOCKREDACTOR = By.xpath("/html/body/div/div/div/" +
            "main/div/section/div[4]/div[1]/div/div[3]/div/div[2]/div/div[1]/input");
    public static  By BUTTON_OTHER_TAG_INBLOCKREDACTOR = By.xpath("/html/body/div/div/div/main/div/section/" +
            "div[4]/div[1]/div/div[3]/div/div[2]/div/div[1]/div[2]/div");
    public static By buttonLogin = By.xpath("//span[text()='Вход через Госуслуги']");
    public static By AUTHO_BUTTON = By.xpath("//span[text()='Вход через Госуслуги']");
    public static By FIELD_MANAGER_LOGIN = By.xpath("//*[@id=\"username\"]");
    public static By FIELD_MANAGER_PASSWORD = By.xpath("//*[@id=\"password\"]");
    public static By BUTTON_LOGIN_MANAGER_PAGE = By.xpath("//*[@id=\"kc-login\"]");
    public static By BUTTON_RED_COVID19 = By.xpath("//*[@id=\"__layout\"]/div/header/div[2]/div[2]/div/a/h4");
    public static By CALCULATOR_BUTTON = By.xpath("//*[@id=\"__layout\"]/div/main/section/div[1]/div[1]/" +
            "div[3]/div[1]/div[1]/div/h2");
    public static By ZAGOLOVOC_SOC_CALC = By.xpath("//*[@id=\"__layout\"]/d" +
            "iv/main/section/div/div/section[1]/h2");
    public static  By OZDOROVLENIE_BUTTON = By.xpath("//*[@id=\"__layout\"]/div/main/section/div[1]/di" +
            "v[1]/div[4]/div[1]/div[1]/div/h2\n");
    public static By ZAGOLOVOC_OZDOROVLENIE = By.xpath("/html/body/div/div/div/main/section/div/div/h2");
    public static By BUTTON_CATALOG_GOS_USLUG = By.xpath("//*[@id=\"__layout\"]/div/main/section/div[1]/div[2]/div[1]/div[2]/div/a");
    public static By ZAGOLOVOC_CATALOG_GOS_USLUG = By.xpath("//*[@id=\"__layout\"]" +
            "/div/main/section/div/section/h2");
    public static  By BUTTON_MNENIE = By.xpath("//h2[contains(text(), 'Ваше мнение')]");
    public static  By BUTTON_CATALOG_SOC_USLUG = By.xpath("//*[contains(text(),'Каталог социальных услуг')]");
    public static  By ZAGOLOVOC_OPROS = By.xpath("//*[@id=\"__layout\"]/div/" +
            "section/div/div/div[1]/a[2]");
    public static By BUTTON_OTVET_NA_VOPROS = By.xpath("//*[@id=\"__layout\"]/div/main/section/section/div[3]/div[2]/" +
            "button/span[1]");
    public static By ZAGOLOVOC_OTVET_NA_VOPROS = By.xpath("//h2[contains(text(),'Ответы на вопросы')]");
    public static By BUTTON_MAP_SITE = By.xpath("//button[contains(text(), 'ПОКАЗАТЬ ВЕСЬ СПИСОК')]");
    public static By BUTTON_ADD_PAGE = By.xpath("//span[contains(text(), 'Добавить страницу')]");
    public static By FIELD_TYPE_PAGE = By.xpath("/html/body/div/div/div/main/div/div[1]/div/div[2]/div[1]/div/div[2]/div[1]");
    public static By FIELD_TYPE = By.xpath("/html/body/div/div/div/main/div/div[1]/div/div[2]/div[1]/div/input");
    public static By BUTTON_ADD_IN_BLOCKREDACTOR = By.xpath("/html/body/div/div/div/main/div/div[1]/div/div[2]/div[2]/button[1]");
    public static By FIELD_ZAGOLOVOC_IN_BLOCKREDACTOR = By.xpath("/html/body/div/div/div/main/div/section/div[4]/div[1]/" +
            "div/div[3]/div/div[1]/div/label/input");
    public static  By FIELD_CONTENT_IN_BLOCKREDACTOR = By.xpath("/html/body/div/div/div/main/div/secti" +
            "on/div[4]/div[1]/div/div[3]/div/div[4]/div/div/div[3]/div/div");
    public static  By BUTTON_PREDPROSMOTR_IN_BLOCKREDACTOR = By.xpath("/html/body/div/div/div/main/div/section/" +
            "div[4]/div[1]/div/div[5]/button[2]");
    public static By BUTTON_BLOCK_REDACTOR_IN_PREDMROSMOTR = By.xpath("//span[contains(text(),'Редактор информационных блоков')]");
    public static By BUTTON_SOTRUDNIK_ANTIMONOVA = By.xpath("//a[contains(text(), 'Антимонова Марина Юрьевна')]");
    public static By BUTTON_SOTRUDNIKI_MINVA_MAIN_PAGE = By.xpath("//div/h2[contains(text(),'Сотрудники Министерства')]/..");
    public static By BUTTON_ALL_BLOGS = By.xpath("//button[contains(text(),'ВСЕ ПУБЛИКАЦИИ')]");
    public static  By ZAGOLOVOK_NAME_SOZ_PORTAL = By.xpath("//div/header/div[2]/div[1]/div/div/a/h4");
    public static By FIZ_LIZO_BUTTON = By.xpath("//div/header/section[2]/div/div/div[1]");
    public static  By ZAGOLOVOC_SOC_PORTAL = By.xpath("//*[@id=\"__layout\"]/div/header/div[1]/div/div/div[1]/a[2]/h2");
    public static By SLIDER_BUTTON_MAIN_PAGE = By.xpath("/html/body/div/div/div/main/section/div[1]/div/div[4]");
    public static By BUTTON_PODROBNEE = By.xpath("/html/body/div/div/div/main/section/div[1]/div/div[1]/div[2]/div/div[2]/div/div[2]/button");
}
