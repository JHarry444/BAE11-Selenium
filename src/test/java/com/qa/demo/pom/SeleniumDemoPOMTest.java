package com.qa.demo.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumDemoPOMTest {

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
		SearchPage page = PageFactory.initElements(driver, SearchPage.class);
		this.driver.get(page.URL); // opens a URL
		page.search("badger");

		Assertions.assertTrue(page.checkResult().contains("Peter Rabbit"));
	}

	@AfterEach
	void tearDown() {
		this.driver.close(); // closes da window
	}

}
