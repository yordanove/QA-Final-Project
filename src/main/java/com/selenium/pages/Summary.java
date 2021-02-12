package com.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

@Slf4j
public class Summary extends BasePage{
    private static final String DIVIDEND_ERROR_MESSAGE =  "Dividend actual result doesn't match the expected dividend value";

    public Summary(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")      // Finds element of Forward Dividend and Yield.
    private static WebElement forwardDividendAndYield;

    @FindBy(xpath = "//span[text()='Statistics']")                      // Finds element for the Statistics page.
    private static WebElement statistics;

    public static void checkCompanyDividends(String dividend){
        log.info("Company dividend: " + forwardDividendAndYield.getText());  // Get the text from the WebElement
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(forwardDividendAndYield.getText(), dividend, DIVIDEND_ERROR_MESSAGE);
        softAssert.assertAll();
    }

    public static Statistics goToStatisticsTab(){                           // Method to go to the Statistics Page
        statistics.click();

        return new Statistics(driver);

    }
}
