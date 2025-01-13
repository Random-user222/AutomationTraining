package training.tests;

import org.testng.annotations.Test;
import training.pages.BasePage;
import training.pages.WindowsPage;

import static training.constants.MenuKeys.ALERTS_FRAMES_WINDOWS_MENU;
import static training.constants.MenuKeys.FORMS_MENU;
import static training.constants.SubMenuKeys.PRACTICE_FORM_SUBMENU;
import static training.constants.SubMenuKeys.WINDOWS_SUBMENU;

public class WindowsTest extends BaseTest {

    //Metoda de Test pt sub-meniul Browser Windows;
    @Test
    public void windowsTest() {
        homePage.isPageLoaded();
        homePage.selectMenu(ALERTS_FRAMES_WINDOWS_MENU);
        commonPage.isPageLoaded();
        commonPage.selectSubMenu(WINDOWS_SUBMENU);
        WindowsPage windowsPage = new WindowsPage(driver);
        windowsPage.isPageLoaded();
        windowsPage.interactWithAllWindowsOrTabs();
    }
}
