package BR.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import BR.TestComponents.BaseTest;
import BR.pageobjects.CartPage;
import BR.pageobjects.ProductCatalogue;

public class RoughWork {
	
	@Test
	public void productErrorValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--guest");
		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("http://www.google.com");
		driver.quit();

//This is to test merge changes
//Trying to check more changes for commit
		
		//My local changes to check
		//Check again the commit - From My Local

	}

}
