package page_object;

import mydrivers.DriverPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasketPage extends DriverPage {

    /*@FindBy(css = ".lineItem-title")
    private WebElement resultsText;
*/

    public String getResult(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String ExpectedProductName=driver.findElement(By.cssSelector(".lineItem-title")).getText();
        System.out.println(ExpectedProductName);
        return ExpectedProductName;
    }

    public void ClickToBasket(){
        driver.findElement(By.id("pdpAddToBasket")).sendKeys(Keys.ENTER);
    }

    public void hooverOnUserControl(String UserControl) {
        List<WebElement> Header_Right = driver.findElements(By.id("userControls"));

        for (WebElement element : Header_Right) {
            System.out.println(element.getText());

            if (element.getText().contains(UserControl)) {
                new Actions(driver).moveToElement(element).click().build().perform();
                break;
        /*WebElement element= driver.findElement(By.cssSelector(".basketLabel"));
        new Actions(driver).moveToElement(element).build().perform();
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(element));*/
       /* List<WebElement>BottomofBasket=driver.findElements(By.cssSelector(".basketBottom"));
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(element));
        System.out.println(BottomofBasket.size());
        for(WebElement Elements:BottomofBasket){
            if(Elements.getText().contains((basketLebel))){
            Elements.sendKeys(Keys.ENTER);
            break;
            }
        }*/
            }
        }
    }
    public void HoverOnBasket(){
        WebElement element= driver.findElement(By.cssSelector(".basketImg.expandMinicart.hover"));
        new Actions(driver).moveToElement(element).click().perform();
    }


    public void SelectFromBasket(String BasketCheckoutBtn){

        List<WebElement>BottomofBasket=driver.findElements(By.cssSelector("#basketBottom"));
        System.out.println(BottomofBasket.size());
        for(WebElement Elements:BottomofBasket){
            if(Elements.getText().contains((BasketCheckoutBtn))){
                new Actions(driver).moveToElement(Elements).sendKeys(Keys.ENTER).perform();
                break;
            }
        }
    }
    public void clickOnViewBasket(){

        driver.findElement(By.cssSelector(".viewBasketButton")).sendKeys(Keys.ENTER);
    }
}
