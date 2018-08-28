package branch.BranchIO;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BrowserFactory{

	public static Logger log = Logger.getLogger(BasePage.class);
	protected WebDriver driver;
	Actions action;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void sendKeys(WebElement ele, String key) {
		waitForPage();
		waitFor(ele, 30);
		log.info("Send Data: "+key);
		ele.sendKeys(key);
		ele.sendKeys(Keys.ENTER);
	}

	protected void waitForPage() {
		WebDriverWait wait = new WebDriverWait(driver, 30); 
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
	}

	public boolean explicitWait(WebElement ele, int timeUnits) {
		WebDriverWait wait = new WebDriverWait(driver, timeUnits);
		return wait.until(ExpectedConditions.elementToBeSelected(ele));
	}

	protected void click(WebElement ele) {
		log.info("Clicking On: "+ele.getText());
		ele.click();
	}

	protected void jsClick(WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		log.info("Click performed on element: "+ele);
	}
	protected void clearText(WebElement we){
		waitFor(we,60);
		we.clear();
		log.info("Text Cleared"+we);
	}

	protected void enterValue(WebElement ele,String text){
		waitFor(ele,60);
		ele.sendKeys(text);
		log.info("Value is set to element:"+ele);
	}

	public void waitFor(WebElement ele,int time){
		try {
			new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
			log.info("Exception in wait for visible: " + e);
			//MatcherAssert.assertThat(ele + " is not visible within " + time + " seconds. " + e.getMessage(), false);
		}
	}

	public void waitforinvisibilityofele(String path,int time){
		try {
			new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(path)));
		} catch (Exception e) {
			log.info("Exception in wait for visible: " + e);
			MatcherAssert.assertThat("Time Out,waiting for invisibility of element " + e.getMessage(), false);
		}
	}


	protected boolean isDisplayed(WebElement ele, int time) {
		try {
			waitFor(ele, time);
		}catch (Exception e) {
			log.info("Element Is Not Displayed:");
		}
		
		return ele.isDisplayed();
	}


	public boolean isElementPresent(WebElement ele) {
		waitForPage();
		boolean flag = false;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		try {  
			if (ele.isDisplayed())
				flag = true;
		}catch (NoSuchElementException e) {  
			return false;  
		} finally {  
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		}  
		return flag;
	}

	protected void navigateTo(String url) {

		driver.navigate().to(url);
		driver.manage().window().maximize();
	}

	public void log(String str){
		log.info(str);
	}

	public void switchFrame(WebElement ele){
		waitForPage();
		try{
			driver.switchTo().frame(ele);          
		}
		catch(Exception e)
		{
			log.error(e.getMessage()+e);
		}
	}

	protected boolean isEnabled(WebElement ele){
		boolean flag = false;
		try {
			if (ele.isEnabled())
				flag = true;
		} catch (Exception e) {
		}
		return flag;
	}

	public void selectByValue(WebElement ele,String value){
		try{
			waitFor(ele,10);
			Select select=new Select(ele);
			select.selectByValue(value);
		}
		catch(Exception e)
		{
			log.error(e.getMessage()+e);
		}
	}

	public void selectByText(WebElement ele,String text){
		try{
			waitFor(ele,10);
			Select select=new Select(ele);
			select.selectByVisibleText(text);
		}
		catch(Exception e){
			log.error(e.getMessage()+e);
		}
	}

	public void moveToElement(WebElement we){
		try
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);",we);
		}
		catch(Exception e)
		{
			log.info("Move to Element failed with Exception"+e);
		}
	}

	public WebElement waitForPresenceofElement(String path,int time,String type){
		WebElement we = null;
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,time);
			if(type.equals("xpath"))
			{
				we=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
			}
			else
			{
				we=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(path)));
			}
		}
		catch(Exception e)
		{
			MatcherAssert.assertThat("Failed to check element present in dom",false);
		}
		log.info(we+"WebElement");
		return we;
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	/*protected void sendKeys(WebElement we,Keys k){
		waitFor(we,60);
		we.sendKeys(k);
		log("Keys set to element:"+we);
	}*/

	public void openUrl() {
		driver.get("http://qa1.asrpro.com");
	}

	public void closeBrowser() {
		driver.close();
	}

	public int totalNumberOfElements(List<WebElement> e) {
		waitForPage();
		return e.size();
	}

	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}

	public void implicitWait(int timeUnits) {
		driver.manage().timeouts().implicitlyWait(timeUnits, TimeUnit.SECONDS);
	}

	public void switchTabWindowHandles() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); 
		}
	}
	
	public void mouseHoverOnelement(WebElement ele) {
		waitFor(ele, 60);
		action = new Actions(driver);
		action.moveToElement(ele).build().perform();
	}
	
	public void mouseHoverOnelementAndClick(WebElement ele) {
		waitFor(ele, 60);
		action = new Actions(driver);
		action.moveToElement(ele).click().build().perform();
	}
	
	public void hardSleep(int seconds) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
