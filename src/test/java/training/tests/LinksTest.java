package training.tests;

import org.testng.annotations.Test;
import training.helpers.ElementsHelper;
import training.pages.LinksPage;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;

public class LinksTest extends BaseTest{

    //Metoda de Test pt sub-meniul Links;
    @Test
    public void linksPageTest() {
        homePage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Home Page is loaded correctly");
        homePage.selectMenu("Elements");
        logEvents(INFO_STEP, "Select Element Menu from Home Page");
        commonPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Home Page is loaded correctly");
        commonPage.selectSubMenu("Links");
        logEvents(INFO_STEP, "Select Links SubMenu from Common Page");
        LinksPage linksPage = new LinksPage(driver);
        linksPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if Home Page is loaded correctly");
        linksPage.firstLinkWithResponse();
        logEvents(PASS_STEP, "Interact with all the links from the page");
    }
}
