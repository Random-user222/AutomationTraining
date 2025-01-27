package training.tests;

import org.testng.annotations.Test;
import training.helpers.ElementsHelper;
import training.pages.ButtonsPage;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;

public class ButtonsTest extends BaseTest{

    //Metoda de Test pt sub-meniul Buttons;
    @Test
    public void buttonsPageTest() {
        ElementsHelper elementsHelper = new ElementsHelper(driver);
        homePage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Common Page is loaded correctly");
        homePage.selectMenu("Elements");
        logEvents(INFO_STEP, "Select Elements from Home Page");
        commonPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Common Page is loaded correctly");
        commonPage.selectSubMenu("Buttons");
        logEvents(INFO_STEP, "Select Buttons SubMenu from Common Page");
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Common Page is loaded correctly");
        buttonsPage.interactWithAllButtons();
        logEvents(PASS_STEP, "Interact with all the buttons from Buttons Page");
    }
}
