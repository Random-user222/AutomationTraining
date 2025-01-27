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

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;
import static training.constants.MenuKeys.ELEMENT_MENU;
import static training.constants.SubMenuKeys.SUBMENU_ELEMENT;

public class WebElementTest extends BaseTest{

    //Metoda de Test pt sub-meniul Web Tables;
    @Test
    public void testWebTables() throws InterruptedException {
        homePage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        homePage.selectMenu(ELEMENT_MENU);
        logEvents(INFO_STEP, "Select Elements Menu from Home Page");
        commonPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        commonPage.selectSubMenu("Web Tables");
        logEvents(INFO_STEP, "Select Web Tables SubMenu from Common Page");
        WebTablePage webTablePage = new WebTablePage(driver);
        propertyUtility = new PropertyUtility("WebElementTest");
        Map<String, Object> webElementDataEntry = propertyUtility.getAllProperties();
        webTablePage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        webTablePage.fillEntireForm(webElementDataEntry);
        logEvents(INFO_STEP, "Filling the entire form using Data Properties");
//        webTablePage.validareFormular();
    }
}
