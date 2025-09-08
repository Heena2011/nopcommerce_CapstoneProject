package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locate element  for test case 1 -->pass
	
	
	@FindBy(xpath="//input[@id='gender-male']")
	WebElement MaleRadioBtn;
	
	@FindBy(xpath="//input[@id='gender-female']")
	WebElement FemaleRadioBtn;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement FirstNameTxtBox;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement LastNameTxtBox;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement EmailTxtBox;
	
	@FindBy(xpath = "//input[@id='Company']")
	WebElement CompanyNameTxtBox;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement PasswordTxtBox;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement ConfirmPasswordTxtBox;
	
	@FindBy(xpath="//button[@id='register-button']")
	WebElement submitBtn;
	
	// success message after registration
	@FindBy(xpath="//div[@class='result']")
	WebElement RegSuccessfullMsgDeisplayed;
	
	
	//locate element for test case 2 -->failed 
	
	
	//Action Methods-->Action methods
	@FindBy(xpath = "//li[normalize-space()='The specified email already exists']")
	private WebElement emailExistsError;


	
	
	
	public void selectGender(String gender) {
	    if (gender.equalsIgnoreCase("male")) {
	        MaleRadioBtn.click();
	    } else if (gender.equalsIgnoreCase("female")) {
	        FemaleRadioBtn.click();
	    } else {
	        throw new IllegalArgumentException("Invalid gender: " + gender);
	    }
	}
	 public void setFirstName(String fname) {
	        FirstNameTxtBox.clear();
	        FirstNameTxtBox.sendKeys(fname);
	    }

	    public void setLastName(String lname) {
	        LastNameTxtBox.clear();
	        LastNameTxtBox.sendKeys(lname);
	    }

	    public void setEmail(String email) {
	        EmailTxtBox.clear();
	        EmailTxtBox.sendKeys(email);
	    }

	    public void setCompanyName(String company) {
	        CompanyNameTxtBox.clear();
	        CompanyNameTxtBox.sendKeys(company);
	    }

	    public void setPassword(String pwd) {
	        PasswordTxtBox.clear();
	        PasswordTxtBox.sendKeys(pwd);
	    }

	    public void setConfirmPassword(String cpwd) {
	        ConfirmPasswordTxtBox.clear();
	        ConfirmPasswordTxtBox.sendKeys(cpwd);
	    }

	    public void clickSubmit() {
	    	submitBtn.click();
	    }
	    public boolean isRegistrationSuccessMessageDisplayed() {
	    	return RegSuccessfullMsgDeisplayed.isDisplayed();
	    }
	    
	    // method to detect success message (if site shows)
	    public boolean isRegistrationSuccessMessageDisplayedforFailedTestCase() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
	            wait.until(ExpectedConditions.visibilityOf(RegSuccessfullMsgDeisplayed));
	            return RegSuccessfullMsgDeisplayed.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	    //Action method for test case 2
	    
	 // method to detect the specific email-exists error
	    public boolean isEmailAlreadyExistsErrorDisplayed() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
	            wait.until(ExpectedConditions.visibilityOf(emailExistsError));
	            return emailExistsError.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	   

	}

