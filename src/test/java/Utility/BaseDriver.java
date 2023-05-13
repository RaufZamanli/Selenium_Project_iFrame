package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
   public void bashlangicIshlemleri() {

        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);


        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        Duration dr = Duration.ofSeconds(15);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);


    }



    @AfterClass
   public void waitClose() {

        Tools.Wait(4);
        driver.quit();

    }
}

