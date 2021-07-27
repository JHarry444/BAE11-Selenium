package com.qa.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDemo {

	private RemoteWebDriver driver;

	@BeforeEach
	void setup() {
		ChromeOptions opts = new ChromeOptions();
		opts.setHeadless(true);
		this.driver = new ChromeDriver(opts); // open up a chrome window in automation mode
		this.driver.manage().window().maximize(); // maximises the window
	}

	@Test
	void testBing() {
		this.driver.get("https://www.bbc.co.uk/search"); // opens a URL

		WebElement searchBar = this.driver.findElement(By.id("search-input"));

		searchBar.sendKeys("badger");

//		searchBar.sendKeys(Keys.ENTER);

		WebElement searchButton = this.driver
				.findElement(By.cssSelector("#main-content > div:nth-child(1) > form > div > div > div > button"));

		searchButton.click();

		WebElement scientific;
//		scientific = this.driver.findElement(By.cssSelector(
//				"#b_context > li:nth-child(1) > div.b_entityTP > div:nth-child(2) > div > ul > li:nth-child(1) > div"));

		scientific = this.driver.findElement(By.cssSelector(
				"#main-content > div:nth-child(1) > div.ssrcss-1v7bxtk-StyledContainer.enjd40x0 > div > div > ul > li:nth-child(1) > div > div > div.ssrcss-som5se-PromoContent.e1f5wbog7 > div.ssrcss-rjdkox-Stack.e1y4nx260 > a"));

		Assertions.assertTrue(scientific.getText().contains("Peter Rabbit"));
	}

	@AfterEach
	void tearDown() {
		this.driver.close(); // closes da window
	}

}
