package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import branch.BranchIO.BasePage;

public class BranchIOHomePg extends BasePage{

	public BranchIOHomePg(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="a[href='https://branch.io/team/#all']")
	private WebElement teamTxtLnk;
	
	public BranchIOTeamPg clickOnTeamLnk() {
		waitFor(teamTxtLnk, 30);
		moveToElement(teamTxtLnk);
		click(teamTxtLnk);
		
		return PageFactory.initElements(driver, BranchIOTeamPg.class);
	}
	
	
	//div[@class='row row-centered']/div
}
