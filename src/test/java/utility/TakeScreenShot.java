package utility;

import mydrivers.DriverPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TakeScreenShot extends DriverPage {

    public static void CaptureScreenShot(String ScreenShotName){
        try {
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            TakesScreenshot ts= (TakesScreenshot)driver;
            File source= ts.getScreenshotAs(OutputType.FILE);
            FileUtils .copyFile(source,new File("C:\\Users\\nikit\\IdeaProjects\\comasda\\screenshots"+ScreenShotName+".png"));
            System.out.println(ScreenShotName+"  : Screenshot is taken");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception while taking screenshot"+ e.getMessage());

        }
    }
}
