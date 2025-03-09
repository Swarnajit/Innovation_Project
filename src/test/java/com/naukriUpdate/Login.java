package com.naukriUpdate;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.elements.ListOfElements;
import com.reporting.TestListener;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(TestListener.class)
public class Login {
	
	static WebDriver wb;
	static WebDriverWait wait;
	
	@BeforeMethod
	public void naukriLogin(ITestResult result)
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-agent=Chrome/134.0.0.0");
		wb = new ChromeDriver(options);
		wb.get("https://www.naukri.com");
		wb.manage().window().maximize();
		
        // Store WebDriver in the test result context
        result.setAttribute("WebDriver", wb);
	}
	
	@AfterMethod
	public void naukriLogout()
	{
		wait = new WebDriverWait(wb, Duration.ofSeconds(10));
		clickIfItemIsVisible(wait, ListOfElements.userIcon);
		clickIfItemIsVisible(wait, ListOfElements.logOut);
		wb.quit();
	}
	
	@Test
	public void loginToNaukri() throws InterruptedException
	{
		// Login Button
		WebElement loginButton = wb.findElement(ListOfElements.loginButton);		
		loginButton.click();
	
		wait = new WebDriverWait(wb, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ListOfElements.email));
		
		WebElement email = wb.findElement(ListOfElements.email);
		WebElement password = wb.findElement(ListOfElements.password);
		
		email.click();
		email.clear();
		email.sendKeys("swarnajit.adhikary@yahoo.in");
		
		password.click();
		password.clear();
		password.sendKeys("Jhilam@1992");
		
		WebElement loginToSite = wb.findElement(By.xpath("//button[normalize-space()='Login']"));
		loginToSite.click();
		
		clickIfItemIsVisible(wait, ListOfElements.userIcon);
		
		clickIfItemIsVisible(wait, ListOfElements.updateUser);

		clickIfItemIsVisible(wait, ListOfElements.editPencilIcon);
		
		
		WebElement saveDetails = wait.until(ExpectedConditions.elementToBeClickable(ListOfElements.saveDetails));
		
		((JavascriptExecutor) wb).executeScript("arguments[0].scrollIntoView(true);",
				saveDetails);
		
		Thread.sleep(500);
		saveDetails.click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ListOfElements.saveDetails));

		
//		clickIfItemIsVisible(wait, ListOfElements.saveDetails);
		
	}
	
	public void clickIfItemIsVisible(WebDriverWait wait, By xpathOfElement)
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpathOfElement));
		WebElement elementToClick = wb.findElement(xpathOfElement);
		elementToClick.click();
	}

}
