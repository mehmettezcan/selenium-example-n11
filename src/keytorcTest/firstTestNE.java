package keytorcTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class firstTestNE extends baseNElevenTest {
		
	public void btnClick(String button) {
		
	  driver.findElement(By.xpath(button)).click();
	  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	  
	  }
	public void sendKeys(String path, String key) {
		
		driver.findElement(By.xpath(path)).sendKeys(key);
		
	}
	public void checkResults(String path,String searchname) {
			
		if(!driver.findElement(By.xpath(path)).getText().isEmpty() ) {
			System.out.println(searchname+ " için sonuç bulundu!");
		}
			
		}
	
	public void checkFav(String path) {
		
		if(driver.findElement(By.xpath(path)).isDisplayed() ) {
			System.out.println("Ýzlemeye alinmis urun bulunuyor!");
		}
		
	}
}