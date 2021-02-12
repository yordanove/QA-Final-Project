package com.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

@Slf4j
public class Statistics extends BasePage{
    public Statistics(WebDriver driver) {
        super(driver);
    }

    private static final String PRICE_BOOK_ERROR_MESSAGE ="Current Price/Book doesn't match expected Price/Book value.";   // No need for a whole file with error messages.


    @FindBy(xpath = "//span[text()='Price/Book']//ancestor::tr/td[2]")  // Find Current Price book by two Xpaths.
    private WebElement currentPriceBook;

    public void checkPriceBook(String priceBook){   // Displays the current Book Price.
        log.info("Current value for Price/Book (mrq): " + priceBook);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(currentPriceBook.getText(), priceBook, PRICE_BOOK_ERROR_MESSAGE);
        softAssert.assertAll();
    }
}
