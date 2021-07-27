package com.qa.demo.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

	public final String URL = "https://www.bbc.co.uk/search";

	@FindBy(id = "search-input")
	private WebElement searchBar;
	@FindBy(css = "#main-content > div:nth-child(1) > form > div > div > div > button")
	private WebElement searchButton;
	@FindBy(css = "#main-content > div:nth-child(1) > div.ssrcss-1v7bxtk-StyledContainer.enjd40x0 > div > div > ul > li:nth-child(1) > div > div > div.ssrcss-som5se-PromoContent.e1f5wbog7 > div.ssrcss-rjdkox-Stack.e1y4nx260 > a")
	private WebElement searchResult;

	public void search(String searchTerm) {
		this.searchBar.sendKeys(searchTerm);
		this.searchButton.click();
	}

	public String checkResult() {
		return this.searchResult.getText();
	}

}
