package training.tests;

import org.testng.annotations.Test;
import training.pages.HomePage;
import training.pages.RadioButtonsPage;

public class RadioButtonsTest extends BaseTest{

    //Metoda de Test pt sub-meniul Radio Button;
    @Test
    public void radioButtonsTest() {
        homePage.isPageLoaded();
        homePage.selectMenu("Elements");
        commonPage.isPageLoaded();
        commonPage.selectSubMenu("Radio Button");
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage(driver);
        radioButtonsPage.isPageLoaded();
        radioButtonsPage.selectAnOption("Impressive");
        radioButtonsPage.isPageLoaded();
        radioButtonsPage.printTheQuestion();
        radioButtonsPage.printTheAnswer();
    }
}
