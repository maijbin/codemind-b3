package com.codemind.b3project;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Testnglistners {
	public class ListnersInTestNG implements ITestListener{
		
		public void onTestStart(ITestResult Result) {
		
			Reporter.log("Test case is started"+Result.getName());
			//System.out.println("Test case Started");both are same in testng
		}
		public void onTestSuccess(ITestResult Result)
		{
			System.out.println("The passed test case: "+Result.getName());
		}
		
		public void onfinish(ITestContext Result)
		{
			
		}
		public void onStart(ITestContext Result)
		{
			System.out.println("Our test case execution has been started");
		}
		public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
		{
			
		}
		public void onTestFailure(ITestResult Result,WebDriver driver)
		{
			if(Result.getStatus()==ITestResult.FAILURE)
			{
				try
				{
					UtilityMethods.getScreenshot(Result.getName(), driver);
				}catch(IOException e)
				{
					e.printStackTrace();
				}
				Reporter.log("Test case failed:"+Result.getName());
			}
		}
	}


}
