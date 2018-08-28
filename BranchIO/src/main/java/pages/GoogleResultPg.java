package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import branch.BranchIO.BasePage;

public class GoogleResultPg extends BasePage{

	public GoogleResultPg(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(css="a[href='https://branch.io/']")
	private WebElement branchIOLnk;
	
	
	public BranchIOHomePg clickOnLnkTxt() {
		waitFor(branchIOLnk, 30);
		click(branchIOLnk);
		
		return PageFactory.initElements(driver, BranchIOHomePg.class);
	}
}
