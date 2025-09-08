package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {
	

	

		//constructor
		public CheckoutPage(WebDriver driver) {
			super(driver);
		}
		
		//locators
		
		@FindBy(id="small-searchterms")
		WebElement SearchTxtBox;
		
		@FindBy(xpath="//button[text()='Search']")
		WebElement ClickOnSearch;
		
		@FindBy(linkText="Computers")
		WebElement ClickOnComputers;
		
		@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']")
		WebElement ClickOnDekstops;
		
		@FindBy(linkText="Build your own computer")
		WebElement ClickOnProduct;
		
		@FindBy(xpath="//button[normalize-space()='Add to wishlist']")
		WebElement AddToWishlist;
		
		@FindBy(xpath="//button[normalize-space()='Add to cart']")
		WebElement AddToCart;
		
		@FindBy(xpath="//span[@class='cart-label']")
		WebElement GoToCart;
		
		@FindBy(xpath="//button[@id='checkout']")
		WebElement ClickOnCheckout;
		
		@FindBy(id="termsofservice")
		WebElement AgreeTerms;
		
		@FindBy(id="ShipToSameAddress")
		WebElement SameAddressCheckbox;
		
		@FindBy(id="delete-billing-address-button")
		WebElement DeleteBtn;
		
		@FindBy(id="BillingNewAddress_FirstName")
		WebElement BillingFirstName;
		
		@FindBy(id="BillingNewAddress_LastName")
		WebElement BillingLastName;
		
		@FindBy(id="BillingNewAddress_Email")
		WebElement BillingEmail;
		
		@FindBy(id="BillingNewAddress_CountryId")
		WebElement BillingCountryId;
		
		@FindBy(id="BillingNewAddress_StateProvinceId")
		WebElement BillingStateId;
		
		@FindBy(id="BillingNewAddress_City")
		WebElement BillingCity;
		
		@FindBy(id="BillingNewAddress_Address1")
		WebElement BillingTown;
		
		@FindBy(id="BillingNewAddress_ZipPostalCode")
		WebElement BillingPostalCode;
		
		@FindBy(id="BillingNewAddress_PhoneNumber")
		WebElement BillingPhNo;
		
//		@FindBy(xpath="")	//if the address is already saved, then we use this
//		WebElement SaveAddressButton;
		
		@FindBy(xpath="//button[text()='Continue' and @class='button-1 new-address-next-step-button']")
		WebElement BillingConBtn;
		
		@FindBy(xpath="//button[text()='Continue' and @onclick='if (!window.__cfRLUnblockHandlers) return false; Shipping.save()']")
		WebElement ShippingAddConBtn;
		
		//button[text()='Continue' and @class='button-1 shipping-method-next-step-button' and@type='button']
		@FindBy(xpath="//button[text()='Continue' and @class='button-1 shipping-method-next-step-button' and@type='button']")
		WebElement ShippingMethodConBtn;
		
		@FindBy(xpath="//button[text()='Continue' and @name='save' and @class='button-1 payment-method-next-step-button']")
		WebElement PaymentMethodConBtn;
		
		@FindBy(xpath="//button[text()='Continue' and @class='button-1 payment-info-next-step-button']")
		WebElement PaymentInfoConBtn;
		
		@FindBy(xpath="//button[text()='Confirm']")
		WebElement ConfirmCheckout;
		
		@FindBy(linkText="Log out")
		WebElement ClickOnLogout;
		
		
		//action methods
		
		
		public void search(String product)
		{
			SearchTxtBox.sendKeys(product);
		}
		
		public void clickOnSearch()
		{
			ClickOnSearch.click();
		}
		
		public void clickOnComputers()
		{
			ClickOnComputers.click();
		}
		
		public void clickOnDesktops()
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ClickOnDekstops );

		}
		
		public void clickOnOneProduct()
		{
			ClickOnProduct.click();
		}
		
		public void addToWishlist()
		{
			AddToWishlist.click();
		}
		
		public void addToCart() throws InterruptedException
		{
			//Thread.sleep(3000);
			AddToCart.click();
		}
		
		
		public void goToCart()
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
			js.executeScript("arguments[0].click();", GoToCart);
		}
		
		public void agreeTerms()
		{
			AgreeTerms.click();
		}
		
		public void clickOnCheckout()
		{
//			 By checkoutBy = By.id("checkout");
//			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//			    // Scroll a bit to bring into view
//			    JavascriptExecutor js = (JavascriptExecutor) driver;
//			    js.executeScript("window.scrollBy(0, 100)");
//
//			    // Wait until the button is really clickable, then click
//			    WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkoutBy));
//			    checkoutBtn.click();
	//	JavascriptExecutor js=(JavascriptExecutor)driver;
//			js.executeScript("window.scrollBy(0, 100)");
//			
			ClickOnCheckout.click();
			
		}
		
