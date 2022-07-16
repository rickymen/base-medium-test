package com.github.ubaifadhli.pages.medium.mobile;

import com.github.ubaifadhli.pages.medium.MobilePageObject;
import com.github.ubaifadhli.util.SleepHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class MobileHomePage extends MobilePageObject {

    private By SIGN_IN_BUTTON = MobileBy.id("com.medium.reader:id/sign_in_prompt");
    private By SIGN_IN_WITH_TWITTER_BUTTON = MobileBy.id("com.medium.reader:id/sign_in_twitter_button");

    private By SETTINGS_BUTTON = MobileBy.xpath("//android.widget.TextView[contains(@text, 'Settings')]");
    private By LISTS_BUTTON = MobileBy.AccessibilityId("Reading List");
    private By ACCOUNT_BUTTON = MobileBy.id("com.medium.reader:id/item_account");

    private By HOME_BUTTON = MobileBy.AccessibilityId("Home");
    private By HOME_ARTICLES = MobileBy.xpath("//android.widget.TextView[@resource-id='com.medium.reader:id/post_preview_title' and count(following-sibling::*)=6 and following-sibling::*[@content-desc='Unsave']]");

    private By SEARCH_BUTTON = MobileBy.AccessibilityId("Discover something new");
    private By SEARCH_INPUT = MobileBy.id("com.medium.reader:id/search_input");
    private By SEARCH_RESULT_TITLE = MobileBy.xpath("//android.widget.TextView[@resource-id='com.medium.reader:id/post_preview_title']");

    private By PROFILE_BUTTON = MobileBy.id("com.medium.reader:id/image");
    private By CREATE_NEW_ARTICLE_BUTTON = MobileBy.AccessibilityId("Write a story");
    private By USER_ARTICLE_TITLE = MobileBy.xpath("//android.widget.TextView[@resource-id='com.medium.reader:id/common_item_paragraph_text']");

    private By PROFILE_ELLIPSIS = MobileBy.xpath("//android.widget.FrameLayout[@resource-id='com.medium.reader:id/you_tab_header_settings']/android.widget.ImageView");

    private By GET_MEMBERSHIP_BUTTON = MobileBy.id("com.medium.reader:id/item_become_a_member");
    private By FOLLOWING_BUTTON = MobileBy.id("com.medium.reader:id/creator_groupie_header_following_count");

    public MobileHomePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void goToTwitterLoginPage() {
        WebElement signInButton = getElementAfterClickable(SIGN_IN_BUTTON);
        signInButton.click();

        WebElement signInWithTwitterButton = getElementAfterClickable(SIGN_IN_WITH_TWITTER_BUTTON);
        signInWithTwitterButton.click();
    }

    public void searchForArticle(String keyword) {
        WebElement searchButton = getElementAfterClickable(SEARCH_BUTTON);
        searchButton.click();

        WebElement searchInput = getElementAfterClickable(SEARCH_INPUT);
        searchInput.click();

        // Need to find the element again because the DOM changes.
        searchInput = getElementAfterVisible(SEARCH_INPUT);
        searchInput.sendKeys(keyword);

        pressEnter();
    }

    public void openFollowingPage() {
        SleepHelper.sleepForSeconds(1);

        WebElement profileButton = getElementAfterClickable(PROFILE_BUTTON);
        profileButton.click();

        WebElement followingButton = getElementAfterClickable(FOLLOWING_BUTTON);
        followingButton.click();
    }

    public void backToHomeFromArticleWriter() {
        pressBack();
        SleepHelper.sleepForSeconds(1);
        pressBack();
    }

    public void goToMembershipPage() {
        WebElement settingsButton = getElementAfterClickable(SETTINGS_BUTTON);
        settingsButton.click();

        WebElement getMembershipButton = getElementAfterClickable(GET_MEMBERSHIP_BUTTON);
        getMembershipButton.click();
    }

    public void goToSettingsPage() {
        WebElement profileButton = getElementAfterClickable(PROFILE_BUTTON);
        profileButton.click();

        WebElement profileEllipsis = getElementAfterClickable(PROFILE_ELLIPSIS);
        profileEllipsis.click();

        WebElement settingsButton = getElementAfterClickable(SETTINGS_BUTTON);
        settingsButton.click();
    }

    public void goToAccountSettingsPage() {
        WebElement accountButton = getElementAfterClickable(ACCOUNT_BUTTON);
        accountButton.click();
    }

    public void goToListsPage() {
        WebElement profileButton = getElementAfterClickable(PROFILE_BUTTON);
        profileButton.click();

        SleepHelper.sleepForSeconds(1);

        WebElement listsButton = getElementAfterClickable(LISTS_BUTTON);
        listsButton.click();
    }

    public void openFirstUserArticle() {
        WebElement profileButton = getElementAfterClickable(PROFILE_BUTTON);
        profileButton.click();

        List<WebElement> userArticleTitles = getElementsAfterVisible(USER_ARTICLE_TITLE);
        userArticleTitles.get(0).click();

        SleepHelper.sleepForSeconds(1);
    }

    public void createNewArticle() {
        WebElement profileButton = getElementAfterClickable(PROFILE_BUTTON);
        profileButton.click();

        WebElement createNewArticleButton = getElementAfterClickable(CREATE_NEW_ARTICLE_BUTTON);
        createNewArticleButton.click();

        SleepHelper.sleepForSeconds(2);
    }

    public String getFirstArticleTitle() {
        List<WebElement> searchResultTitles = getElementsAfterVisible(SEARCH_RESULT_TITLE);
        return searchResultTitles.get(0).getText();
    }

    public String getFirstUserArticleTitle() {
        List<WebElement> userArticleTitles = getElementsAfterVisible(USER_ARTICLE_TITLE);
        return userArticleTitles.get(0).getText();
    }

    public void openFirstHomeArticle() {
        WebElement homeButton = getElementAfterClickable(HOME_BUTTON);
        homeButton.click();

        List<WebElement> userArticleTitles = getElementsAfterVisible(HOME_ARTICLES);
        userArticleTitles.get(0).click();
    }

    public void goToPublishedArticlePage() {
        WebElement profileButton = getElementAfterClickable(PROFILE_BUTTON);
        profileButton.click();
    }
}
