package com.actitime.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.LoginPage;

public class BaseClass {
	static {
	System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String url=FileLib.getPropertyData("url");
		driver.get(url);
		
	}
	@AfterTest
	public void closeBrowser() {
		//driver.close();
		
	}
	@BeforeMethod
	public void login() throws IOException {
		String uname=FileLib.getPropertyData("username");
		String pwd=FileLib.getPropertyData("password");
		LoginPage lp=new LoginPage(driver);
		lp.setLogin(uname, pwd);
	}
	@AfterMethod
	public void logout() throws InterruptedException  {
		LoginPage lp=new LoginPage(driver);
		lp.setLogout();
	}
	
		
	}