//		public void sameAddressCheckbox() throws InterruptedException
//		{
//			if(SameAddressCheckbox.isSelected())
//			{
//				SameAddressCheckbox.click();
//			}
//			Thread.sleep(2000);
//			if(DeleteBtn.isDisplayed())
//			{
//				DeleteBtn.click();
//			}
//		}
		
		public void billingCountry(String country)
		{
			By countryBy = By.id("BillingNewAddress_CountryId");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			// wait for presence and visibility and clickable using locator
			wait.until(ExpectedConditions.presenceOfElementLocated(countryBy));
			wait.until(ExpectedConditions.visibilityOfElementLocated(countryBy));
			wait.until(ExpectedConditions.elementToBeClickable(countryBy));

			WebElement countryElem = driver.findElement(countryBy);
			Select select = new Select(countryElem);
			select.selectByVisibleText(country);
//			Select sle1=new Select(BillingCountryId);
//			sle1.selectByVisibleText(country);
//			BillingCountryId.sendKeys(Keys.TAB);
		}
		
		public void billingState(String state) throws InterruptedException
		{
			 By stateBy = By.id("BillingNewAddress_StateProvinceId");//id="BillingNewAddress_StateProvinceId"
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			    // Wait until state dropdown is enabled & visible after selecting country
			    wait.until(ExpectedConditions.elementToBeClickable(stateBy));

			    WebElement stateElem = driver.findElement(stateBy);
			    Select select = new Select(stateElem);
			    select.selectByVisibleText(state);
//			Thread.sleep(2000);
//		    Select sle=new Select(BillingStateId);
//		    sle.selectByVisibleText(state);
		}
		
		public void billingCity(String city)
		{
			BillingCity.sendKeys(city);
		}
		
		public void billingTown(String town)
		{
			BillingTown.sendKeys(town);
		}
		
		public void billingPostalCode(String code)
		{
			BillingPostalCode.sendKeys(code);
		}
		
		public void billingPhNo(String phno)
		{
			BillingPhNo.sendKeys(phno);
		}
		
		
//		public void saveButton()  //use when address is already saved
//		{
//			driver.findElement(By.cssSelector("button[name='save']")).click();
//	    	Thread.sleep(2000);
//		}
		
		public void blilingConBtn() 
		{
			BillingConBtn.click();
			

		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		        wait.until(ExpectedConditions.alertIsPresent());
		        Alert alert = driver.switchTo().alert();
		        System.out.println("Alert text: " + alert.getText());
		        alert.accept();   // click OK
		        throw new RuntimeException("Checkout blocked: " + alert.getText());
		    } catch (TimeoutException e) {
		        // no alert, continue normally
		    	e.printStackTrace();
		    }
		}
		
		public void shippingMethod() throws InterruptedException
		{
			Thread.sleep(2000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ShippingMethodConBtn);
		}
		
		public void paymentMethod() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.findElement(By.id("paymentmethod_0")).click(); 
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", PaymentMethodConBtn);
	       // PaymentMethodConBtn.click();
		}
		
		public void paymentInformation() throws InterruptedException
		{
			Thread.sleep(2000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", PaymentInfoConBtn);
			Thread.sleep(2000);
			//PaymentInfoConBtn.click();
		}
		
		public void confirmCheckout() throws InterruptedException
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ConfirmCheckout);
			//ConfirmCheckout.click();
			Thread.sleep(3000);
		}
		
		public void clickOnLogout() throws InterruptedException 
		{
			Thread.sleep(3000);
			ClickOnLogout.click();
		}


	}
