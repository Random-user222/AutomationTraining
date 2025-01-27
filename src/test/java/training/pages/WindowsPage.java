package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;

public class WindowsPage extends BasePage{

    @FindBy(xpath = "//h1")
    private WebElement pageTitleElement;

    @FindBy (xpath = "//button[@id='tabButton']")
    private WebElement newTabElement;

    @FindBy (id = "sampleHeading")
    private WebElement sampleText;

    @FindBy (xpath = "//button[@id='windowButton']")
    private WebElement newWindowElement;

    @FindBy (xpath = "//button[@id='messageWindowButton']")
    private WebElement newWindowMessage;

    @FindBy (xpath = "//body")
    private WebElement messageText;

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    //Metode specifice pt a interactiona cu tab-uri sau windows;
    public void interactWithAllWindowsOrTabs(){
        clickNewTab();
        clickOnNewWindow();
    }

    //Metode specifice pt a deschide si inchide tab-urile sau noile ferestre deschise;
    public void clickNewTab() {
        elementsHelper.clickElement(newTabElement);
        logEvents(INFO_STEP, "Open a new tab by clicking the button on the page");
        windowHelpers.switchToWindow(1);
        logEvents(PASS_STEP, "Using Window Helper to switch to the new tab");
        System.out.println("Textul din noul tab este: " +sampleText.getText());
        windowHelpers.closeWindowOrTab();
        logEvents(PASS_STEP, "Using Window Helper to close the new tab");
        windowHelpers.switchToWindow(0);
        logEvents(INFO_STEP, "Using Window Helper to switch the focus to the previous tab");
    }

    public void clickOnNewWindow(){
        elementsHelper.clickElement(newWindowElement);
        logEvents(INFO_STEP, "Open a new window by clicking the button on the page");
        windowHelpers.switchToWindow(1);
        logEvents(PASS_STEP, "Using Window Helper to switch to the new window");
        System.out.println("Textul din noua fereastra este: " +sampleText.getText());
        windowHelpers.closeWindowOrTab();
        logEvents(PASS_STEP, "Using Window Helper to close the new window");
        windowHelpers.switchToWindow(0);
        logEvents(INFO_STEP, "Using Window Helper to switch the focus to the previous window");
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(pageTitleElement.getText(), "Browser Windows", "Title is invalid and actual value is: " +pageTitleElement.getText());
    }
}
