package training.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import training.pages.AlertsPage;
import training.pages.HomePage;
import static training.constants.MenuKeys.ALERTS_FRAMES_WINDOWS_MENU;
import static training.constants.SubMenuKeys.ALERTS_SUBMENU;
import static training.constants.SubMenuKeys.FRAMES_SUBMENU;

import java.time.Duration;

public class AlertsTest extends BaseTest{

    //Metode de Test pt sub-meniul Alerts;
    @Test
    public void testAlertsFrameWindows() {
        homePage.isPageLoaded();
        homePage.selectMenu(ALERTS_FRAMES_WINDOWS_MENU);
        commonPage.isPageLoaded();
        commonPage.selectSubMenu(ALERTS_SUBMENU);
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.isPageLoaded();
        alertsPage.interactWithAllAlerts("Alerts Test");
    }
}
