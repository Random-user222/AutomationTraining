package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    }

    public void uploadThePicture(){
        elementsHelper.uploadFileToElement(uploadPictureElement);
    }

    @Override
    public void isPageLoaded() {
    }
}
