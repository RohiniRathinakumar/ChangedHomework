package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Accounts;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TestBase;

public class ModBankAndCashSteps extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	Accounts accounts;
	
	@Before
	public void beforReRun() {
		init();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		accounts = PageFactory.initElements(driver, Accounts.class);
	}
	
	@When("User enters {string} in the {string} field")
	public void user_enters_in_the_field(String value,String fieldName) {
		if ("username".equalsIgnoreCase(fieldName)) {
			loginPage.insertUserName(value);
		} else if ("password".equalsIgnoreCase(fieldName)) {
			loginPage.insertPassword(value);
		} else {
			System.out.println("Inavlid credentials");

		}
	
	}

	

	@When("User clicks on {string}")
	public void user_clicks_on(String button) {
		if ("login".equalsIgnoreCase(button)) {
			loginPage.clickSignInButton();
		}
		else if ("bankCash".equalsIgnoreCase(button)) {
			dashboardPage.clickOnBankAndCash();
		}
		else if ("newAccount".equalsIgnoreCase(button)) {
			dashboardPage.clickOnNewAccount();
		}
		else if("submit".equalsIgnoreCase(button)){
			accounts.ClickOnSubmit();
		}
		else {
			System.out.println("Check Again");
		}
		}
	   
	
	@Then("User should land on Dashboard page.")
	public void user_should_land_on_Dashboard_page() {
		dashboardPage.verifyDashboardPage("Dashboard");
	}

	@Then("User enters {string} in the {string} field in accounts page")
	public void user_enters_in_the_field_in_accounts_page(String accountInfo,String fieldName) {
	    switch(fieldName.toLowerCase()) {
	    case "accounttitle":
	    	accounts.insertAccountTitle(accountInfo + generateRandomNumber(999));
	    	break;
	    case "description":
	    	accounts.insertDescription(accountInfo);
	    	break;
	    case "initialbalance":
	    	accounts.insertBalance(accountInfo);
	    	break;
	    case "accountnumber":
	    	accounts.insertAccountNumber(accountInfo + generateRandomNumber(999));
	    	break;
	    	
	    case "contactperson":
	    	accounts.insertContactPerson(accountInfo);
	    	break;
	    case "phone":
	    	accounts.insertContactPhone(accountInfo);
	    	break;
	    case "internetbankingurl":	
	    	accounts.insertUrl(accountInfo);
	    	break;
	    default:
	    	System.out.println("Invalid input");
	    	break;
	    }
	}

	@Then("User should be able to validate Account Created Successfully.")
	public void user_should_be_able_to_validate_account_created_successfully()   {
		accounts.verifyAccountIfCreated("Account Created Successfully");
	}

	@After
	public void closeBrowser() {
		tearDown();
	}

	
}
