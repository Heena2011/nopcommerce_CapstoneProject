package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators for login
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement LoginEmailTxtBox;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement LoginPassWordTxtBox;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement LoginSubmitBtn;
	
	@FindBy(xpath="//div[@class='message-error validation-summary-errors']")
	WebElement loginUnsuccessfulErrorMsg;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement logOutbtn;
	//Action methods
	
	public void setLoginEmail(String email) {
		LoginEmailTxtBox.sendKeys(email);
	}
	
	public void setLoginPassword(String password) {
		LoginPassWordTxtBox.sendKeys(password);
	}
	public void clickLoginSubmitBtn() {
		LoginSubmitBtn.click();
	}
	public String getLoginErrorMessage() {
	    try {
	       // adjust selector
	        return loginUnsuccessfulErrorMsg.getText();
	    } catch(Exception e) {
	        return "";
	    }
	}
	public boolean isLogoutDisplayed() {
		return logOutbtn.isDisplayed();
	}
}
