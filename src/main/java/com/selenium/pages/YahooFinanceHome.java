package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooFinanceHome extends BasePage{

    public YahooFinanceHome(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="yfin-usr-qry")
    private WebElement search;   //WebElement for the searchbar

    @FindBy(xpath = "//span[text()='Equity - NYQ']")  // Finds the New York Stock Exchange variant.
    private WebElement equity;

    @FindBy(xpath = "//li[@data-index='0' and @data-test='srch-sym']") // Need both to identify the search term and click it.
    private WebElement equitySearch;

    @FindBy(id = "header-signin-link")
    private WebElement singIn;

    // The method for clicking the sign in button.
    public SignInYahooFinance pressSignInButton(){
        singIn.click();
        return new SignInYahooFinance(driver);
    }

    // The method for searching for the company.
    public Summary searchCompany(String companyId){
        search.clear();
        search.sendKeys(companyId);

        equitySearch.click();
        return new Summary(driver);

    }
}

