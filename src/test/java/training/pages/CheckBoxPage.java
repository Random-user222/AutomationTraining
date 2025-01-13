package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends BasePage{
    @FindBy(xpath = "//h1")
    private WebElement pageTitleElement;

    @FindBy (css = "#tree-node > ol > li > span > button > svg")
    private WebElement homeFolder;

    @FindBy (xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button")
    private WebElement desktopFolder;

    @FindBy (xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button")
    private WebElement documentsFolder;

    @FindBy (xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button")
    private WebElement workSpaceFolder;

    @FindBy (xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button")
    private WebElement officeFolder;

    @FindBy (css = "#tree-node > ol > li > ol > li:nth-child(3) > span > button > svg")
    private WebElement downloadsFolder;

    @FindBy (xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label/span[1]")
    private WebElement firstCheckBox;

    @FindBy (xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[1]/span/label/span[1]")
    private WebElement secondCheckBox;

    @FindBy (xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[3]/span/label/span[1]")
    private WebElement thirdCheckBox;

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    //Metoda unde chemam metodele pt a deschide foldere si de a le bifa;
    public void openingAndCheckingFolders(){
        openFolders();
        elementsHelper.scrollDownMethod();
        elementsHelper.threadSleep(2000);
        checkingBoxes();
    }

    //Metoda pt a deschide folderele;
    public void openFolders(){
        elementsHelper.clickElement(homeFolder);
        elementsHelper.clickElement(desktopFolder);
        elementsHelper.clickElement(documentsFolder);
        elementsHelper.clickElement(workSpaceFolder);
        elementsHelper.clickElement(officeFolder);
        elementsHelper.clickElement(downloadsFolder);
    }

    //Metoda pt a bifa folderele dorite;
    public void checkingBoxes(){
        elementsHelper.clickElement(firstCheckBox);
        elementsHelper.clickElement(secondCheckBox);
        elementsHelper.clickElement(thirdCheckBox);
    }

    @Override
    public void isPageLoaded() {

    }
}
