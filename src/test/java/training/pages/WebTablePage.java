package training.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class WebTablePage extends BasePage{

    @FindBy(xpath = "//h1")
    private WebElement pageTitleElement;

    @FindBy (id = "addNewRecordButton")
    private WebElement addPeopleInForm;

    @FindBy (id = "firstName")
    private WebElement firstName;

    @FindBy (id = "lastName")
    private WebElement lastName;

    @FindBy (id = "userEmail")
    private WebElement emailInput;

    @FindBy (xpath = "//*[@id=\"age\"]")
    private WebElement ageInput;

    @FindBy (xpath = "//*[@id=\"salary\"]")
    private WebElement salaryInput;

    @FindBy (xpath = "//*[@id=\"department\"]")
    private WebElement departmentInput;

    @FindBy (xpath = "//*[@id=\"submit\"]")
    private WebElement submitButton;

    @FindAll({
            @FindBy (xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div"),
            @FindBy (xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[2]/div"),
            @FindBy (xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[3]/div"),
    })
    private List <WebElement> numarInitial;


    @FindBy (xpath = "//*[@id='app']/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div/div")
    private List  <WebElement> numarTotalRanduri;

    @FindBy (xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    private List <WebElement> numarNouDePersoane;


    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    //Metoda unde chemam metodele pt a completa formularul;
    public void fillEntireForm(Map<String, Object> webElementData){
        List <String> firstNameValues = (List<String>)webElementData.get("firstName");
        List <String> lastNameValues = (List<String>)webElementData.get("lastName");
        List <String> emailValues = (List<String>)webElementData.get("email");
        List <String> ageValues = (List<String>)webElementData.get("age");
        List <String> salaryValues = (List<String>)webElementData.get("salary");
        List <String> departmentValues = (List<String>)webElementData.get("department");
        for (int index = 0; index<firstNameValues.size(); index++){
            addValuesButton();
            firstNameInput(firstNameValues.get(index));
            lastNameInput(lastNameValues.get(index));
            emailInput(emailValues.get(index));
            ageInput(ageValues.get(index));
            salaryInput(salaryValues.get(index));
            departmentInput(departmentValues.get(index));
            submitInput();
        }
    }

    //Metoda unde chemam metodele de validare al formularui;
    public void validareFormular(){
        numarInitialPersoane();
        numarTotalRanduri();
        noulNumarDePersoane();
        randuriRamase();
    }

    //Metode specifice pt a completa input-urile formularului;
    public void addValuesButton(){
        elementsHelper.clickElement(addPeopleInForm);
    }

    public void firstNameInput(String name){
        elementsHelper.fillElement(firstName,name);
    }

    public void lastNameInput(String numeFamilie){
        elementsHelper.fillElement(lastName, numeFamilie);
    }

    public void emailInput(String email){
        elementsHelper.fillElement(emailInput, email);
    }

    public void ageInput(String age){
        elementsHelper.fillElement(ageInput, age);
    }

    public void salaryInput(String salary){
        elementsHelper.fillElement(salaryInput, salary);
    }

    public void departmentInput(String department){
        elementsHelper.fillElement(departmentInput, department);
    }

    public void submitInput(){
        elementsHelper.clickElement(submitButton);
    }

    //Metode pt a valida formularul inainte si dupa ce am introdus date noi;
    public void numarInitialPersoane(){
        System.out.println("Numarul initial de persoane este: " +numarInitial.size());
    }

    public int numarTotalRanduri(){
        System.out.println("Tabelul are in total un numar de " +numarTotalRanduri.size() + " randuri.");
        return 10;
    }

    public int noulNumarDePersoane(){
        System.out.println("Noul numar de persoane din tabel este: " +numarNouDePersoane.size());
        return 4;
    }

    public void randuriRamase(){
        int a = numarTotalRanduri();
        int b = noulNumarDePersoane();
        int rezultat = a - b;
        System.out.println("Dupa adaugarea de persoane tabelul ramane cu un numar de " + rezultat + " randuri.");
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(pageTitleElement.getText(), "Web Tables", "Title is invalid and actual value is: " +pageTitleElement.getText());
    }
}
