package keytorcTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
 
public class baseNElevenTest {
 
   public static WebDriver driver;
   
   public static void startTest() {
	   //Start Browser
	   System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
	   FirefoxOptions cap = new FirefoxOptions();
	   cap.setCapability("marionette", true);
	   driver = new FirefoxDriver(cap);
	   }
   public static void endTest(){
 
    //Close driver
    driver.quit();
    }
   }