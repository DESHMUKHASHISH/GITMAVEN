package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static {
		WebDriverManager.chromedriver().setup();
	}
	public static WebDriver driver;
	
	@BeforeTest
	public void openBrowser()
	{
		Reporter.log("Open Browser", true);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
	}
	@AfterTest
	public void closeBrowser()
	{
		Reporter.log("Close Browser", true);
		driver.close();
	}
	@BeforeMethod
	public void login()
	{
		Reporter.log("Login", true);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[.='Login ']")).click();
	}
	@AfterMethod
	public void logout()
	{
		Reporter.log("Logout", true);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("logoutLink")).click();
	}
	
}
