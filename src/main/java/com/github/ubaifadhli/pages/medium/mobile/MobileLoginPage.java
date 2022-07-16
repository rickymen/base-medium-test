package com.github.ubaifadhli.pages.medium.mobile;

import com.github.ubaifadhli.pages.medium.MobilePageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MobileLoginPage extends MobilePageObject {
    private By TWITTER_USERNAME_FIELD = MobileBy.xpath("//android.widget.EditText[@resource-id='username_or_email']");
    private By TWITTER_PASSWORD_FIELD = MobileBy.xpath("//android.widget.EditText[@resource-id='password']");
    private By TWITTER_SIGN_IN_BUTTON = MobileBy.xpath("//android.widget.Button[@resource-id='allow']");
    private By MOBILE_HOME_TITLE = MobileBy.id("com.medium.reader:id/title");

    private By LOGIN_ERROR_TEXT =MobileBy.xpath("//android.widget.TextView[contains(@text, 'did not match')]");


    public MobileLoginPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void fillTwitterLoginCredentials(String email, String password) {
        WebElement twitterUsernameField = getElementAfterVisible(TWITTER_USERNAME_FIELD);
        twitterUsernameField.sendKeys(email);

        WebElement twitterPasswordField = getElementAfterVisible(TWITTER_PASSWORD_FIELD);
        twitterPasswordField.sendKeys(password);

        WebElement twitterSignInButton = getElementAfterClickable(TWITTER_SIGN_IN_BUTTON);
        twitterSignInButton.click();
    }

    public String getLoginErrorText() {
        return getElementAfterVisible(LOGIN_ERROR_TEXT).getText();
    }

    public void waitForHomeTitle() {
        getElementAfterVisible(MOBILE_HOME_TITLE);
    }
}
