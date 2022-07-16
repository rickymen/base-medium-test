package com.github.ubaifadhli.pages.medium.mobile;

import com.github.ubaifadhli.pages.medium.MobilePageObject;
import com.github.ubaifadhli.util.SleepHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MobileSettingsPage extends MobilePageObject {
    private By EDIT_BIO_BUTTON = MobileBy.xpath("(//android.widget.Button)[2]");
    private By EDIT_BIO_FIELD = MobileBy.xpath("//android.widget.EditText[@resource-id='editor_6']");
    private By EDIT_USERNAME_BUTTON = MobileBy.xpath("//android.widget.Button[preceding::android.view.View[@text='Username']]");
    private By EDIT_USERNAME_FIELD = MobileBy.xpath("//android.view.View[@text='Username']/following-sibling::*/android.widget.EditText");
    private By USERNAME_URL_TEXT = MobileBy.xpath("//android.view.View[@text='URL']/following-sibling::*");
    private By SAVE_USERNAME_BUTTON = MobileBy.xpath("//android.widget.Button[@text='Save']");
    private By CONFIRM_SAVE_USERNAME_BUTTON = MobileBy.xpath("//android.widget.Button[contains(@text, 'understand')]");
    private By SAVE_BIO_BUTTON = MobileBy.xpath("//android.widget.Button[@text='Save']");
    private By USER_PUBLIC_PROFILE_LINK = MobileBy.xpath("(//android.view.View[@content-desc='Profile'])[2]/android.widget.TextView");

    private By MOBILE_WEB_VIEW = MobileBy.xpath("//android.webkit.WebView");
    private By USERNAME_ERROR_TEXT = MobileBy.xpath("//android.widget.TextView[@text='Username is not available']");

    public MobileSettingsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void editBio(String bioText) {
        SleepHelper.sleepForSeconds(2);

        WebElement mobileWebView = getElementAfterVisible(MOBILE_WEB_VIEW);
        mobileWebView.click();

        while (!isKeyboardShown()) {
            WebElement editBioButton = getElementAfterClickable(EDIT_BIO_BUTTON);
            editBioButton.click();

            SleepHelper.sleepForSeconds(1);
        }

        WebElement editBioField = getElementAfterVisible(EDIT_BIO_FIELD);
        editBioField.click();
        editBioField.sendKeys(bioText);

        pressBack();

        SleepHelper.sleepForSeconds(2);

        WebElement saveBioButton = getElementAfterClickable(SAVE_BIO_BUTTON);
        saveBioButton.click();

        SleepHelper.sleepForSeconds(2);

        WebElement userPublicProfileLink = getElementAfterClickable(USER_PUBLIC_PROFILE_LINK);
        userPublicProfileLink.click();
    }

    public void editUsername(String newUsername) {
        getElementAfterVisible(MOBILE_WEB_VIEW);

        for (int i = 0; i < 3; i++) {
            swipeUp();
            SleepHelper.sleepForSeconds(1);
        }

        while (!isKeyboardShown()) {
            WebElement editUsernameButton = getElementAfterClickable(EDIT_USERNAME_BUTTON);
            editUsernameButton.click();

            SleepHelper.sleepForSeconds(1);
        }

        WebElement editUsernameField = getElementAfterVisible(EDIT_USERNAME_FIELD);
        editUsernameField.click();
        editUsernameField.sendKeys(newUsername);

        pressKey(AndroidKey.A);

        pressBack();

        SleepHelper.sleepForSeconds(2);
    }

    public void saveUsername() {
        WebElement saveUsernameButton = getElementAfterClickable(SAVE_USERNAME_BUTTON);
        saveUsernameButton.click();

        WebElement confirmSaveUsernameButton = getElementAfterClickable(CONFIRM_SAVE_USERNAME_BUTTON);
        confirmSaveUsernameButton.click();

        SleepHelper.sleepForSeconds(2);
    }

    public String getCurrentUsername() {
        WebElement editUsernameField = getElementAfterVisible(EDIT_USERNAME_FIELD);
        return editUsernameField.getText();
    }

    public String getCurrentProfileURL() {
        WebElement usernameURLText = getElementAfterVisible(USERNAME_URL_TEXT);
        return usernameURLText.getText();
    }

    public String getUsernameErrorText() {
        WebElement usernameErrorText = getElementAfterVisible(USERNAME_ERROR_TEXT);
        return usernameErrorText.getText();
    }
}
