package BR.Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BR.TestComponents.BaseTest;
import BR.pageobjects.CartPage;
import BR.pageobjects.ConfirmationPage;
import BR.pageobjects.LandingPage;
import BR.pageobjects.OrderPage;
import BR.pageobjects.PaymentInfo;
import BR.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
	
	//String productName = "zara coat 3";

	@Test(dataProvider = "getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));

		CartPage cartPage = productCatalogue.openCart();

		Boolean match = cartPage.matchProduct(input.get("product"));
		Assert.assertTrue(match);

		PaymentInfo paymentInfo = cartPage.clickCheckout();

		paymentInfo.selectCountryDropdown("ind");

		String selectedCountry = "India";

		paymentInfo.clickCountry(selectedCountry);
		ConfirmationPage confirmationPage = paymentInfo.clickSubmit();
		String msg = confirmationPage.getActualConfirmation();

		System.out.println(msg);
		String expectedConfirmation = "THANKYOU FOR THE ORDER.";

		Assert.assertTrue(msg.equalsIgnoreCase(expectedConfirmation));


	}

	
	
	  @Test(dataProvider = "getData", dependsOnMethods = {"submitOrder"}) 
	  public void orderHistory(HashMap<String, String> input) {
	  ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
	  OrderPage ordersPage = productCatalogue.goToOrderPage();
	  Assert.assertTrue(ordersPage.verifyOrderDisplay(input.get("product")));
	  //ordersPage.deleteProducts(productName);
	  
	  }
	  
	
	@DataProvider 
	public Object[][] getData() throws IOException
	{

		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+ "\\src\\test\\java\\BR\\data\\PurchaseOrder.json");
		 return new Object[][] {{data.get(0)},{data.get(1)}};
		 
		
	
		
		
		
		
		//return new Object[][] {{"abc802386@mail.com","Rayleigh@23","ZARA COAT 3"},{"json@gmail.com","January@23","ADIDAS ORIGINAL"}};
			/*
			 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
			 * "abc802386@mail.com"); map.put("password", "Rayleigh@23"); map.put("product",
			 * "ZARA COAT 3");
			 * 
			 * HashMap<String, String> map1 = new HashMap<String, String>();
			 * map1.put("email", "json@gmail.com"); map1.put("password", "January@23");
			 * map1.put("product", "ADIDAS ORIGINAL");
			 */
	}
}
