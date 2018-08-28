package branch.BranchIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BranchIOHomePg;
import pages.BranchIOTeamPg;
import pages.GoogleHomePg;

public class BranchIOTest extends BrowserFactory{
	WebDriver driver;
	GoogleHomePg loginPg;
	BranchIOHomePg branchIoHomePg;
	BranchIOTeamPg branchIOTeamPg;
	
	@BeforeMethod(alwaysRun=true)
	public void initializeDriver() {
		driver = getDriver();
		loginPg = PageFactory.initElements(driver, GoogleHomePg.class);
		branchIOTeamPg = PageFactory.initElements(driver, BranchIOTeamPg.class);
		branchIoHomePg = PageFactory.initElements(driver, BranchIOHomePg.class);
		openBrowser("https://google.com");
		loginPg.searchTxt("Branch.io").clickOnLnkTxt().clickOnTeamLnk();
	}
	
	
	@Test(priority=1)
	public void totalEmployeeCountList_TC5() {
		
		int totalEmployeesList = branchIOTeamPg.allEmployees();
		
		int individualEmployeeList = 
				branchIOTeamPg.dataTabLnkActivePanel()+
				branchIOTeamPg.engineeringTabLnkActivePanel() +
				branchIOTeamPg.marketingTabLnkActivePanel() +
				branchIOTeamPg.operationsTabLnkActivePanel()+
				branchIOTeamPg.partnerGrowthTabLnkActivePanel()+
				branchIOTeamPg.productTabLnkActivePanel()+
				branchIOTeamPg.recruitingTabLnkActivePanel();
		org.hamcrest.MatcherAssert.assertThat("Total Number Of Employees in All Tab "
				+ "is Not Matching with sum of count in all other tabs", 
				totalEmployeesList==individualEmployeeList);
	}
	
	@Test(priority=2)
	public void namesEmployeeCountList_TC6() {
		branchIOTeamPg.allEmployees();
		org.hamcrest.MatcherAssert.assertThat("Names from All Tab vs Data Tab", branchIOTeamPg.dataTabLnkNameCompare());
		org.hamcrest.MatcherAssert.assertThat("Names from All Tab vs Engineering Tab", branchIOTeamPg.engineeringTabLnkNameCompare());
		org.hamcrest.MatcherAssert.assertThat("Names from All Tab vs Marketing Tab", branchIOTeamPg.marketingTabLnkNameCompare());
		org.hamcrest.MatcherAssert.assertThat("Names from All Tab vs Operations Tab", branchIOTeamPg.operationsTabLnkNameCompare());
		org.hamcrest.MatcherAssert.assertThat("Names from All Tab vs Partner Tab", branchIOTeamPg.partnerGrowthTabLnkNameCompare());
		org.hamcrest.MatcherAssert.assertThat("Names from All Tab vs Product Tab", branchIOTeamPg.productTabLnkNameCompare());
		org.hamcrest.MatcherAssert.assertThat("Names from All Tab vs Recruiting Tab", branchIOTeamPg.recrutingTabLnkNameCompare());
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
	
}
