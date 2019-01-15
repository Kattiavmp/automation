package com.herokuapp.theinternet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DavidTest {
	public static void main(String[] args) { 
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		driver.get("http://www.google.com");
	}
}
