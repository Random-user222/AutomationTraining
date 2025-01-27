package training.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import training.pages.AlertsPage;
import training.pages.HomePage;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;
import static training.constants.MenuKeys.ALERTS_FRAMES_WINDOWS_MENU;
import static training.constants.SubMenuKeys.ALERTS_SUBMENU;
import static training.constants.SubMenuKeys.FRAMES_SUBMENU;

import java.time.Duration;

public class AlertsTest extends BaseTest{

    //Metode de Test pt sub-meniul Alerts;
    @Test
    public void testAlertsFrameWindows() {
        homePage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        homePage.selectMenu(ALERTS_FRAMES_WINDOWS_MENU);
        logEvents(INFO_STEP, "Select Alerts Frames and Windows Menu from Home Page");
        commonPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        commonPage.selectSubMenu(ALERTS_SUBMENU);
        logEvents(INFO_STEP, "Select Alerts SubMenu from Common Page");
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        alertsPage.interactWithAllAlerts("Alerts Test");
        logEvents(PASS_STEP, "Interact with all the alerts from Alerts Page");
    }
}
