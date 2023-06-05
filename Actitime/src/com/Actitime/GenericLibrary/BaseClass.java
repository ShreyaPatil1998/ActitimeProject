package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.math3.ml.neuralnet.UpdateAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitme.ObjectRepository.LoginPage;

public class BaseClass {
	FileLibrary fl=new FileLibrary();
	public WebDriver driver;
@BeforeSuite
public void databaseconnection() {
	Reporter.log("database connected",true);
}
@BeforeClass
public void launchBrowser() throws IOException{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	String actitimeurl=fl.readdataFromPropertyFile("url");
	driver.get(actitimeurl);
	Reporter.log("browser launched",true);
	}
@BeforeMethod
public void login() throws IOException {
	LoginPage lp=new LoginPage(driver);
	String un=fl.readdataFromPropertyFile("username");
	String pw=fl.readdataFromPropertyFile("password");
	lp.getUntbx().sendKeys(un);
	lp.getPwtbx().sendKeys(pw);
	lp.getLgbtn().click();
	Reporter.log("logged in to actitime",true);
	}
@AfterMethod
public void logout() {
	driver.findElement(By.id("logoutLink")).click();
	Reporter.log("logged out successfully",true);
}
@AfterClass
public void classBrowser() {
	driver.close();
	Reporter.log("Browser closed",true);
}
@AfterSuite
public void databasedisconnected() {
	Reporter.log("Database disconnected",true);
}
}

