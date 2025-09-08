package testCase;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TS005_WishList extends BaseClass{
	@Test(dataProvider = "SearchData", dataProviderClass = utilities.DataProviders.class)
  public void verify_wishlist(String productName) {
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
			
			
			WishListPage w = new WishListPage(driver);
			searchProduct.setsearchTxtBox(productName);
			searchProduct.clicksearchBtn();
			w.addToWishlist();
			Thread.sleep(5000);
			searchProduct.setsearchTxtBox(productName);
			searchProduct.clicksearchBtn();
			w.addToWishlist();
			Thread.sleep(5000);
			w.goToWishlist();
			w.wishlistedProducts();
			
			hp.selectLogout();
		} catch (Exception e) {
			Assert.fail("Exception in registration: " + e.getMessage());
		}
  }
}
