package training.tests;

import org.testng.annotations.Test;
import training.helpers.ElementsHelper;
import training.pages.UploadDownloadPage;

public class UploadDownloadTest extends BaseTest{

    //Metoda de Test pt sub-meniul Upload and Download;
    @Test
    public void uploadDownloadPageTest() {
    homePage.selectMenu("Elements");
    commonPage.selectSubMenu("Upload and Download");
    commonPage.isPageLoaded();
    ElementsHelper elementsHelper = new ElementsHelper(driver);
    elementsHelper.scrollDownMethod();
    UploadDownloadPage uploadDownloadPage = new UploadDownloadPage(driver);
    uploadDownloadPage.isPageLoaded();
    uploadDownloadPage.downloadTheImage();
//    uploadDownloadPage.uploadThePicture();
    }
}
