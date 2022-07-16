package com.github.ubaifadhli.pages.medium.mobile;

import com.github.ubaifadhli.pages.medium.MobilePageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MobileUserPublicProfilePage extends MobilePageObject {
    private By USER_BIO = MobileBy.id("com.medium.reader:id/tvBio");
    private By ABOUT_SECTION = MobileBy.AccessibilityId("About");

    public MobileUserPublicProfilePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public String getUserBio() {
        WebElement aboutSection = getElementAfterClickable(ABOUT_SECTION);
        aboutSection.click();

        WebElement userBio = getElementAfterVisible(USER_BIO);
        return userBio.getText();
    }
}
