package training.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import training.pages.BrokenLinksPage;

public class BrokenLinksTest extends BaseTest{

    //Metoda de Test pt sub-meniul Broken Links - Images;
    @Test
    public void brokenLinksTest() {
        homePage.isPageLoaded();
        homePage.selectMenu("Elements");
        commonPage.isPageLoaded();
        commonPage.selectSubMenu("Broken Links - Images");
        BrokenLinksPage brokenLinksPage = new BrokenLinksPage(driver);
        brokenLinksPage.isPageLoaded();
        brokenLinksPage.clickOnValidLink();
        brokenLinksPage.isPageLoaded();
        homePage.selectMenu("Elements");
        commonPage.isPageLoaded();
        commonPage.selectSubMenu("Broken Links - Images");
        brokenLinksPage.isPageLoaded();
        brokenLinksPage.clickOnInvalidLink();
    }
}
