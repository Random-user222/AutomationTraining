package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;

public class BrokenLinksPage extends BasePage{
    @FindBy (xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/a[1]")
    private WebElement validLink;

    @FindBy (xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/a[2]")
    private WebElement invalidLink;

    public BrokenLinksPage(WebDriver driver) {
        super(driver);
    }

    //Metode care sa interactioneze cu link-uri;
    public void clickOnValidLink(){
        elementsHelper.clickElement(validLink);
        logEvents(INFO_STEP, "Click on a valid link");
    }

    public void clickOnInvalidLink(){
        elementsHelper.clickElement(invalidLink);
        logEvents(INFO_STEP, "Click on an invalid link");
    }

    @Override
   public void isPageLoaded() {

    }
}
