package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="usernamereg-firstName")
    private WebElement firstName;

    @FindBy(id="usernamereg-lastName")
    private WebElement familyName;

    @FindBy(id="usernamereg-yid")
    private WebElement emailAddress;

    @FindBy(id="usernamereg-password")
    private WebElement password;

    @FindBy(id="usernamereg-phone")
    private WebElement phoneNumber;

    @FindBy(id="usernamereg-month")
    private WebElement birthMonth;

    @FindBy(id="usernamereg-day")
    private WebElement birthDay;

    @FindBy(id="usernamereg-year")
    private WebElement birthYear;

    @FindBy(id="reg-submit-button")
    private WebElement continueButton;

    @FindBy(id="reg-error-yid")
    private WebElement realEmailError;

    @FindBy(id="reg-error-password")
    private WebElement realPasswordError;

    @FindBy(id="reg-error-phone")
    private WebElement realPhoneError;

    @FindBy(xpath="//div[contains(@class,'birthdate-error')]")
    private WebElement reallBirthDateError;

    public void setUpSignInData(String firstName, String familyName, String email,    // Sets up the method for login
                                String password, String phoneNumber, String birthMonth,
                                String birthDay, String birthdayYear) {

        this.firstName.clear();                                                     // This is to clear for the second test.
        this.firstName.sendKeys(firstName);

        this.familyName.clear();
        this.familyName.sendKeys(familyName);

        emailAddress.clear();
        emailAddress.sendKeys(email);

        this.password.clear();
        this.password.sendKeys(password);

        this.phoneNumber.clear();
        this.phoneNumber.sendKeys(phoneNumber);

        this.birthMonth.sendKeys(birthMonth);

        this.birthDay.clear();
        this.birthDay.sendKeys(birthDay);

        birthYear.clear();
        birthYear.sendKeys(birthdayYear);
    }

    public void continueButton(){
        continueButton.click();
    }

    public void checkAllErrors(){                   // This method checks all expected errors against the actual ones.
        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(realEmailError));      // Checks for the visibility of the error message through Selenium visibility method.

        softAssert.assertEquals(realEmailError.getText(), SignUpErrors.EXPECTED_EMAIL_ERROR.getErrorMessage(), SignUpErrors.EMAIL_ERROR_MESSAGE.getErrorMessage());

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);    //  Sets the amount of wait time in seconds

        softAssert.assertEquals(realPasswordError.getText(), SignUpErrors.EXPECTED_PASSWORD_ERROR.getErrorMessage(), SignUpErrors.PASSWORD_ERROR_MESSAGE.getErrorMessage());    //Checks if the error messages are correct.
        softAssert.assertEquals(realPhoneError.getText(), SignUpErrors.EXPECTED_PHONE_ERROR.getErrorMessage(), SignUpErrors.PHONE_ERROR_MESSAGE.getErrorMessage());
        softAssert.assertEquals(reallBirthDateError.getText(), SignUpErrors.EXPECTED_BIRTH_DATE_ERROR.getErrorMessage(), SignUpErrors.BIRTH_DATE_ERROR_MESSAGE.getErrorMessage());

        softAssert.assertAll();
    }
}
