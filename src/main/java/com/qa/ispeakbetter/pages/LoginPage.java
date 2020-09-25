package com.qa.ispeakbetter.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.utils.ElementUtil;
import com.qa.ispeakbetter.utils.JavaScriptUtil;


public class LoginPage extends BasePage{

	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil js;

	//By loginButton=By.id("cmdSiginLink");
	By loginButton=By.xpath("//a[@id='cmdSiginLink']");
	By email=By.id("_email");
	By password=By.id("_password");
	//By doLogin=By.id("cmdSignin");
	By doLogin=By.xpath("//button[@id='cmdSignin']");
	By errorMessage=By.id("crendentialsError");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		js=new JavaScriptUtil(driver);
	}
	
	public void goLoginButton() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//	elementUtil.waitForElementPresent(loginButton);
	//	elementUtil.doClick(loginButton);
		WebElement clickLogIn=driver.findElement(loginButton);
		js.clickElementByJS(clickLogIn);
		elementUtil.doSendKeys(email, "telgaz@gmail.com");
		elementUtil.doSendKeys(password, "test345");
		Thread.sleep(3000);
		//elementUtil.doClick(loginButton);
		WebElement loginEl=driver.findElement(doLogin);
		js.clickElementByJS(loginEl);
		Thread.sleep(3000);
		
	}
	
	public void enableLogin() {
		System.out.println(elementUtil.doIsEnabled(doLogin));
	}
	public String getErrorMessage() {
		elementUtil.waitForElementPresent(errorMessage);
		return elementUtil.doGetText(errorMessage);
		
	}
}
