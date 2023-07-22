package BR.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abs.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	//Create a constructor
	public LandingPage(WebDriver driver)
	{
		
		//create the super keyword to give life to driver in parent class
		super(driver);  
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//PageFactory
	
	 @FindBy(id="userEmail")
	 WebElement emailID;
	 
	 //driver.findElement(By.id("userPassword"))
	 
	 @FindBy(id="userPassword")
	 WebElement passwordElement;
	 
	 @FindBy(id="login")
	 WebElement submit;
	 
	 @FindBy(css = "[class*=\"toast-message ng-star-inserted\"]")
	 WebElement errorMsg;
	 
	 public ProductCatalogue loginApplication(String email, String password)
	 {
		 emailID.sendKeys(email);
		 passwordElement.sendKeys(password);
		 waitForWebElementToAppear(submit);
		 submit.click();
		 ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		 return productCatalogue;
	 }
	 
	 public void goTo()
	 {
		 driver.get("https://rahulshettyacademy.com/client");
	 }
	 
	 public String getErrorMsg()
	 {
		 waitForWebElementToAppear(errorMsg);
		 return errorMsg.getText();
	 }


	 

}
