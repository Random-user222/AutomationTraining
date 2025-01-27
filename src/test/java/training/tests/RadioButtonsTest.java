package training.tests;

import org.testng.annotations.Test;
import training.pages.HomePage;
import training.pages.RadioButtonsPage;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;

public class RadioButtonsTest extends BaseTest{

    //Metoda de Test pt sub-meniul Radio Button;
    @Test
    public void radioButtonsTest() {
        homePage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        homePage.selectMenu("Elements");
        logEvents(INFO_STEP, "Select Elements Menu from Home Page");
        commonPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        commonPage.selectSubMenu("Radio Button");
        logEvents(INFO_STEP, "Select Radio Buttons SubMenu from Common Page");
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage(driver);
        radioButtonsPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        radioButtonsPage.selectAnOption("Impressive");
        logEvents(INFO_STEP, "Select one option from the list");
        radioButtonsPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        radioButtonsPage.printTheQuestion();
        radioButtonsPage.printTheAnswer();
        logEvents(INFO_STEP, "Print the question and answer");
    }
}
