package page_object;

import mydrivers.DriverPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductSelectionPage extends DriverPage {

    public void ProductSelection(String Name){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> Selection= driver.findElements(By.cssSelector("a.itemName"));

        for (WebElement element:Selection){
            System.out.println(element.getText());
            if(element.getText().equals(Name)){
                element.sendKeys(Keys.ENTER);
                break;
            }
        }

    }
    public void randomProductSelection(){
        List<WebElement> Selection= driver.findElements(By.cssSelector("a.itemName"));
        Random random=new Random();
        int randomProduct = random.nextInt(Selection.size());
        Selection.get(randomProduct).sendKeys(Keys.ENTER);
    }
}
