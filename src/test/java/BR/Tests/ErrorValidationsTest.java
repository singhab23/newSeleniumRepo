package BR.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BR.TestComponents.BaseTest;
import BR.TestComponents.Retry;
import BR.pageobjects.CartPage;
import BR.pageobjects.ConfirmationPage;
import BR.pageobjects.LandingPage;
import BR.pageobjects.PaymentInfo;
import BR.pageobjects.ProductCatalogue;
import BR.TestComponents.Retry;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer = BR.TestComponents.Retry.class)
	public void loginPageErrorValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		landingPage.loginApplication("abc@mail.com", "Rayleigh@23");
		Assert.assertEquals("Incorrect email password.", landingPage.getErrorMsg());

	}

	@Test
	public void productErrorValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String productName = "ZARA COAT 3";

		ProductCatalogue productCatalogue = landingPage.loginApplication("abc802386@mail.com", "Rayleigh@23");

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);

		CartPage cartPage = productCatalogue.openCart();

		Boolean match = cartPage.matchProduct(productName);
		Assert.assertFalse(match);

	}

}
