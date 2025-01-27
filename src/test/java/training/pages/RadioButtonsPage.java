package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;

import java.util.List;

public class RadioButtonsPage extends BasePage{
    @FindBy (xpath = "//div[@class='mb-3']")
    private WebElement getQuestion;

    @FindBy (xpath = "//label[@class='custom-control-label']")
    private List <WebElement> option;

    @FindBy (xpath = "//p[@class='mt-3']")
    private WebElement getAnswer;

    public RadioButtonsPage(WebDriver driver) {
        super(driver);
    }

    //Metode specifice pt a printa in consola un text de pe site;
    public void printTheQuestion(){
        System.out.println("The question is: " +getQuestion.getText());
        logEvents(INFO_STEP, "Printing the questions from the site");
    }

    public void selectAnOption(String answer) {
        elementsHelper.selectElementByTextFromList(answer, option);
    }

    public void printTheAnswer(){
        System.out.println("Your answer is: " +getAnswer.getText());
        logEvents(INFO_STEP, "Printing the answer from the question above");
    }

    @Override
    public void isPageLoaded() {

    }
}
