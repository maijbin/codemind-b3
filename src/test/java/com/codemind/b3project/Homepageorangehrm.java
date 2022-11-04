package com.codemind.b3project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepageorangehrm {
	WebDriver driver;
	public Homepageorangehrm(WebDriver driver)
	{
		this.driver=driver;
		
	}
	WebElement userName;
	WebElement password;
	WebElement Login;
	WebElement loginsuccessfullymsg;
	public WebElement getUserName() {
		return userName;
	}
	public void setUserName() {
		userName=driver.findElement(By.xpath("//input[@name='username']"));
	}
	public WebElement getPassword() {
		return password;
	}
	public void setPassword() {
		password=driver.findElement(By.xpath("//input[@name='password']"));
	}
	public WebElement getLogin() {
		return Login;
	}
	public void setLogin() {
		Login = driver.findElement(By.xpath("//button[@type='submit']"));
	}
	public WebElement getLoginsuccessfullymsg() {
		return loginsuccessfullymsg;
	}
	public void setLoginsuccessfullymsg() {
		loginsuccessfullymsg =driver.findElement(By.xpath("//h3[text()='Login Successfully']")) ;
	}

}
