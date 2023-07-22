package abs.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BR.pageobjects.CartPage;
import BR.pageobjects.OrderPage;




public class AbstractComponents {
	
	
	WebDriver driver;
	
    public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
    	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    @FindBy(css = "[routerlink*='cart']")
	WebElement cartIcon;
    
    @FindBy(css = "[routerlink*='myorders']")
	WebElement orderPage;
    
    

    
	public CartPage openCart()
	{
		waitForWebElementToAppear(cartIcon);
		cartIcon.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrderPage()
	{
		waitForWebElementToAppear(orderPage);
		orderPage.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
		
	}
	
	

	public void waitForElementToAppear(By findBy)
    {
    	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
    }
	
	public void waitForWebElementToAppear(WebElement ele)
    {
    	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(ele));
	
    }
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * wait.until(ExpectedConditions.invisibilityOf(ele));
		 */
	}

}
