package training.tests;

import org.testng.annotations.Test;
import training.helpers.ElementsHelper;
import training.pages.UploadDownloadPage;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;

public class UploadDownloadTest extends BaseTest{

    //Metoda de Test pt sub-meniul Upload and Download;
    @Test
    public void uploadDownloadPageTest() {
    homePage.selectMenu("Elements");
    logEvents(INFO_STEP, "Select Elements Menu from Home Page");
    commonPage.selectSubMenu("Upload and Download");
    logEvents(INFO_STEP, "Select Upload And Download SubMenu from Common Page");
    commonPage.isPageLoaded();
    logEvents(PASS_STEP, "Verify if the page is loaded correctly");
    ElementsHelper elementsHelper = new ElementsHelper(driver);
    elementsHelper.scrollDownMethod();
    UploadDownloadPage uploadDownloadPage = new UploadDownloadPage(driver);
    uploadDownloadPage.isPageLoaded();
    logEvents(PASS_STEP, "Verify if the page is loaded correctly");
    uploadDownloadPage.downloadTheImage();
//    uploadDownloadPage.uploadThePicture();
    logEvents(INFO_STEP, "Download an image and upload an imagine after");
    }
}
