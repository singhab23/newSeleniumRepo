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

public class OrderPage extends AbstractComponents{
	
	WebDriver driver;
	
	//Create a constructor
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//PageFactory 

	
	@FindBy(xpath = "//tr/td[2]")
	List<WebElement> productNames;
	
	
	//.btn-danger
	@FindBy(css = ".btn-danger")
	WebElement deleteButton;

	
	public Boolean verifyOrderDisplay(String productName)
	{
		Boolean match = productNames.stream().anyMatch(a -> a.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public void deleteProducts(String productName)
	{
		
		waitForWebElementToAppear(deleteButton);
		
		productNames.stream().filter(s->s.getText().equalsIgnoreCase(productName)).forEach(s-> deleteButton.click());
		
		
		/*
		 * for(WebElement a: productNames) {
		 * if(a.getText().equalsIgnoreCase(productName)) { deleteButton.click(); break;
		 * } }
		 */
	}
	
	
	

	 
	

	 

	 

	 
	 

}
