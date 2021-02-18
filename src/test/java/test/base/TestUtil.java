package test.base;

import com.selenium.driver.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

@Slf4j

public class TestUtil {
    private String url;
    private String browser;
    private int implicitWait;
    public WebDriver driver;

    @BeforeSuite
    public void readConfigProperties() {
        try(FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")){          // Sets the target folder the config file
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("url");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));    // Get the wait Value from the config file
            browser = config.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void initTest(){
        setupBrowserDriver(browser);
        loadUrl();

        acceptCookies();


    }

    public void acceptCookies(){
        List<WebElement> elementList = driver.findElements(By.xpath("//button[@class='btn primary']"));
        if (elementList.size() > 0) {
            WebElement acceptCookies =  driver.findElement(By.xpath("//button[@class='btn primary']"));
            acceptCookies.click();
        }
    }


    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

    public void setupBrowserDriver(String browser){    // Sets up Chrome or Firefox and a potential error for an unsupported browser.
        switch(browser.toLowerCase(Locale.ROOT)){
            case "firefox":
                driver = DriverFactory.getFirefoxDriver(implicitWait);
                break;
            case "chrome":
                driver = DriverFactory.getChromeDriver(implicitWait);
                break;
            default:
                throw new IllegalStateException("This browser is not supported: " + browser);

        }
    }
    public void loadUrl(){
        driver.get(url);
    }
}

