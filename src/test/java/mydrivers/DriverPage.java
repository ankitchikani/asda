package mydrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverPage {
    public static WebDriver driver;
    public static WebElement element;
    String openbrowser = "ChromeDriver";
    public static Actions action;


    /*public DriverPage(){
        PageFactory.initElements(driver,this);
    }*/
    public void browser() {

        switch (openbrowser) {
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ChromeDriver":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "IEbrowser":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("if you want to change browser type then go to mydriver.BaseTest_Driver class and change from there.");
                driver = new FirefoxDriver();
        }
    }
    public void navigateTo(String URL){
        driver.get(URL);
        System.out.println("Title of Page: " + driver.getTitle());
    }
    public void applyMaximizeScreen(){
        driver.manage().window().maximize();
    }
    public void applyImplicitWait(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void hoverActions(){
        Actions actions=new Actions(driver);
    }
    public void deleteAllCockies(){
        driver.manage().deleteAllCookies();
    }
    public void closeBroser(){
        driver.quit();
    }

}
