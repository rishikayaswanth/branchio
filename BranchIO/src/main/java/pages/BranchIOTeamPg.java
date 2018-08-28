package pages;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import branch.BranchIO.BasePage;

public class BranchIOTeamPg extends BasePage{

	public BranchIOTeamPg(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//div[@class='row row-centered']/div")
	private List<WebElement> allTabLstOfEmployees;

	@FindBy(css="a[href='#all']")
	private WebElement allTabElement;

	@FindBy(xpath="//ul[@class='team-categories']/li/a[text()='Data']")
	private WebElement dataTabLnk;

	@FindBy(xpath="//ul[@class='team-categories']/li/a[text()='Engineering']")
	private WebElement engineeringTabLnk;

	@FindBy(xpath="//ul[@class='team-categories']/li/a[text()='Marketing']")
	private WebElement marketingTabLnk;

	@FindBy(xpath="//ul[@class='team-categories']/li/a[text()='Operations']")
	private WebElement operationsTabLnk;

	@FindBy(xpath="//ul[@class='team-categories']/li/a[text()='Partner Growth']")
	private WebElement partnerGrowthTabLnk;

	@FindBy(xpath="//ul[@class='team-categories']/li/a[text()='Product']")
	private WebElement productTabLnk;

	@FindBy(xpath="//ul[@class='team-categories']/li/a[text()='Recruiting']")
	private WebElement recruitingTabLnk;

	@FindBy(xpath="//div[@style='display: inline-block;']")
	private List<WebElement> activeListOfIconsDisplayed;

	@FindBy(xpath="//div[@class='info-block']/h2")
	private List<WebElement> totalListOfNames;

	HashMap<Integer, String> namesList = new HashMap<Integer, String>();

	@FindBy(xpath="//div[@style='display: inline-block;']//h2")
	private List<WebElement> dataTabNamesLst;

	public int allEmployees() {
		waitFor(allTabElement,30);
		jsClick(allTabElement);
		moveToElement(allTabLstOfEmployees.get(0));
		
		int counter = 0;
		for (WebElement webElement : totalListOfNames) {
			namesList.put(counter, webElement.getText());
			counter++;
		}
		return allTabLstOfEmployees.size();
	}

	public int dataTabLnkActivePanel() {
		waitFor(dataTabLnk, 30);
		moveToElement(dataTabLnk);
		jsClick(dataTabLnk);
		hardSleep(2000);
		
		return activeListOfIconsDisplayed.size();
	}

	public int engineeringTabLnkActivePanel() {
		waitFor(engineeringTabLnk, 30);
		moveToElement(engineeringTabLnk);
		jsClick(engineeringTabLnk);;
		hardSleep(2000);
		
		return activeListOfIconsDisplayed.size();
	}

	public int marketingTabLnkActivePanel() {
		waitFor(marketingTabLnk, 30);
		moveToElement(marketingTabLnk);
		jsClick(marketingTabLnk);;
		hardSleep(2000);
		
		return activeListOfIconsDisplayed.size();
	}

	public int operationsTabLnkActivePanel() {
		waitFor(operationsTabLnk, 30);
		moveToElement(operationsTabLnk);
		jsClick(operationsTabLnk);;
		hardSleep(2000);
		
		return activeListOfIconsDisplayed.size();
	}

	public int partnerGrowthTabLnkActivePanel() {
		waitFor(partnerGrowthTabLnk, 30);
		moveToElement(partnerGrowthTabLnk);
		jsClick(partnerGrowthTabLnk);;
		hardSleep(2000);
		
		return activeListOfIconsDisplayed.size();
	}

	public int productTabLnkActivePanel() {
		waitFor(productTabLnk, 30);
		moveToElement(productTabLnk);
		jsClick(productTabLnk);;
		hardSleep(2000);
		
		return activeListOfIconsDisplayed.size();
	}

	public int recruitingTabLnkActivePanel() {
		waitFor(recruitingTabLnk, 30);
		moveToElement(recruitingTabLnk);
		jsClick(recruitingTabLnk);;
		hardSleep(2000);
		
		return activeListOfIconsDisplayed.size();
	}


	public boolean dataTabLnkNameCompare() {
		hardSleep(2000);
		
		waitFor(dataTabLnk, 30);
		moveToElement(dataTabLnk);
		jsClick(dataTabLnk);
		boolean flag = false;
		for (WebElement webElement : dataTabNamesLst) {
			if(namesList.values().contains(webElement.getText())){
				flag =  true;
			}
			else {
				flag =  false;
			}	

		}
		return flag;
	}
	
	public boolean engineeringTabLnkNameCompare() {
		hardSleep(2000);
		
		waitFor(engineeringTabLnk, 30);
		moveToElement(engineeringTabLnk);
		jsClick(engineeringTabLnk);
		boolean flag = false;
		for (WebElement webElement : dataTabNamesLst) {
			if(namesList.values().contains(webElement.getText())){
				flag =  true;
			}
			else {
				flag =  false;
			}	

		}
		return flag;
	}
	
	public boolean marketingTabLnkNameCompare() {
		hardSleep(2000);
		
		waitFor(marketingTabLnk, 30);
		moveToElement(marketingTabLnk);
		jsClick(marketingTabLnk);
		boolean flag = false;
		for (WebElement webElement : dataTabNamesLst) {
			if(namesList.values().contains(webElement.getText())){
				flag =  true;
			}
			else {
				flag =  false;
			}	

		}
		return flag;
	}
	
	public boolean operationsTabLnkNameCompare() {
		hardSleep(2000);
		
		waitFor(operationsTabLnk, 30);
		moveToElement(operationsTabLnk);
		jsClick(operationsTabLnk);
		boolean flag = false;
		for (WebElement webElement : dataTabNamesLst) {
			if(namesList.values().contains(webElement.getText())){
				flag =  true;
			}
			else {
				flag =  false;
			}	

		}
		return flag;
	}
	
	public boolean partnerGrowthTabLnkNameCompare() {
		hardSleep(2000);
		
		waitFor(partnerGrowthTabLnk, 30);
		moveToElement(partnerGrowthTabLnk);
		jsClick(partnerGrowthTabLnk);
		boolean flag = false;
		for (WebElement webElement : dataTabNamesLst) {
			if(namesList.values().contains(webElement.getText())){
				flag =  true;
			}
			else {
				flag =  false;
			}	

		}
		return flag;
	}
	
	public boolean productTabLnkNameCompare() {
		hardSleep(2000);
		
		waitFor(productTabLnk, 30);
		moveToElement(productTabLnk);
		jsClick(productTabLnk);
		boolean flag = false;
		for (WebElement webElement : dataTabNamesLst) {
			if(namesList.values().contains(webElement.getText())){
				flag =  true;
			}
			else {
				flag =  false;
			}	

		}
		return flag;
	}
	
	public boolean recrutingTabLnkNameCompare() {
		hardSleep(2000);
		
		waitFor(recruitingTabLnk, 30);
		moveToElement(recruitingTabLnk);
		jsClick(recruitingTabLnk);
		boolean flag = false;
		for (WebElement webElement : dataTabNamesLst) {
			if(namesList.values().contains(webElement.getText())){
				flag =  true;
			}
			else {
				flag =  false;
			}	

		}
		return flag;
	}
	
}
