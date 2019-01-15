package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

	@Test(priority =1, groups = { "smokeTests", "negativeTests" })
	public void IncorrectUserNameTest() {
		System.out.println("Starting Negative Test");
		// Create Driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		sleep(2000);

		// Open the page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		sleep(2000);
		System.out.println("Page is opened");

		// enter incorrect username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("kmurillo");

		// enter Password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");

		// Click Login button
		WebElement loginButton = driver.findElement(By.className("radius"));
		loginButton.click();

		// Validate successfully message
		WebElement errorMessage = driver.findElement(By.id("flash"));
		String expectedMessage = "Your username is invalid!";
		String actualErrorMessage = errorMessage.getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedMessage),
				"actualErrorMessage does not contain expectedMessage\nexpectedMessage: "
						+ expectedMessage + "\nactualerrorMessage: " + actualErrorMessage);

		sleep(3000);

		driver.quit();
		
	}
	
		@Test(priority =2, groups = { "negativeTests" })
		public void NegativePasswordTest() {
			System.out.println("Starting Negative Password Test");
			// Create Driver
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();

			sleep(2000);

			// Open the page
			String url = "https://the-internet.herokuapp.com/login";
			driver.get(url);
			sleep(2000);
			System.out.println("Page is opened");

			// enter incorrect username
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys("tomsmith");

			// enter Password
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys("SuperSecretPassword!!");

			// Click Login button
			WebElement loginButton = driver.findElement(By.className("radius"));
			loginButton.click();

			// Validate successfully message
			WebElement errorMessage = driver.findElement(By.id("flash"));
			String expectedMessage = "Your password is invalid!";
			String actualErrorMessage = errorMessage.getText();
			Assert.assertTrue(actualErrorMessage.contains(expectedMessage),
					"actualErrorMessage does not contain expectedMessage\nexpectedMessage: "
							+ expectedMessage + "\nactualerrorMessage: " + actualErrorMessage);

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
