import com.github.ubaifadhli.pages.medium.mobile.*;
import com.github.ubaifadhli.pages.medium.web.*;
import com.github.ubaifadhli.util.*;
import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestRunner {
    private WebHomePage webHomePage;
    private WebLoginPage webLoginPage;

    private MobileHomePage mobileHomePage;
    private MobileLoginPage mobileLoginPage;

    @DataProvider(name = "drivers", parallel = true)
    public Object[][] getDataProvider() {
        return new Object[][]{
                new Object[]{"WEB", DriverFactory.createWebDriver(DriverManagerType.CHROME)},
                new Object[]{"MOBILE", DriverFactory.createMobileDriver()},
        };
    }

    public boolean isCurrentPlatformWeb(String platform) {
        return platform.equals("WEB");
    }

    public boolean isCurrentPlatformMobile(String platform) {
        return platform.equals("MOBILE");
    }

    public String getPropertyByPlatform(String propertyName, String platform) {
        PropertiesReader reader = new PropertiesReader("application.properties");

        return reader.getPropertyAsString(platform.toLowerCase() + "." + propertyName);
    }

    @Test(dataProvider = "drivers")
    public void login(String platform, RemoteWebDriver platformDriver) {
        String username = getPropertyByPlatform("login.twitter.username", platform);
        String password = getPropertyByPlatform("login.twitter.password", platform);

        if (isCurrentPlatformWeb(platform)) {
            webHomePage = new WebHomePage(platformDriver);
            webLoginPage = new WebLoginPage(platformDriver);

            webHomePage.openPage();
            webHomePage.goToTwitterLoginPage();

            webLoginPage.fillTwitterLoginCredentials(username, password);
        }

        if (isCurrentPlatformMobile(platform)) {
            mobileHomePage = new MobileHomePage((AppiumDriver) platformDriver);
            mobileLoginPage = new MobileLoginPage((AppiumDriver) platformDriver);

            mobileHomePage.goToTwitterLoginPage();

            mobileLoginPage.fillTwitterLoginCredentials(username, password);
            mobileLoginPage.waitForHomeTitle();
        }
    }

    @Test(dataProvider = "drivers")
    public void ut(String platform, RemoteWebDriver platformDriver) {
        String username = getPropertyByPlatform("login.twitter.username", platform);
        String password = getPropertyByPlatform("login.twitter.password", platform);
        String searchTitle = "sprint boot";
        String expectedTitle = "How to scale Microservices with Message Queues, Spring Boot, and Kubernetes";
        String actualTitle = "";
        //        Given user has logged into Medium application
//        When user searches for ‘spring boot’
//        Then user should see ‘How to scale Microservices with Message Queues, Spring Boot, and Kubernetes’ as the first article
        if (isCurrentPlatformWeb(platform)) {
            webHomePage = new WebHomePage(platformDriver);
            webLoginPage = new WebLoginPage(platformDriver);

            webHomePage.openPage();
            webHomePage.goToTwitterLoginPage();

            webLoginPage.fillTwitterLoginCredentials(username, password);

            webHomePage.searchForArticle(searchTitle);
            actualTitle = webHomePage.getFirstArticleTitle();
        }

        if (isCurrentPlatformMobile(platform)) {
            mobileHomePage = new MobileHomePage((AppiumDriver) platformDriver);
            mobileLoginPage = new MobileLoginPage((AppiumDriver) platformDriver);

            mobileHomePage.goToTwitterLoginPage();

            mobileLoginPage.fillTwitterLoginCredentials(username, password);
            mobileLoginPage.waitForHomeTitle();

            mobileHomePage.searchForArticle(searchTitle);
            actualTitle = mobileHomePage.getFirstArticleTitle();
        }
        assertThat(actualTitle, equalTo(expectedTitle));
    }
}
