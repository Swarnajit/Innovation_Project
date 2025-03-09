package com.elements;

import org.openqa.selenium.By;

public class ListOfElements {
	
		
		public static By loginButton = By.id("login_Layer");
		public static By email = 
				By.xpath("//input[@placeholder='Enter your active Email ID / Username']");
		public static By password = 
				By.xpath("//input[@placeholder='Enter your password']");
		public static By userIcon = By.xpath("//img[@alt='naukri user profile img']");
		public static By updateUser = By.xpath("//a[normalize-space()='View & Update Profile']");
		public static By editPencilIcon = By.xpath("//em[contains(@class,'icon edit')]");
		public static By saveDetails = By.xpath("//button[@id='saveBasicDetailsBtn']");
		public static By logOut = By.xpath("//a[normalize-space()='Logout']");
		
		
	}
