package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;

public class FramePage extends BasePage{

    @FindBy(xpath = "//h1")
    private WebElement pageTitleElement;

    @FindBy (xpath = "//iframe[@id='frame1']")
    private WebElement frameOneElement;

    @FindBy (id = "sampleHeading")
    private WebElement sampleText;

    @FindBy (xpath = "//iframe[@id='frame2']")
    private WebElement frameTwoElement;


    public FramePage(WebDriver driver) {
        super(driver);
    }

    //Metoda pt a interactiona cu toate frame-urile;
    public void interactWithAllFrames(){
        interactiveFrameOne();
        interactiveFrameTwo();
        logEvents(INFO_STEP, "Interact with all frames from the page");
    }

    //Metode pt a interactiona cu fiecare frame;
    public void interactiveFrameOne (){
        frameHelpers.switchOnFrame(frameOneElement);
        logEvents(INFO_STEP, "Using Frame Helper to switch the focus to the frame");
        System.out.println("Testul din framu-ul 1 este: " + sampleText.getText());
        logEvents(PASS_STEP, "Interact with the frame and get the text form it");
        frameHelpers.switchToDefaultPage();
        logEvents(INFO_STEP, "Using Frame Helper to switch the focus to the default content");
    }

    public void interactiveFrameTwo (){
        frameHelpers.switchOnFrame(frameTwoElement);
        logEvents(INFO_STEP, "Using Frame Helper to switch the focus to the frame");
        System.out.println("Testul din framu-ul 2 este: " + sampleText.getText());
        logEvents(PASS_STEP, "Interact with the frame and get the text form it");
        frameHelpers.switchToDefaultPage();
        logEvents(INFO_STEP, "Using Frame Helper to switch the focus to the default content");
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(pageTitleElement.getText(), "Frames", "Title is invalid and actual value is: " +pageTitleElement.getText());
    }
}
