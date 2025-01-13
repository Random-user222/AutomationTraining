package training.tests;

import org.testng.annotations.Test;
import training.pages.FramePage;
import static training.constants.MenuKeys.ALERTS_FRAMES_WINDOWS_MENU;
import static training.constants.SubMenuKeys.FRAMES_SUBMENU;

public class FramesTest extends BaseTest{

    //Metoda de Test pt sub-meniul Frames;
    @Test
    public void framesTest() {
        homePage.isPageLoaded();
        homePage.selectMenu(ALERTS_FRAMES_WINDOWS_MENU);
        commonPage.isPageLoaded();
        commonPage.selectSubMenu(FRAMES_SUBMENU);
        FramePage framePage = new FramePage(driver);
        framePage.isPageLoaded();
        framePage.interactWithAllFrames();
    }
}
