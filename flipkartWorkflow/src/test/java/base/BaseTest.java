package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static Properties properties = new Properties();
	public static FileReader fileReader;
	public void setUp() throws FileNotFoundException {
		if(driver==null) {
			FileReader fr = new FileReader("C:\\Users\\Mahima\\git\\FlipkartWorkflowFramework\\flipkartWorkflow\\src\\test\\resources\\configfiles\\config.properties");
			if(properties.getProperty("browser").equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get("https://www.flipkart.com/");
				
			}
		}
		
		 
	}
	
}
