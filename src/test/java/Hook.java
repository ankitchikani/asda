import mydrivers.DriverPage;
import org.junit.After;
import org.junit.Before;

public class Hook extends DriverPage {

    DriverPage base= new DriverPage();
    @Before
    public void setUp(){
        base.browser();
        base.navigateTo("http://direct.asda.com/");
        base.applyMaximizeScreen();
        base.applyImplicitWait();
        base.deleteAllCockies();
        base.hoverActions();
    }

    @After
    public void tearDown(){
       base.closeBroser();
    }
}
