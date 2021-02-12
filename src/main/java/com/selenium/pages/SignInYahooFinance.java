package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInYahooFinance extends BasePage{
    public SignInYahooFinance(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[contains(@class,'sign-up-link')]")
    private WebElement createAccount;

    public SignUpPage pressCreateAnAccount(){
        createAccount.click();
        return new SignUpPage(driver);
    }
}
