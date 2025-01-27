package training.tests;

import org.testng.annotations.Test;
import training.pages.CheckBoxPage;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;

import static extentUtility.ReportEventType.PASS_STEP;
import static training.constants.MenuKeys.ELEMENT_MENU;

public class CheckBoxTest extends BaseTest{

    //Metoda de Test pt sub-meniul Check Box;
    @Test
    public void checkBoxMenuTest() {
        homePage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Home Page is loaded correctly");
        homePage.selectMenu(ELEMENT_MENU);
        logEvents(INFO_STEP, "Select Element Menu from Home Page");
        commonPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Home Page is loaded correctly");
        commonPage.selectSubMenu("Check Box");
        logEvents(INFO_STEP, "Select CheckBox SubMenu from Common Page");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Home Page is loaded correctly");
        checkBoxPage.openingAndCheckingFolders();
        logEvents(INFO_STEP, "Interact and check boxes on the site");
    }
}
