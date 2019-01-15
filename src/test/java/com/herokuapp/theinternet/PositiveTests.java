package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {

	@Test
	public void logInTest() {
		System.out.println("Starting Login Test");
		// Create Driver
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		 
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		sleep(3000);

		// Open the page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		sleep(5000);
		System.out.println("Page is opened");

		// enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");

		// enter Password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");

		// Click Login button
		WebElement loginButton = driver.findElement(By.className("radius"));
		loginButton.click();

		// Verifications - New URL
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

		// Validate Logout Button visible
		WebElement logout = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logout.isDisplayed(), "Logout button is not displayed");

		// Validate successfully message
		WebElement successMessage = driver.findElement(By.id("flash"));
		String expectedMessage = "You logged into a secure area!";
		String actualSuccessMessage = successMessage.getText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedMessage),
				"Success Message does not contain expectedSuccessMessage\nexpectedMessage: " + expectedMessage
						+ "\nactualSuccessMessage: " + actualSuccessMessage);

		sleep(3000);

		driver.quit();
	}

	/**
	 * Static sleep
	 */
	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
