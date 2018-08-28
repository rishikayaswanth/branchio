package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import branch.BranchIO.BasePage;

public class GoogleHomePg extends BasePage {

	public GoogleHomePg(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="input[name='q']")
	private WebElement googleSearchTxtField;

	public GoogleResultPg searchTxt(String txtField) {
		waitFor(googleSearchTxtField, 30);
		sendKeys(googleSearchTxtField, txtField);
		
		return PageFactory.initElements(driver, GoogleResultPg.class);
	}
}
