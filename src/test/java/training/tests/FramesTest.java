package training.tests;

import org.testng.annotations.Test;
import training.pages.FramePage;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;
import static training.constants.MenuKeys.ALERTS_FRAMES_WINDOWS_MENU;
import static training.constants.SubMenuKeys.FRAMES_SUBMENU;

public class FramesTest extends BaseTest{

    //Metoda de Test pt sub-meniul Frames;
    @Test
    public void framesTest() {
        homePage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Home Page is loaded correctly");
        homePage.selectMenu(ALERTS_FRAMES_WINDOWS_MENU);
        logEvents(INFO_STEP, "Select Alerts Frames and Windows Menu from Home Page");
        commonPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Home Page is loaded correctly");
        commonPage.selectSubMenu(FRAMES_SUBMENU);
        logEvents(INFO_STEP, "Select Frames SubMenu from Common Page");
        FramePage framePage = new FramePage(driver);
        framePage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Home Page is loaded correctly");
        framePage.interactWithAllFrames();
        logEvents(PASS_STEP, "Interact with all the frames from the page");
    }
}
