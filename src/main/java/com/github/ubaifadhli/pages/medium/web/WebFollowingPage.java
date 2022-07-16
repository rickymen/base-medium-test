package com.github.ubaifadhli.pages.medium.web;

import com.github.ubaifadhli.pages.medium.WebPageObject;
import com.github.ubaifadhli.util.SleepHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class WebFollowingPage extends WebPageObject {
    private By WRITERS_NAME_TEXT = By.xpath("//div[preceding-sibling::h2]//h2");

    private By FOLLOW_BUTTON = By.xpath("//button[text()='Following' and following::h2[contains(text(), 'Publication')]]");
    private By READING_HISTORY_TAB = By.xpath("//a[contains(@href, 'readinghistory')]");
    private By READING_HISTORY_ARTICLE_TEXT = By.xpath("//a/div/h2");

    public WebFollowingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getFollowingWritersName() {
        return getElementsAfterVisible(WRITERS_NAME_TEXT)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickReadingHistoryTab() {
        getElementAfterClickable(READING_HISTORY_TAB).click();
    }

    public String getReadingHistoryArticle() {
        return getElementAfterVisible(READING_HISTORY_ARTICLE_TEXT).getText();
    }

    public void unfollowWriter() {
        WebElement followButton = getElementAfterClickable(FOLLOW_BUTTON);
        followButton.click();

        SleepHelper.sleepForSeconds(1);
    }

    public int getFollowedWritersCount() {
        return getWebDriver().findElements(FOLLOW_BUTTON).size();
    }
}
