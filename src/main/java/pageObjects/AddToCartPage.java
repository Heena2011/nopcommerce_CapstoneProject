package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends BasePage{

	public AddToCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//locating element for add to cart
//	@FindBy(xpath="//h2[@class=\"product-title\"]")
//	WebElement AllProduct;
	
	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	WebElement AddToCart;
	
	@FindBy(xpath="//span[@class='cart-label']")
	WebElement ShoppingCartBtn;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement CheckoutBtn;
	
	@FindBy(xpath = "//button[@class=\"button-1 add-to-cart-button\"]")
	WebElement addingProductTocartBtn;
	
	
	//Action methods
//	public void addProductTocart(String product) {
//		AllProduct.sendKeys(product);
//	}
//	
//	public void clickAddtoCartProductBtn() {
//		AddToCart.click();
//	}
	
	public void clickShoppingCartBtn() {
		ShoppingCartBtn.click();
	}
	public void clickCheckoutBtn() {
		CheckoutBtn.click();
	}
	
	public void addToCart() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
		Thread.sleep(3000);
		AddToCart.click();
		
		//js.executeScript("window.scrollBy(0, -document.body.scrollHeight/2)", "");
		//js.executeScript("window.scrollTo({ top: document.body.scrollHeight/2, behavior: 'smooth' });");
		
		
	}
	public void  clickaddingProductTocartBtn() {
		addingProductTocartBtn.click();
	}
}
