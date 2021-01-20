package util;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ThreadLocalRandom;


public class DriverCreation {

    private static WebDriver _driver;

    public static WebDriver getDriver() {
        return _driver;
    }

    public String createRandomString() {
        int randomNum = ThreadLocalRandom.current().nextInt(5, 15 + 1);

        String random = RandomStringUtils.randomAlphabetic(randomNum);

        return random;
    }

    public void openUrl(String url) {
        _driver.get(url);
    }


    private void createChromeDriver() {

        System.setProperty("webdriver.chrome.driver", "/Users/milicbogicevic/Downloads/ProgramDownloads/ChromeDriver/chromedriver");
        _driver = new ChromeDriver();


    }


    @Rule
    public TestWatcher watchman = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            createChromeDriver();
        }

        @Override
        protected void failed(Throwable e, Description description) {
        }

        @Override
        protected void succeeded(Description description) {
        }

        @Override
        protected void finished(Description description) {
            _driver.quit();
        }
    };

}
