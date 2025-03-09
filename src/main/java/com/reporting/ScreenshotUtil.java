package com.reporting;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	public static void takeSnapShot(WebDriver webdriver,String testName) throws Exception{
        try {
            File srcFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File destFile = new File("C:\\Users\\swarn\\eclipse-workspace\\NaukriProject\\src\\main\\resources\\Screenshot\\" + 
            		testName + "_" + timestamp + ".png");

            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
		}
}
