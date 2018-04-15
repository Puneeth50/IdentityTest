package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by puneeth on 11/04/2018.
 */
public class SharedDriver {

    public static WebDriver REAL_DRIVER;
    private static String BROWSER_NAME;

    static {
        BROWSER_NAME = System.getProperty("browserName");
        if(BROWSER_NAME ==null|| BROWSER_NAME.equalsIgnoreCase("")){
            BROWSER_NAME = "chrome";
        }
        switch(BROWSER_NAME){
            case "firefox":
                REAL_DRIVER = new FirefoxDriver();
                break;
            case "chrome":
                String chromeDriverPath = System.getProperty("user.dir")+"//src//main//resources//chromedriver.exe";
                System.setProperty("webdriver.chrome.driver",chromeDriverPath);
                REAL_DRIVER = new ChromeDriver();
                break;
            case "ie":
                REAL_DRIVER = new InternetExplorerDriver();
                break;
            default:
                REAL_DRIVER = new FirefoxDriver();
                break;
        }
    }



    public static WebDriver getRealDriver(){
        return  REAL_DRIVER;
    }


    private static final Thread CLOSE_THREAD= new Thread(){
        public void run(){
            REAL_DRIVER.quit();
        }
    };


}
