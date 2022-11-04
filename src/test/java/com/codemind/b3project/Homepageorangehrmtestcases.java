package com.codemind.b3project;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Homepageorangehrmtestcases {
	WebDriver driver;
	Homepageorangehrm home;
	@BeforeMethod
	public void initializing()
	{
		System.setProperty("webdriver.chrome.driver",
				"E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Test
	public void verifyvalidation() {
		home=new Homepageorangehrm(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		home.setUserName();
		home.getUserName().sendKeys("Admin");
		home.setPassword();
		home.getPassword().sendKeys("admin123");
		home.setLogin();
		home.getLogin().click();
		assertEquals(home.getLoginsuccessfullymsg().getText(),"Login Successfully");
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(home.getLoginsuccessfullymsg().getText(),"Login Successfully");
	}

}
