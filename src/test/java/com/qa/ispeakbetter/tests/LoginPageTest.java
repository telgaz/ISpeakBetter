package com.qa.ispeakbetter.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.LoginPage;



public class LoginPageTest {


	BasePage basePage;
	Properties prop;
	WebDriver driver;
    LoginPage loginPage;
   
    @BeforeTest
	public void setup() {
	
	basePage =new BasePage();
	prop=basePage.init_properties();
	String browserName=prop.getProperty("browser");
	driver=basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	loginPage=new LoginPage(driver);
}
    @Test(priority=1)
    public void loginButtonTest() throws InterruptedException {
    	loginPage.goLoginButton();
    }
    @Test(priority=3)
    public void enableTest() {
    	loginPage.enableLogin();
    }
    @Test(priority=2)
    public void errorMessageTest() {
    	String message=loginPage.getErrorMessage();
    	Assert.assertEquals(message, "Wrong Username or password!");
    }
    @AfterTest
    public void tearDown() {
    	driver.quit();
    }
    
    
    
    
    
    
    
    
}