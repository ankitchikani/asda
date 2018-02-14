package page_object;

import mydrivers.DriverPage;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class FilterSelectionPage extends DriverPage{
    public String GetProductName;

    public void SelectFilter(String Filter){

        List<WebElement>Filtername= driver.findElements(By.className("focText"));
        for (WebElement element: Filtername){
            //new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(element));
            System.out.println(element.getText());
            if(element.getText().equalsIgnoreCase(Filter)) {
                element.click();
                break;
            }
        }
    }

    public void SelectfromFilter(String filterBy){

        List<WebElement> Selection= driver.findElements(By.cssSelector(".refineLink"));
        for (WebElement element:Selection){
            System.out.println(element.getText());
            if(element.getText().contains(filterBy)){
                new Actions(driver).moveToElement(element).click().build().perform();
               break;

            }
        }
    }



    public void ClickaddToBasket(){
        driver.findElement(By.id("pdpAddToBasket")).sendKeys(Keys.ENTER);
    }


}
