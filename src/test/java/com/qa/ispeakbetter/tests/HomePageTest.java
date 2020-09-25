package com.qa.ispeakbetter.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.HomePage;


public class HomePageTest {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	HomePage homePage;
	
	@BeforeTest
	
	public void setUp() throws InterruptedException {
		basePage=new BasePage();
		prop=basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage= new HomePage(driver);
	}
	@Test(priority=1)
	public void verifyPageTitle() {
		
		String title=homePage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Learn English with Online Teachers -"
				+ " Get your Free Live English Class Now.");
	}
	@Test(priority=2)
	public void verifyHeader() {
		String header=homePage.getHeader();
		Assert.assertEquals(header, "Speak English Better Wherever You Are");
	}
   @Test(priority=3)
   public void gochatBoxTest() throws InterruptedException {
	   String chatHeader=homePage.goChatBox();
	   Assert.assertEquals(chatHeader, "Chat with us now!");
   }
   @AfterTest()
   public void tearDown() {
	   driver.quit();
   }
}
