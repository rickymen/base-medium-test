package com.github.ubaifadhli.pages.medium.web;

import com.github.ubaifadhli.pages.medium.WebPageObject;
import com.github.ubaifadhli.util.SleepHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebSettingsPage extends WebPageObject {
    private By EDIT_BIO_BUTTON = By.xpath("//button[@data-action='edit-bio']");
    private By EDIT_BIO_FIELD = By.xpath("//p[contains(@class, 'graf--p')]");
    private By SAVE_BIO_BUTTON = By.xpath("//button[@data-action='save-bio']");
    private By EDIT_USERNAME_BUTTON = By.xpath("//button[@data-action='edit-username']");
    private By EDIT_USERNAME_FIELD = By.xpath("//input[contains(@class, 'usernameInput')]");
    private By USERNAME_URL_TEXT = By.xpath("//td[contains(@class, 'profileUrl')]");
    private By SAVE_USERNAME_BUTTON = By.xpath("//button[contains(@class, 'saveUsername')]");
    private By CONFIRM_SAVE_USERNAME_BUTTON = By.xpath("//button[@data-action='overlay-confirm']");
    private By USER_PUBLIC_PROFILE_LINK = By.xpath("//p[@data-default-value='Add your short bio']//following-sibling::div/a");
    private By USERNAME_ERROR_TEXT = By.xpath("//p[contains(@class, 'usernameSettingsItem')]");

    public WebSettingsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void editBio(String bioText) {
        WebElement editBioButton = getElementAfterClickable(EDIT_BIO_BUTTON);
        editBioButton.click();

        WebElement editBioField = getElementAfterVisible(EDIT_BIO_FIELD);
        editBioField.clear();
        editBioField.sendKeys(bioText);

        SleepHelper.sleepForSeconds(2);

        WebElement saveBioButton = getElementAfterClickable(SAVE_BIO_BUTTON);
        saveBioButton.click();

        SleepHelper.sleepForSeconds(2);

        WebElement userPublicProfileLink = getElementAfterClickable(USER_PUBLIC_PROFILE_LINK);
        userPublicProfileLink.click();
    }

    public void editUsername(String newUsername) {
        WebElement editUsernameButton = getElementAfterClickable(EDIT_USERNAME_BUTTON);
        editUsernameButton.click();

        WebElement editUsernameField = getElementAfterVisible(EDIT_USERNAME_FIELD);
        editUsernameField.click();
        editUsernameField.clear();
        editUsernameField.sendKeys(newUsername);

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
        return editUsernameField.getAttribute("value");
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
