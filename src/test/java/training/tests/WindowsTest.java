package training.tests;

import org.testng.annotations.Test;
import training.pages.BasePage;
import training.pages.WindowsPage;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;
import static training.constants.MenuKeys.ALERTS_FRAMES_WINDOWS_MENU;
import static training.constants.MenuKeys.FORMS_MENU;
import static training.constants.SubMenuKeys.PRACTICE_FORM_SUBMENU;
import static training.constants.SubMenuKeys.WINDOWS_SUBMENU;

public class WindowsTest extends BaseTest {

    //Metoda de Test pt sub-meniul Browser Windows;
    @Test
    public void windowsTest() {
        homePage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        homePage.selectMenu(ALERTS_FRAMES_WINDOWS_MENU);
        logEvents(INFO_STEP, "Select Alerts Frames and Windows Menu from Home Page");
        commonPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        commonPage.selectSubMenu(WINDOWS_SUBMENU);
        logEvents(INFO_STEP, "Select Windows SubMenu from Common Page");
        WindowsPage windowsPage = new WindowsPage(driver);
        windowsPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        windowsPage.interactWithAllWindowsOrTabs();
        logEvents(INFO_STEP, "Interact with all the windows buttons from the page");
    }
}
