package com.codemind.b3project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver driver)
	{
		this.driver = driver;
	}

	WebElement userName;
	WebElement password;
	WebElement loginButtton;
	WebElement loginsuccessfullymsg;
	WebElement registerLink;
	public WebElement getUserName() {
		return userName;
	}

	public void setUserName() {
	 userName=driver.findElement(By.xpath("//input[@name='userName']"));
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword() {
		password = driver.findElement(By.xpath("//input[@name='password']"));
	}

	public WebElement getLoginButtton() {
		return loginButtton;
	}

	public void setLoginButtton() {
		loginButtton = driver.findElement(By.xpath("//input[@name='submit']"));
	}

	public WebElement getLoginsuccessfullymsg() {
		return loginsuccessfullymsg;
	}

	public void setLoginsuccessfullymsg() {
	loginsuccessfullymsg = driver.findElement(By.xpath("//h3[text='Login Successfully"));
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public void setRegisterLink() {
		this.registerLink=driver.findElement(By.linkText("REGISTER"));
	}
}
