package com.codemind.b3project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegestrationPage {
	WebDriver driver;
	WebElement firstNameTextBox;
	WebElement subminButton;
	WebElement countrydropdown;
	public RegestrationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getFirstNameTextBox() {
		return firstNameTextBox;
	}
	public void setFirstNameTextBox(WebElement firstNameTextBox) {
		firstNameTextBox = driver.findElement(By.xpath("//input[@name='firstName']"));
	}
	public WebElement getSubminButton() {
		return subminButton;
	}
	public void setSubminButton(WebElement subminButton) {
		subminButton = driver.findElement(By.xpath("//input[@name='submit']"));
	}
	public WebElement getCountrydropdown() {
		return countrydropdown;
	}
	public void setCountrydropdown(WebElement countrydropdown) {
		countrydropdown = driver.findElement(By.xpath("//select[@name='country']"));
	}

}
