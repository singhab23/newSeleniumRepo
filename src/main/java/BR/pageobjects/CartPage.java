package BR.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import abs.AbstractComponents.AbstractComponents;
import dev.failsafe.internal.util.Assert;

public class CartPage extends AbstractComponents{
	
	//Test the commit again
	
	WebDriver driver;
	
	//Create a constructor
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//PageFactory 
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	

	
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	

	
	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;
	
	
	
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	 
	

	
	public Boolean matchProduct(String productName)
	{
		Boolean match = cartProducts.stream().anyMatch(a -> a.getText().equalsIgnoreCase(productName));
		return match;
		
		
	
	}
	
	
	
	public PaymentInfo clickCheckout()
	{
		checkoutButton.click();
		PaymentInfo paymentInfo = new PaymentInfo(driver);
		return paymentInfo;
	}

	 
	

	 

	 

	 
	 

}
