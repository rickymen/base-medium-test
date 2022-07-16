package com.github.ubaifadhli.pages.medium.mobile;

import com.github.ubaifadhli.pages.medium.MobilePageObject;
import com.github.ubaifadhli.util.SleepHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class MobileFollowingPage extends MobilePageObject {
    private By WRITERS_NAME_TEXT = MobileBy.id("com.medium.reader:id/creator_name");

    private By FOLLOW_BUTTON = MobileBy.id("com.medium.reader:id/follow_button");

    public MobileFollowingPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public List<String> getFollowingWritersName() {
        return getElementsAfterVisible(WRITERS_NAME_TEXT)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void unfollowWriter() {
        WebElement followButton = getElementAfterClickable(FOLLOW_BUTTON);
        followButton.click();

        pressBack();

        SleepHelper.sleepForSeconds(1);
    }

    public int getFollowedWritersCount() {
        return getMobileDriver().findElements(FOLLOW_BUTTON).size();
    }
}
