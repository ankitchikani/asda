import mydrivers.DriverPage;
import org.junit.Test;
import org.openqa.selenium.TakesScreenshot;
import page_object.*;
import utility.TakeScreenShot;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RegressionTestPack extends Hook {
    HeaderPage headerPage=new HeaderPage();
    TakeScreenShot tsc= new TakeScreenShot();
    FilterSelectionPage filterSelectionPage= new FilterSelectionPage();
    ProductSelectionPage productSelectionPage=new ProductSelectionPage();
    ProductDiscriptionPage productDiscriptionPage=new ProductDiscriptionPage();
    BasketPage basketPage=new BasketPage();

   @Test
    public void first(){
       headerPage.doSearch("cadbury");
        TakeScreenShot.CaptureScreenShot("searchpage");

    }
    @Test
    public void xYz(){
        headerPage.hoverToPrimaryNavItems("WOMEN");
        headerPage.SelectFromPrimaryNavItems("Dresses");
        filterSelectionPage.SelectFilter("Product Type");
        filterSelectionPage.SelectfromFilter("Dress");
        productSelectionPage.randomProductSelection();
        productDiscriptionPage.randomSizeSelection();
        filterSelectionPage.ClickaddToBasket();
        String ActualResult=productDiscriptionPage.getProductName();
        System.out.println(ActualResult);
        basketPage.HoverOnBasket();
        basketPage.SelectFromBasket("CHECKOUT");
        //basketPage.clickOnViewBasket();
       //productDiscriptionPage.clickOnBasket();
        String ExpectedResult=basketPage.getResult();
        System.out.println(ExpectedResult);
        //assertEquals(ExpectedResult,ActualResult);
        //assertThat(ActualResult,"ExpectedResult");
        assertThat(ActualResult, is(equalTo(ExpectedResult)));

    }

}
