package com.qa.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDemo {

	private RemoteWebDriver driver;

	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}

	@Test
	void testBing() {
		this.driver.get("https://www.bing.co.uk");

		WebElement searchBar = this.driver.findElement(By.id("sb_form_q"));

		searchBar.sendKeys("turtles");

//		searchBar.sendKeys(Keys.ENTER);

		WebElement searchButton = this.driver.findElement(By.xpath("//*[@id=\"sb_form\"]/label"));

		searchButton.click();

		WebElement scientific;
//		scientific = this.driver.findElement(By.cssSelector(
//				"#b_context > li:nth-child(1) > div.b_entityTP > div:nth-child(2) > div > ul > li:nth-child(1) > div"));

		scientific = this.driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div[1]/div[2]/div/ul/li[1]/div"));

		Assertions.assertTrue(scientific.getText().contains("Testudines"));
	}

	@AfterEach
	void tearDown() {
		this.driver.close();
	}

}
