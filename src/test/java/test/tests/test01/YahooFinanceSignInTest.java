package test.tests.test01;

import com.opencsv.exceptions.CsvException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.selenium.pages.SignInYahooFinance;
import com.selenium.pages.SignUpPage;
import com.selenium.pages.YahooFinanceHome;
import test.base.TestUtil;
import com.selenium.utils.CsvReader;

import java.io.IOException;

public class YahooFinanceSignInTest extends TestUtil {

    @BeforeTest
    public void signUpBeforeTest(){
        YahooFinanceHome loadYahooFinanceHome = new YahooFinanceHome(driver);
        loadYahooFinanceHome.executeSignInButton();
        SignInYahooFinance signInYahooFinance = new SignInYahooFinance(driver);
        signInYahooFinance.executeCreateAnAccountButton();
    }

    @DataProvider(name = "signin-data")
    public static Object[][] dataProviderData() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/signin-data.csv");
    }

    @Test(dataProvider = "signin-data")
    public void executeTestSignUpYahooFinance(String name, String familyName, String mail,
                                               String pass, String phoneNumber, String bMonth,
                                               String bDay, String bYear){
        SignUpPage signUp = new SignUpPage(driver);                   // Create new object of class SignUpPage
        signUp.setUpSignInData(name, familyName, mail,                // Get method from page in main
                pass, phoneNumber, bMonth,
                bDay, bYear);

        signUp.continueButton();

        signUp.checkAllErrors();
    }
}
