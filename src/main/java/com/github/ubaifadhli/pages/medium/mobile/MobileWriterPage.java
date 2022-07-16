package com.github.ubaifadhli.pages.medium.mobile;

import com.github.ubaifadhli.pages.medium.MobilePageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MobileWriterPage extends MobilePageObject {
    private By FOLLOW_BUTTON = MobileBy.id("com.medium.reader:id/btnFollow");

    private By WRITER_NAME_TEXT = MobileBy.id("com.medium.reader:id/tvUserName");

    public MobileWriterPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void followWriter() {
        WebElement followButton = getElementAfterClickable(FOLLOW_BUTTON);
        followButton.click();
    }

    public String getWriterName() {
        WebElement writerNameText = getElementAfterVisible(WRITER_NAME_TEXT);
        return writerNameText.getText();
    }
}
