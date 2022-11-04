package com.codemind.b3project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityMethods {
	
	public static String getProperty(String key) 
	{
		Properties properties=new Properties();
		try
		{
		File file=new File("src/test/resources/MasterData.properties");
		FileInputStream fileinputstream;
		fileinputstream=new FileInputStream(file);
		properties.load(fileinputstream);
		return properties.getProperty(key);
	}
		catch(IOException e)
		{
		e.printStackTrace();
		
		
		}
	
		return properties.getProperty(key);
	}
	public static void scrollTillEndofThePage(WebDriver driver)
	{
		JavascriptExecutor javascriptexecutor=(JavascriptExecutor)driver;
		javascriptexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public static void takeScreenshot(WebDriver driver)
	{
		try {
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
	File file=takescreenshot.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File("screenshot/"+System.currentTimeMillis()+".png"));
		}
	catch(IOException e)
	{
		e.printStackTrace();	
	
	}

}
public static void selectdropdown(WebElement dropdownlocator,String dropdownoption) {
	Select select=new Select(dropdownlocator);
	select.selectByVisibleText(dropdownoption);
	
}
public static void waitforPgeTitle(WebDriver driver,int duration,String title)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.titleContains(title));
	
}
public static void getScreenshot(String name,WebDriver driver) throws IOException
{
	TakesScreenshot takescreenshot=(TakesScreenshot)driver;
	File file=takescreenshot.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File("screenshoot/"+name+System.currentTimeMillis()));
}

}