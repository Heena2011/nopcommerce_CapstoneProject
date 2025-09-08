package testCase;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.AddToCartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TS003_SearchTest extends BaseClass {
	@Test(dataProvider = "SearchData", dataProviderClass = utilities.DataProviders.class)
	public void verify_Search(String productName) throws Exception {
		try {
			HomePage hp = new HomePage(driver);
			hp.selectRegister();
			AccountRegistrationPage accpage = new AccountRegistrationPage(driver);
			Map<String, String> userData = generateRegistrationData();
			accpage.selectGender(userData.get("gender"));
			accpage.setFirstName(userData.get("firstName"));
			accpage.selectGender(userData.get("gender"));
			accpage.setFirstName(userData.get("firstName"));
			accpage.setLastName(userData.get("lastName"));
			accpage.setEmail(userData.get("email"));
			accpage.setCompanyName(userData.get("companyName"));
			accpage.setPassword(userData.get("password"));
			accpage.setConfirmPassword(userData.get("password"));
			accpage.clickSubmit();

			Assert.assertTrue(accpage.isRegistrationSuccessMessageDisplayed(),
					"Registration failed for: " + userData.get("email"));

			// hp.selectLogout();

			SearchPage searchProduct = new SearchPage(driver);
			searchProduct.setsearchTxtBox(productName);//mac
			searchProduct.clicksearchBtn();
			searchProduct.verifyNoOfProducts();
			searchProduct.sortByHighToLow();

			hp.selectLogout();
		} catch (Exception e) {
			Assert.fail("Exception in registration: " + e.getMessage());
		}

	}// closing of test method
}// closing of class
