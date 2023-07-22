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

public class PaymentInfo extends AbstractComponents{
	
	WebDriver driver;
	
	//Create a constructor
	public PaymentInfo(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//PageFactory 
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	

	//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
	
	//driver.findElement(By.cssSelector(".action__submit ")).click();
	
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(css=".list-group-item")
	List<WebElement> options1;
	
	@FindBy(css = ".action__submit ")
	WebElement submitButton;
	
	By optionsBy = By.cssSelector(".list-group-item");

	
	
	public void selectCountryDropdown(String text)
	{
		selectCountry.sendKeys(text);
	}
	
	public void clickCountry(String selectedCountry)
	{
		waitForElementToAppear(optionsBy);
		
		 WebElement populatedCountry = options1.stream().filter(c-> c.getText().equalsIgnoreCase(selectedCountry)).findFirst().orElse(null);
		 populatedCountry.click();
	}
	
	public ConfirmationPage clickSubmit()
	{
		submitButton.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}

	
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group-item")));
	
	//List<WebElement> options1 = driver.findElements(By.cssSelector(".list-group-item"));
	 
	

	 

	 

	 
	 

}
