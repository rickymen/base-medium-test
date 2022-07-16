package com.github.ubaifadhli.pages.medium.web;

import com.github.ubaifadhli.pages.medium.WebPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebLoginPage extends WebPageObject {
    private By TWITTER_USERNAME_FIELD = By.id("username_or_email");
    private By TWITTER_PASSWORD_FIELD = By.id("password");
    private By TWITTER_SIGN_IN_BUTTON = By.xpath("//input[@value='Sign In']");
    private By LOGIN_ERROR_TEXT =By.xpath("//span[contains(text(), 'did not match')]");

    public WebLoginPage(WebDriver webDriver) {
        super(webDriver);
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
}