//    public CheckoutPage(WebDriver driver) {
//        super(driver);
//    }
//
//    @FindBy(linkText = "Computers")
//    WebElement ClickOnComputers;
//
//    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']")
//    WebElement ClickOnDekstops;
//
//    @FindBy(linkText = "Build your own computer")
//    WebElement ClickOnProduct;
//
//    @FindBy(xpath = "//button[@id='checkout']")
//    WebElement ClickOnCheckout;
//
//    @FindBy(id = "termsofservice")
//    WebElement AgreeTerms;
//
//    @FindBy(id = "ShipToSameAddress")
//    WebElement SameAddressCheckbox;
//
//    @FindBy(id = "delete-billing-address-button")
//    WebElement DeleteBtn;
//
//    @FindBy(id = "BillingNewAddress_FirstName")
//    WebElement BillingFirstName;
//
//    @FindBy(id = "BillingNewAddress_LastName")
//    WebElement BillingLastName;
//
//    @FindBy(id = "BillingNewAddress_Email")
//    WebElement BillingEmail;
//
//    @FindBy(id = "BillingNewAddress_CountryId")
//    WebElement BillingCountryId;
//
//    @FindBy(id = "BillingNewAddress_StateProvinceId")
//    WebElement BillingStateId;
//
//    @FindBy(id = "BillingNewAddress_City")
//    WebElement BillingCity;
//
//    @FindBy(id = "BillingNewAddress_Address1")
//    WebElement BillingTown;
//
//    @FindBy(id = "BillingNewAddress_ZipPostalCode")
//    WebElement BillingPostalCode;
//
//    @FindBy(id = "BillingNewAddress_PhoneNumber")
//    WebElement BillingPhNo;
//
//    @FindBy(xpath = "//button[text()='Continue' and @class='button-1 new-address-next-step-button']")
//    WebElement BillingConBtn;
//
//    @FindBy(xpath = "//button[text()='Continue' and @onclick='if (!window.__cfRLUnblockHandlers) return false; Shipping.save()']")
//    WebElement ShippingAddConBtn;
//
//    @FindBy(xpath = "//button[text()='Continue' and @class='button-1 shipping-method-next-step-button' and @type='button']")
//    WebElement ShippingMethodConBtn;
//
//    @FindBy(xpath = "//button[text()='Continue' and @name='save' and @class='button-1 payment-method-next-step-button']")
//    WebElement PaymentMethodConBtn;
//
//    @FindBy(xpath = "//button[text()='Continue' and @class='button-1 payment-info-next-step-button']")
//    WebElement PaymentInfoConBtn;
//
//    @FindBy(xpath = "//button[text()='Confirm']")
//    WebElement ConfirmCheckout;
//
//    @FindBy(linkText = "Log out")
//    WebElement ClickOnLogout;
//
//    // Action methods
//    public void clickOnComputers() {
//        ClickOnComputers.click();
//    }
//
//    public void clickOnDesktops() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", ClickOnDekstops);
//    }
//
//    public void clickOnOneProduct() {
//        ClickOnProduct.click();
//    }
//
//    public void agreeTerms() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("termsofservice")));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", AgreeTerms);
//        wait.until(ExpectedConditions.elementToBeClickable(AgreeTerms));
//        try {
//            AgreeTerms.click();
//        } catch (Exception e) {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", AgreeTerms);
//        }
//    }
//
//    public void clickOnCheckout() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 100)");
//        ClickOnCheckout.click();
//    }
//
//    public void billingCountry(String country) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.visibilityOf(BillingCountryId));
//        Select countrySelect = new Select(BillingCountryId);
//        countrySelect.selectByVisibleText(country);
//        By stateOptionsLocator = By.cssSelector("#BillingNewAddress_StateProvinceId option");
//        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(stateOptionsLocator, 1));
//    }
//
//    public void billingState(String state) throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        By stateSelectLocator = By.id("BillingNewAddress_StateProvinceId");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(stateSelectLocator));
//
//        WebElement stateElem = driver.findElement(stateSelectLocator);
//        Select stateSelect = new Select(stateElem);
//
//        boolean found = false;
//        for (int i = 0; i < 10; i++) {
//            for (WebElement opt : stateSelect.getOptions()) {
//                if (opt.getText().trim().equals(state)) {
//                    found = true;
//                    break;
//                }
//            }
//            if (found) break;
//            Thread.sleep(300);
//            stateSelect = new Select(driver.findElement(stateSelectLocator));
//        }
//
//        if (!found) {
//            System.out.println("Available state options:");
//            for (WebElement opt : stateSelect.getOptions()) {
//                System.out.println("-> '" + opt.getText().trim() + "'");
//            }
//            throw new RuntimeException("State option '" + state + "' not found in dropdown.");
//        }
//        stateSelect.selectByVisibleText(state);
//    }
//
//    public void billingCity(String city) {
//        BillingCity.sendKeys(city);
//    }
//
//    public void billingTown(String town) {
//        BillingTown.sendKeys(town);
//    }
//
//    public void billingPostalCode(String code) {
//        BillingPostalCode.sendKeys(code);
//    }
//
//    public void billingPhNo(String phno) {
//        BillingPhNo.sendKeys(phno);
//    }
//
//    public void blilingConBtn() {
//        BillingConBtn.click();
//    }
//
//    public void shippingMethod() throws InterruptedException {
//        Thread.sleep(2000);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", ShippingMethodConBtn);
//    }
//
//    public void paymentMethod() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.findElement(By.id("paymentmethod_0")).click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", PaymentMethodConBtn);
//        PaymentMethodConBtn.click();
//    }
//
//    public void paymentInformation() throws InterruptedException {
//        Thread.sleep(2000);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", PaymentInfoConBtn);
//        Thread.sleep(2000);
//        PaymentInfoConBtn.click();
//    }
//
//    public void confirmCheckout() throws InterruptedException {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", ConfirmCheckout);
//        ConfirmCheckout.click();
//        Thread.sleep(3000);
//    }
//
//    public void clickOnLogout() throws InterruptedException {
//        Thread.sleep(3000);
//        ClickOnLogout.click();
//    }
//}
