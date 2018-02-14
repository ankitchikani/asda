package page_object;

import mydrivers.DriverPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductDiscriptionPage extends DriverPage{

    public void randomSizeSelection(){
        List<WebElement> ProductSizes=driver.findElements(By.cssSelector("a.sizeElement"));
        Random random= new Random();
        int randomSizes=random.nextInt(ProductSizes.size());
        ProductSizes.get(randomSizes).sendKeys(Keys.ENTER);
        // System.out.println(randomSizes);
    }
    public String  getProductName(){
        String GetProductName=driver.findElement(By.cssSelector(".product-name")).getText();
        System.out.println(GetProductName);
        //assertEquals(driver.findElement(By.cssSelector(".product-name")).getText(),(driver.findElement(By.cssSelector(".lineItem-title")).getText()));
        return GetProductName;
    }
    public void clickOnBasket(){
        driver.findElement(By.cssSelector(".basketLabel")).click();
    }

}
