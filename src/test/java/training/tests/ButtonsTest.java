package training.tests;

import org.testng.annotations.Test;
import training.helpers.ElementsHelper;
import training.pages.ButtonsPage;

public class ButtonsTest extends BaseTest{

    //Metoda de Test pt sub-meniul Buttons;
    @Test
    public void buttonsPageTest() {
        ElementsHelper elementsHelper = new ElementsHelper(driver);
        homePage.isPageLoaded();
        homePage.selectMenu("Elements");
        commonPage.isPageLoaded();
        commonPage.selectSubMenu("Buttons");
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.isPageLoaded();
        buttonsPage.doubleClick();
        buttonsPage.rightClick();
        buttonsPage.normalClickButton();
    }
}
