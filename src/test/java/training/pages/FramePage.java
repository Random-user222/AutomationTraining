package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
    }

    //Metode pt a interactiona cu fiecare frame;
    public void interactiveFrameOne (){
        frameHelpers.switchOnFrame(frameOneElement);
        System.out.println("Testul din framu-ul 1 este: " + sampleText.getText());
        frameHelpers.switchToDefaultPage();
    }

    public void interactiveFrameTwo (){
        frameHelpers.switchOnFrame(frameTwoElement);
        System.out.println("Testul din framu-ul 2 este: " + sampleText.getText());
        frameHelpers.switchToDefaultPage();
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(pageTitleElement.getText(), "Frames", "Title is invalid and actual value is: " +pageTitleElement.getText());
    }
}
