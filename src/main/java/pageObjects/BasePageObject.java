package pageObjects;

import generic.SharedDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by puneeth on 13/04/2018.
 */
public class BasePageObject {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public BasePageObject(){
        this.driver = SharedDriver.getRealDriver();
        wait = new WebDriverWait(driver,30);
        driver.manage().window().maximize();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
        driver.get("https://www.gov.uk/get-vehicle-information-from-dvla");
    }

    public void quitDriver(){
        driver.quit();
    }
}
