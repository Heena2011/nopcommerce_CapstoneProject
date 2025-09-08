package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locate elements for registration
	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement Registelnk;
	//locate element for registration
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement logoutLnk;
	
	//locate the element for log in
	@FindBy(xpath="//a[normalize-space()='Log in']")
	WebElement logInLnk;
	//Action method
	public void selectRegister() {
		Registelnk.click();
	}
	public void selectLogout() {
		logoutLnk.click();
	}
	public void selectLogin() {
		logInLnk.click();
	}
	
}