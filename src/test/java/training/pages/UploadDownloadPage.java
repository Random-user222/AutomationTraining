package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;

public class UploadDownloadPage extends BasePage{
    @FindBy (id = "downloadButton")
    private WebElement downloadButtonElement;

    @FindBy (id = "uploadFile")
    private WebElement uploadPictureElement;

    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }

    //Metode de download or upload o imagine;
    public void downloadTheImage(){
        elementsHelper.clickElement(downloadButtonElement);
        logEvents(INFO_STEP, "Download the picture from the site");
    }

    public void uploadThePicture(){
        elementsHelper.uploadFileToElement(uploadPictureElement);
        logEvents(INFO_STEP, "Upload the picture to the site");
    }

    @Override
    public void isPageLoaded() {
    }
}
