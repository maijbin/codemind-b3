package com.codemind.b3project;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
//import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
//import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners

public class Homepagetestcases {
	WebDriver driver;
	Homepage homepage;
	
	
	@BeforeMethod
	public void initializebrowser()
	{
		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dataProvider="myDataProvider")
	public void verifyvalidlogin(String username,String password)
	{
		homepage=new Homepage(driver);
		driver.get(UtilityMethods.getProperty("url"));
		homepage.setUserName();
		homepage.getUserName().sendKeys(username);
		homepage.setPassword();
		homepage.getPassword().sendKeys(password);
		homepage.setLoginButtton();
		homepage.getLoginButtton().click();
		UtilityMethods.scrollTillEndofThePage(driver);
		assertEquals(homepage.getLoginsuccessfullymsg().getText(),"Login Successfully");
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(homepage.getLoginsuccessfullymsg().getText(),"Login Successfully");
		UtilityMethods.takeScreenshot(driver);
		System.out.println("test case starting");
	}
	@Test
	public void verifyregistration() {
		homepage=new Homepage(driver);
		homepage.getRegisterLink().click();
		UtilityMethods.waitforPgeTitle(driver,5,"Register: Mercury Tours");
	}
	@AfterMethod
	public void teardown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				UtilityMethods.getScreenshot(result.getName()+System.currentTimeMillis(), driver);
				
			}catch(IOException e)
			{
			e.printStackTrace();	
			}
		}
		driver.quit();
	}

}
