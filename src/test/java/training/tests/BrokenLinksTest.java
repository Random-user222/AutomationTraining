package training.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import training.pages.BrokenLinksPage;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;

public class BrokenLinksTest extends BaseTest{

    //Metoda de Test pt sub-meniul Broken Links - Images;
    @Test
    public void brokenLinksTest() {
        homePage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Home Page is loaded correctly");
        homePage.selectMenu("Elements");
        logEvents(INFO_STEP, "Select Elements Menu from Home Page");
        commonPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Common Page is loaded correctly");
        commonPage.selectSubMenu("Broken Links - Images");
        logEvents(INFO_STEP, "Select Broken Links - Images from Common page");
        BrokenLinksPage brokenLinksPage = new BrokenLinksPage(driver);
        brokenLinksPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Broken Links Page is loaded correctly");
        brokenLinksPage.clickOnValidLink();
        logEvents(PASS_STEP, "Interact with a valid link");
        brokenLinksPage.isPageLoaded();
        logEvents(INFO_STEP, "Verify if Broken Links Page is loaded correctly");
        homePage.selectMenu("Elements");
        logEvents(INFO_STEP, "Select Elements Menu");
        commonPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Common Page is loaded correctly");
        commonPage.selectSubMenu("Broken Links - Images");
        logEvents(INFO_STEP, "Select Broken Links - Image from Common Page");
        brokenLinksPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Broken Links Page is loaded correctly");
        brokenLinksPage.clickOnInvalidLink();
        logEvents(INFO_STEP, "Interact with an invalid link");
    }
}
