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

public class ConfirmationPage extends AbstractComponents{
	
	WebDriver driver;
	
	//Create a constructor
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//PageFactory 
//driver.findElement(By.cssSelector(".hero-primary"))
	
	
	
	@FindBy(css = ".hero-primary")
	WebElement actualConfirmation;
	
	

	
	
	public String getActualConfirmation()
	{
		String msg = actualConfirmation.getText();
		return msg;
		
	}
	


	
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group-item")));
	
	//List<WebElement> options1 = driver.findElements(By.cssSelector(".list-group-item"));


	//Test Jenkins GitHub Integration
	 
	

	 

	 

	 
	 

}
