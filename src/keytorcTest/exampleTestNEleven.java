package keytorcTest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

class exampleTestNEleven extends baseNElevenTest{
	firstTestNE testNE = new firstTestNE();
	
	@Test
	public void test0() {
		startTest();
		//1-http://www.n11.com<http://www.n11.com/> sitesine gelecek ve anasayfanin acildigini onaylayacak.
		String baseUrl = "https://www.n11.com";
		driver.navigate().to(baseUrl);
		try {
			Assert.assertTrue(driver.getTitle().equals("n11.com - Alýþveriþin Uðurlu Adresi"));
        	System.out.println("Anasayfa açýldý!");
		 }catch(Exception e){
			 System.out.println("Anasayfa açýlmadý!");
	     		}
	}
	
	@Test
	public void test1() {
		//2-Login ekranini acip, bir kullanici ile login olacak. ( daha once siteye uyeliginiz varsa o olabilir )
		testNE.btnClick("//a[@href='https://www.n11.com/giris-yap']");
		testNE.sendKeys("//input[@id='email']", "mtn48@hotmail.com.tr");
		testNE.sendKeys("//input[@id='password']", "21732mtn");
		testNE.btnClick("//div[@id='loginButton']");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	
	}
	@Test
	public void test2() {
		//3-Ekranin ustundeki Search alanina 'samsung' yazip Ara butonuna tiklayacak.
		testNE.sendKeys("//input[@id='searchData']", "samsung");
		testNE.btnClick("//a[@class='searchBtn']");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	@Test
	public void test3() {
		//4-Gelen sayfada samsung icin sonuc bulundugunu onaylayacak.
		testNE.checkResults("//*[(@id = \"contentListing\")]//strong","samsung");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	@Test
	public void test4() {
		//5-Arama sonuclarindan 2. sayfaya tiklayacak ve acilan sayfada 2. sayfanin su an gosterimde oldugunu onaylayacak
		testNE.btnClick("//a[@href='https://www.n11.com/arama?q=samsung&pg=2']");
		try {
			Assert.assertTrue(driver.getTitle().equals("Samsung - n11.com - 2/50"));
        	System.out.println("2. sayfa su an gosterimde!");
		 }catch(Exception e){
			 System.out.println("2. sayfa açýlmadý!");
	     		}
	}
	@Test
	public void test5() {
		//6-Ustten 3. urunun icindeki 'favorilere ekle' butonuna tiklayacak
		testNE.btnClick("//li[3]/div/div[2]/span");
	}
	@Test
	public void test6() {
		//7-Ekranin en ustundeki 'favorilerim' linkine tiklayacak.
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@class='myAccountMenu hOpenMenu']/div[1]/a[2]")));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	@Test
	public void test7() {
		//8-Acilan sayfada bir onceki sayfada izlemeye alinmis urunun bulundugunu onaylayacak.
		testNE.checkFav("//a[@href='https://www.n11.com/hesabim/favorilerim']");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	@Test
	public void test8() {
		//9-Favorilere alinan bu urunun yanindaki 'Kaldir' butonuna basarak, favorilerimden cikaracak.
		testNE.btnClick("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"listItemTitle\", \" \" ))]");
		testNE.btnClick("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"deleteProFromFavorites\", \" \" ))]");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	@Test
	public void test9() {
		//10-Sayfada bu urunun artik favorilere alinmadigini onaylayacak.
		try {
    		testNE.btnClick("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"deleteProFromFavorites\", \" \" ))]");
        	System.out.println("Hata!");
        	
		 }catch(Exception e){
        	 System.out.println("Bu urun artik favorilerde deðil!");
	     		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		endTest();
		}
	}

