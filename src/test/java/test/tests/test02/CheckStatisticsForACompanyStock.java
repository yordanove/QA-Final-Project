package test.tests.test02;

import com.opencsv.exceptions.CsvException;
import test.base.TestUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.selenium.pages.Summary;
import com.selenium.pages.Statistics;
import com.selenium.pages.YahooFinanceHome;
import com.selenium.utils.CsvReader;

import java.io.IOException;

public class CheckStatisticsForACompanyStock extends TestUtil {

    @DataProvider(name = "company-data")
    public static Object[][] dataProviderData() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/stats-data.csv");
    }

    @Test(dataProvider = "company-data")
    public void companyDividendsTest(String company, String dividend, String currentPriceBook) {

        YahooFinanceHome yahooHome = new YahooFinanceHome(driver);
        yahooHome.searchCompany(company);

        Summary summary = new Summary(driver);
        Summary.checkCompanyDividends(dividend);
        Summary.goToStatisticsTab();

        Statistics statistics = new Statistics(driver);
        statistics.checkPriceBook(currentPriceBook);

    }


}
