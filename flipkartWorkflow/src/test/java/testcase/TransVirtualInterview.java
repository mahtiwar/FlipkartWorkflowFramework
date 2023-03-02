package testcase;

import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TransVirtualInterview {

static WebDriver driver;

@SuppressWarnings("deprecation")
@Test

public void sample() {

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
//System.setProperty("webdriver.chrome.driver", "C:\\Users\\neetu\\eclipse\\browser\\chromedriver.exe");
driver.get("https://portal.transvirtual-stage.com.au/Public/Home/Login");
driver.manage().window().maximize();
driver.findElement(By.id("username")).sendKeys("qatester@slater");
driver.findElement(By.id("password")).sendKeys("qatest123");
driver.findElement(By.xpath("//button[@class='signin_btn']")).click();
driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Warehouse']"));
Actions action = new Actions(driver);
action.moveToElement(element).click().build().perform();
element  = driver.findElement(By.xpath("//a[@href='/Portal/Warehouse/StockItemUOMList']"));
//action.moveToElement(element).build().perform();
element.click();

driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary ']")).click();
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
String inputString = "test3";
driver.findElement(By.xpath("//input[@data-val-required='The Unit Of Measure(UOM) Name field is required.']")).sendKeys(inputString);
driver.findElement(By.id("EditFilePropertiesModalSaveButton")).click();
element = driver.findElement(By.id("gs_UOMName"));
element.sendKeys(inputString,Keys.ENTER);
String expected = inputString;
element = driver.findElement(By.xpath("//tr/td[@aria-describedby='gridtable_UOMName']"));
String actual = element.getText();
if(actual.equalsIgnoreCase(expected)) {
	System.out.println("successfully created");
}
else {
	System.out.println("unsuccessful");
}

}

}