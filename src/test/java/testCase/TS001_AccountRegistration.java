package testCase;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TS001_AccountRegistration extends BaseClass {
	public static String registeredEmail; // shared variable
	 public static String registeredPassword;

	@Test(priority = 1)
	public void registrationTest() {
		try {
			HomePage hp = new HomePage(driver);
			hp.selectRegister();
			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);

			// Instead of using excel, generate random test data
			String gender = "Male"; // or "Female"
			String firstName = randomString(); // e.g. "Abcde"
			String lastName = randomString(); // e.g. "Xyzab"
			String email = randomString() + "@gmail.com"; // e.g. "Tuvwz@gmail.com"
			String companyName = randomString() + " Pvt Ltd";
			String password = alphaNumeric(); // e.g. "Abc@123"

			regPage.selectGender(gender);
			regPage.setFirstName(firstName);
			regPage.setLastName(lastName);
			regPage.setEmail(email);
			regPage.setCompanyName(companyName);
			regPage.setPassword(password);
			regPage.setConfirmPassword(password);
			regPage.clickSubmit();

			Assert.assertTrue(regPage.isRegistrationSuccessMessageDisplayed(), "Registration failed with random data");
			TS001_AccountRegistration.registeredEmail = email;
			TS001_AccountRegistration.registeredPassword = password;
			System.out.println("Saved registered credentials -> email: " + email + " password: " + password);
			hp.selectLogout();
		} catch (Exception e) {
			Assert.fail("Exception occurred: " + e.getMessage());
		}
	}

//	 @Test(priority = 2)
//	    public void registrationTestForExistingEmail() {
//	        try {
//	            HomePage hp = new HomePage(driver);
//	            hp.selectRegister();
//	            AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
//
//	            // reuse the same email from Test 1
//	            regPage.selectGender("Male");
//	            regPage.setFirstName(randomString());
//	            regPage.setLastName(randomString());
//	            regPage.setEmail(registeredEmail);  // already registered email
//	            regPage.setCompanyName(randomString() + " Pvt Ltd");
//	            regPage.setPassword(registeredPassword);
//	            regPage.setConfirmPassword(registeredPassword);
//	            regPage.clickSubmit();
//
//	            Thread.sleep(2000);
//
//	            // verify "Email already exists" error
//	            boolean emailError = regPage.isEmailAlreadyExistsErrorDisplayed();
//	            Assert.assertTrue(emailError,
//	                    "Expected 'Email already exists' error for email: " + registeredEmail);
//
//	        } catch (Exception e) {
//	            Assert.fail("Exception in duplicate registration: " + e.getMessage());
//	        }
//	    }
	/*
	 * @Test(priority = 1, dataProvider = "RegistrationData", dataProviderClass =
	 * DataProviders.class) public void registrationTest(String gender, String
	 * firstName, String lastName, String email, String companyName, String
	 * password) { try { HomePage hp = new HomePage(driver); hp.selectRegister();
	 * AccountRegistrationPage regPage = new AccountRegistrationPage(driver);//
	 * register
	 * 
	 * // If you have a single method selectGender(String gender)
	 * regPage.selectGender(gender); // "Male" or "Female" from excel
	 * 
	 * regPage.setFirstName(firstName); regPage.setLastName(lastName);
	 * regPage.setEmail(email); regPage.setCompanyName(companyName);
	 * regPage.setPassword(password); regPage.setConfirmPassword(password); // using
	 * same pwd from excel regPage.clickSubmit();
	 * 
	 * // add assertion(s) here to verify successful registration, e.g.
	 * Assert.assertTrue(regPage.isRegistrationSuccessMessageDisplayed());
	 * hp.selectLogout(); } catch (Exception e) { Assert.fail();
	 * e.printStackTrace(); }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @Test(priority = 2, dataProvider = "RegistrationData", dataProviderClass =
	 * DataProviders.class) public void registrationTestForExistingEmail(String
	 * gender, String firstName, String lastName, String email, String companyName,
	 * String password) { try { HomePage hp = new HomePage(driver);
	 * hp.selectRegister(); AccountRegistrationPage regPage = new
	 * AccountRegistrationPage(driver);// register
	 * 
	 * // If you have a single method selectGender(String gender)
	 * regPage.selectGender(gender); // "Male" or "Female" from excel
	 * 
	 * regPage.setFirstName(firstName); regPage.setLastName(lastName);
	 * regPage.setEmail(email); regPage.setCompanyName(companyName);
	 * regPage.setPassword(password); regPage.setConfirmPassword(password); // using
	 * same pwd from excel regPage.clickSubmit();
	 * 
	 * // add assertion(s) here to verify successful registration, e.g.
	 * 
	 * 
	 * Thread.sleep(5000);
	 * 
	 * //Failed Test Case // verify expected error "Email already exists" boolean
	 * emailError = regPage.isEmailAlreadyExistsErrorDisplayed(); if (emailError) {
	 * System.out.
	 * println("PASS: 'Email already exists' error displayed as expected for email: "
	 * + email); } else { // If no error shown but registration succeeded or page
	 * stuck, capture screenshot and fail String path = captureScreen("REG02_" +
	 * email.replaceAll("[^a-zA-Z0-9]", "_"));
	 * System.out.println("Screenshot saved at: " + path); // Optional: check if
	 * success message displayed if
	 * (regPage.isRegistrationSuccessMessageDisplayed()) { Assert.
	 * fail("FAILED: No 'email exists' error shown; user registered successfully with existing email: "
	 * + email + ". Screenshot: " + path); } else { Assert.
	 * fail("FAILED: No 'email exists' error shown and no success message either. Screenshot: "
	 * + path); }
	 * 
	 * 
	 * }
	 * 
	 * } catch (Exception e) { // on exception capture screenshot and fail String
	 * path = captureScreen("REG02_exception"); e.printStackTrace();
	 * Assert.fail("Test threw exception. Screenshot: " + path + ". Exception: " +
	 * e.getMessage()); } }
	 */

}
