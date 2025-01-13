package training.tests;

import org.testng.annotations.Test;
import training.helpers.ElementsHelper;
import training.pages.LinksPage;

public class LinksTest extends BaseTest{

    //Metoda de Test pt sub-meniul Links;
    @Test
    public void linksPageTest() {
        homePage.isPageLoaded();
        homePage.selectMenu("Elements");
        commonPage.isPageLoaded();
        commonPage.selectSubMenu("Links");
        LinksPage linksPage = new LinksPage(driver);
        linksPage.isPageLoaded();
        linksPage.firstLinkWithResponse();
    }
}
