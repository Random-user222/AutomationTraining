package training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import propertyUtility.PropertyUtility;
import training.pages.WebTablePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static training.constants.MenuKeys.ELEMENT_MENU;
import static training.constants.SubMenuKeys.SUBMENU_ELEMENT;

public class WebElementTest extends BaseTest{

    //Metoda de Test pt sub-meniul Web Tables;
    @Test
    public void testWebTables() throws InterruptedException {
        homePage.isPageLoaded();
        homePage.selectMenu(ELEMENT_MENU);
        commonPage.isPageLoaded();
        commonPage.selectSubMenu("Web Tables");
        WebTablePage webTablePage = new WebTablePage(driver);
        propertyUtility = new PropertyUtility("WebElementTest");
        Map<String, Object> webElementDataEntry = propertyUtility.getAllProperties();
        webTablePage.isPageLoaded();
        webTablePage.fillEntireForm(webElementDataEntry);
//        webTablePage.validareFormular();
    }
}
