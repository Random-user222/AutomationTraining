package training.tests;

import org.testng.annotations.Test;
import training.pages.CheckBoxPage;

import static training.constants.MenuKeys.ELEMENT_MENU;

public class CheckBoxTest extends BaseTest{

    //Metoda de Test pt sub-meniul Check Box;
    @Test
    public void checkBoxMenuTest() {
        homePage.isPageLoaded();
        homePage.selectMenu(ELEMENT_MENU);
        commonPage.isPageLoaded();
        commonPage.selectSubMenu("Check Box");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.isPageLoaded();
        checkBoxPage.openingAndCheckingFolders();
    }
}
