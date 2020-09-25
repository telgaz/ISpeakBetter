package com.qa.ispeakbetter.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.utils.ElementUtil;
import com.qa.ispeakbetter.utils.JavaScriptUtil;



public class HomePage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil js;
 
	//By header=By.xpath("//h1[@class='rsp']");
	By header=By.xpath("//h1[contains(text(),'Speak English Better')]");
	By chatBox=By.id("zsiq_agtpic");
  //  By chatHeader=By.xpath("//div[text()='Chat with us now!']");
    By chatHeader=By.id("attname");
  
    
    public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
		js=new JavaScriptUtil(driver);
	
    }
    public String getPageTitle() {
    	
    	return elementUtil.doGetPageTitle();
    	
    	
    }
   public String getHeader() {
	//   elementUtil.waitForElementPresent(header);
	//   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	   elementUtil.waitForElementVisible(header);
	   
	   return elementUtil.doGetText(header);
	   
	   
   } 
   
public String  goChatBox() throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
	WebElement chatBoxEl=driver.findElement(chatBox);
    js.clickElementByJS(chatBoxEl);

	driver.switchTo().frame(driver.findElement(By.id("siqiframe")));
      Thread.sleep(3000);
	String headerChat=elementUtil.doGetText(chatHeader);
 
	System.out.println(headerChat);
	
	WebElement element = driver.findElement(By.xpath("//div[contains(@class,'win_close sqico-larrow')]"));
	js.clickElementByJS(element);
	driver.switchTo().defaultContent();

	return headerChat;
   
   
}
   
   
   
   
   
}
