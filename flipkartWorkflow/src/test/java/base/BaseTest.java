package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static Properties properties = new Properties();
	public static Properties locatorProp = new Properties();
	public static FileReader fr;
	public static FileReader fr_loc;
	@BeforeTest
	public void setUp() throws IOException {
		if(driver==null) {
			
			 fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			fr_loc = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			//C:\Users\Mahima\git\FlipkartWorkflowFramework\flipkartWorkflow\src\test\resources\configfiles\config.properties
			properties.load(fr);
			locatorProp.load(fr_loc);
		}
			if(properties.getProperty("browser").equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get("https://www.flipkart.com/");			
			}
		}		 
	
	@AfterTest
	public void tearDown() {
		driver.close();		
		System.out.println("TearDown Successful");
	}
	
}
