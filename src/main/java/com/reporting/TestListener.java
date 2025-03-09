package com.reporting;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test Passed: " + result.getName());
		WebDriver driver = (WebDriver) result.getAttribute("WebDriver");
		
        if (driver != null) {
            try {
				ScreenshotUtil.takeSnapShot(driver, result.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            System.out.println("WebDriver instance is null, cannot capture screenshot.");
        }
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Failed: " + result.getName());

        // Fetch WebDriver from the test result attributes
        WebDriver driver = (WebDriver) result.getAttribute("WebDriver");

        if (driver != null) {
            try {
				ScreenshotUtil.takeSnapShot(driver, result.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            System.out.println("WebDriver instance is null, cannot capture screenshot.");
        }
		

	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test Skipped: " + result.getName());
	}

}
