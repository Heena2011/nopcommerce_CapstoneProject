package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//locators for search test case
	@FindBy(xpath="//input[@id='small-searchterms']")
	WebElement searchTxtBox;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement searchBtn;
	
	@FindBy(xpath="//select[@aria-label='Select product sort order']")
	WebElement SortByHighToLow;

	@FindBy(xpath="//div[@class='product-item']")
	List<WebElement> NoOfProducts;
	
	
	//Action methods
	
	public void setsearchTxtBox(String searchedPorduct) {
		searchTxtBox.sendKeys(searchedPorduct);
	}
	public void  clicksearchBtn() {
		searchBtn.click();
	}
	

	public void sortByHighToLow() 
	{
		Select s=new Select(SortByHighToLow);
		s.selectByIndex(4);
	}


	public void verifyNoOfProducts() 
	{
		System.out.println("Total number of apple products are "+NoOfProducts.size());
	}
}
