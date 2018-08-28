package branch.BranchIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
	 static WebDriver driver;  
	public static WebDriver getDriver(){
		
        switch (4) {
            case 1:
                driver = new FirefoxDriver();
                break;
            case 2:
                driver = new InternetExplorerDriver();
                break;
            case 3:
                driver = new SafariDriver();
                break;
            case 4:
            	System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
            	driver = new ChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
        } 
        return driver;
    }
	
	public static void openBrowser(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
}
