package training.tests;
import org.testng.annotations.Test;
import training.pages.TextBoxPage;

import static training.constants.MenuKeys.ELEMENT_MENU;
import static training.constants.MenuKeys.FORMS_MENU;
import static training.constants.SubMenuKeys.*;

public class TextBoxTest extends BaseTest{

    //Metoda de Test pt sub-meniul Text Box;
    @Test
    public void textBoxMenuTest() {
        homePage.isPageLoaded();
        homePage.selectMenu(ELEMENT_MENU);
        commonPage.isPageLoaded();
        commonPage.selectSubMenu("Text Box");
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.isPageLoaded();
        textBoxPage.fillFormFromTextBox();

    }
}
