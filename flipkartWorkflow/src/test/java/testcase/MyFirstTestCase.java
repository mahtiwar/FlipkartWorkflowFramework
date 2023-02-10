package testcase;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import base.*;


public class MyFirstTestCase extends BaseTest{
	//@Test(dataProvider="testdata")

	@Test
	//public static void searchingTest(String searchValue) throws InterruptedException { but this will only pas two values
	public static void searchingTest() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(locatorProp.getProperty("click_Cross_button"))).click();
		driver.findElement(By.name(locatorProp.getProperty("search_Product"))).sendKeys("SMARTPHONE",Keys.ENTER);//search_Product
	}
//	@DataProvider(name="testdata")
//	public Object[][] tData(){
//		return new Object[][] {
//			{"clothing for women",""}
//		};
//	}
}
