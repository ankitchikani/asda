package page_object;

import mydrivers.DriverPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HeaderPage extends DriverPage{

    public void hoverToPrimaryNavItems(String PrimarySearch){

        List<WebElement> Hearderelements= driver.findElements(By.cssSelector(".tablink"));

        for(WebElement element:Hearderelements){
            System.out.println(element.getText());

            if(element.getText().equalsIgnoreCase(PrimarySearch)){
                new Actions(driver).moveToElement(element).build().perform();
                break;

            }
        }
    }

    public void SelectFromPrimaryNavItems(String CategoryItemName){
        List<WebElement>listofItems= driver.findElements(By.cssSelector(".l3cat>a"));
        //new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(element));

        for(WebElement Selectitem: listofItems){
            System.out.println(Selectitem.getText());
            if (Selectitem.getText().equalsIgnoreCase(CategoryItemName)){
                Selectitem.click();
                break;
            }
        }
    }



    public void doSearch(String searchItem){
        driver.findElement(By.xpath("html/body/div[1]/div[4]/div[2]/div[3]/div[4]/div/div[2]/label/form/input")).sendKeys(searchItem);
        driver.findElement(By.xpath("html/body/div[1]/div[4]/div[2]/div[3]/div[4]/div/a")).click();

    }
}
