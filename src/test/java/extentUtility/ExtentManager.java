package extentUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

import static extentUtility.ReportEventType.*;


public class ExtentManager {

    private static String pathToProject = System.getProperty("user.dir") + "/target/extentReports/";
    private static ExtentReports extentReports;
    private static ConcurrentHashMap <String, ExtentTest> context = new ConcurrentHashMap<>();

    //Facem o metoda care sa creeze un folder;
    private static void createDirectory(){
        File directory = new File(pathToProject);
        if (!directory.exists()){
            directory.mkdirs();
        }
    }

    //Facem o metoda care sa initializeze raportul HTML;
    public static synchronized void initializeReport(){
        createDirectory();

        //SparkReporter se ocupa de personalizarea UI/Raportului;
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(pathToProject + "ExtentReport.html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Test Report");
        htmlReporter.config().setReportName("Automated Test Results");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    //Facem o metoda care sa faca un ExtentTest pentru fiecare test;
    public static synchronized void createTest(String testName){
        ExtentTest testReport = extentReports.createTest(testName + " - report");
        context.put(Thread.currentThread().getName(), testReport);
        logEvents(INFO_STEP, "--- START TEST --- " +testName);
    }

    //Facem o metoda care sa logheze informatia;
    public static synchronized void logEvents(String eventType, String message){
        String threadName = Thread.currentThread().getName();
        if (eventType.equals(INFO_STEP)){
            context.get(threadName).log(Status.INFO, message);
        }
        if (eventType.equals(PASS_STEP)){
            context.get(threadName).log(Status.PASS, message);
        }
    }

    //Facem o metoda care sa inchida cu un mesaj ExtentTest-ul;
    public static synchronized void finishTest(String testName){
        logEvents(INFO_STEP, "--- FINISH TEST --- " +testName);
    }

    //Facem o metoda care sa genereze raportul final;
    public static synchronized void generateReport(){
        extentReports.flush();
    }

    //Facem o metoda care sa logheze informatia cand testul cade si sa ataseze un screenshot;
    public static synchronized void logFailWithScreenshot(String message, WebDriver driver){
        String threadName = Thread.currentThread().getName();
        context.get(threadName).fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenShot(driver)).build());
    }

    //Facem o metoda care sa faca un screenshot;
    private static String getScreenShot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}
