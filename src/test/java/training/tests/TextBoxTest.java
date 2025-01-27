package training.tests;
import org.testng.annotations.Test;
import training.pages.TextBoxPage;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;
import static training.constants.MenuKeys.ELEMENT_MENU;
import static training.constants.MenuKeys.FORMS_MENU;
import static training.constants.SubMenuKeys.*;

public class TextBoxTest extends BaseTest{

    //Metoda de Test pt sub-meniul Text Box;
    @Test
    public void textBoxMenuTest() {
        homePage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        homePage.selectMenu(ELEMENT_MENU);
        logEvents(INFO_STEP, "Select Element Menu from Home Page");
        commonPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        commonPage.selectSubMenu("Text Box");
        logEvents(INFO_STEP, "Select Text Box SubMenu from Common Page");
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        textBoxPage.fillFormFromTextBox();
        logEvents(INFO_STEP, "Fill the entire form");
    }
}
