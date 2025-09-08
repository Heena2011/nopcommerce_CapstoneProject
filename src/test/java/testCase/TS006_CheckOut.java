package testCase;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.AddToCartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TS006_CheckOut extends BaseClass{
	
//	 @Test(dataProvider = "CheckoutData", dataProviderClass = utilities.DataProviders.class)
//	    public void verify_checkout(String agreeTerms, String country, String state,
//	            String city, String town, String postalCode, String phone, String productName) throws Exception {
//
//	        HomePage hp = new HomePage(driver);
//	        hp.selectRegister();
//	        AccountRegistrationPage accpage = new AccountRegistrationPage(driver);
//	        Map<String, String> userData = generateRegistrationData();
//	        accpage.selectGender(userData.get("gender"));
//	        accpage.setFirstName(userData.get("firstName"));
//	        accpage.setLastName(userData.get("lastName"));
//	        accpage.setEmail(userData.get("email"));
//	        accpage.setCompanyName(userData.get("companyName"));
//	        accpage.setPassword(userData.get("password"));
//	        accpage.setConfirmPassword(userData.get("password"));
//	        accpage.clickSubmit();
//
//	        Assert.assertTrue(accpage.isRegistrationSuccessMessageDisplayed(),
//	                "Registration failed for: " + userData.get("email"));
//
//	        SearchPage searchProduct = new SearchPage(driver);
//	        CheckoutPage cp = new CheckoutPage(driver);
//	        AddToCartPage addCart = new AddToCartPage(driver);
//	        WishListPage wp = new WishListPage(driver);
//
//	        // Use productName from Excel
//	        searchProduct.setsearchTxtBox(productName);
//	        searchProduct.clicksearchBtn();
//	        wp.addToWishlist();
//
//	        Thread.sleep(3000);
//	        addCart.addToCart();
//	        Thread.sleep(3000);
//	        addCart.clickShoppingCartBtn();
//
//	        // apply agree terms if specified in Excel (yes/no)
//	        if (agreeTerms != null && agreeTerms.trim().equalsIgnoreCase("yes")) {
//	            cp.agreeTerms();
//	        }
//	        cp.clickOnCheckout();
//
//	        // fill billing details from Excel
//	        cp.billingCountry(country);
//	        Thread.sleep(2000); // replace with explicit wait in real code
//	        cp.billingState(state);
//	        cp.billingCity(city);
//	        cp.billingTown(town);
//	        cp.billingPostalCode(postalCode);
//	        cp.billingPhNo(phone);
//
//	        cp.blilingConBtn();
//	        cp.shippingMethod();
//	        cp.paymentMethod();
//	        cp.paymentInformation();
//	        cp.confirmCheckout();
//	    }
	
  @Test(dataProvider = "CheckoutData", dataProviderClass = utilities.DataProviders.class)
  public void verify_checkout(String agreeTerms, String country, String state,
        String city, String town, String postalCode, String phone, String productName) throws Exception {
	

   
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
		CheckoutPage cp = new CheckoutPage(driver);
		AddToCartPage addCart = new AddToCartPage(driver);
		WishListPage wp = new WishListPage(driver);
//		searchProduct.setsearchTxtBox("MacBook");
//		searchProduct.clicksearchBtn();
//		cp.clickOnComputers();
//		cp.clickOnDesktops();
//		cp.clickOnOneProduct();
//		
        searchProduct.setsearchTxtBox(productName);
		//.setsearchTxtBox("Adobe Photoshop");
		searchProduct.clicksearchBtn();
		wp.addToWishlist();
//		searchProduct.verifyNoOfProducts();
//		searchProduct.sortByHighToLow();
		
		
		Thread.sleep(5000);
		addCart.addToCart();
		Thread.sleep(5000);
		//addCart.clickaddingProductTocartBtn();
		addCart.clickShoppingCartBtn();
	//	apply agree terms if specified in Excel (yes/no)
     if (agreeTerms != null && agreeTerms.trim().equalsIgnoreCase("yes")) {
           cp.agreeTerms();
       }
		//cp.agreeTerms();
		cp.clickOnCheckout();
		cp.billingCountry(country);
		Thread.sleep(5000);
		cp.billingState(state);
		cp.billingCity(city);
		cp.billingTown(town);
		cp.billingPostalCode(postalCode);
		cp.billingPhNo(phone);
		cp.blilingConBtn();
		cp.shippingMethod();
		cp.paymentMethod();
		cp.paymentInformation();
		cp.confirmCheckout();
		hp.selectLogout();
  }
	}
