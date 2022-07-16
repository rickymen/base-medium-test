package com.github.ubaifadhli.pages.medium.web;

import com.github.ubaifadhli.pages.medium.WebPageObject;
import com.github.ubaifadhli.util.SleepHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebArticlePage extends WebPageObject {
    private By COMMENT_BUTTON = By.xpath("(//button[@aria-label='responses'])[2]");
    private By COMMENT_FIELD = By.xpath("//div[@role='textbox']");
    private By PUBLISH_COMMENT_BUTTON = By.xpath("//button[text()='Respond']");
    private By ARTICLE_COMMENTS = By.xpath("(//pre/div/div/div)[last()]");
    private By ADD_TO_BOOKMARK_BUTTON = By.xpath("//button[child::*[local-name()='svg' ] and @aria-label='Add to list bookmark button']");
    private By WRITER_PROFILE = By.xpath("//h2[contains(@class, 'pw-author-name')]");
    private By COMMENT_ELLIPSIS_BUTTON = By.xpath("(//button[child::*[name()='svg' and contains(@class, 'overflow')]])[2]");
    private By DELETE_COMMENT_BUTTON = By.xpath("//button[text()='Delete']");
    private By REPLY_COMMENT_BUTTON = By.xpath("//p[child::button[text()='Reply']]");
    private By CONFIRM_DELETE_COMMENT_BUTTON = By.xpath("//button[text()='Delete Response']");

    public WebArticlePage(WebDriver webDriver) {
        super(webDriver);
    }

    public int getReplyCommentCount() {
        return getWebDriver().findElements(REPLY_COMMENT_BUTTON).size();
    }

    public void deleteComment() {
        WebElement commentEllipsisButton = getElementAfterClickable(COMMENT_ELLIPSIS_BUTTON);
        commentEllipsisButton.click();

        WebElement deleteCommentButton = getElementAfterClickable(DELETE_COMMENT_BUTTON);
        deleteCommentButton.click();

        WebElement confirmDeleteCommentButton = getElementAfterClickable(CONFIRM_DELETE_COMMENT_BUTTON);
        confirmDeleteCommentButton.click();

        SleepHelper.sleepForSeconds(2);

        getWebDriver().navigate().refresh();

        WebElement commentButton = getElementAfterClickable(COMMENT_BUTTON);
        commentButton.click();

        SleepHelper.sleepForSeconds(1);
    }

    public void createComment(String commentText) {
        WebElement commentButton = getElementAfterClickable(COMMENT_BUTTON);
        commentButton.click();

        WebElement commentField = getElementAfterClickable(COMMENT_FIELD);
        commentField.click();
        commentField.sendKeys(commentText);

        getElementAfterClickable(PUBLISH_COMMENT_BUTTON);

        WebElement publishCommentButton = getElementAfterClickable(PUBLISH_COMMENT_BUTTON);
        publishCommentButton.click();

        SleepHelper.sleepForSeconds(2);
    }

    public String getFirstCommentText() {
        List<WebElement> articleComments = getElementsAfterVisible(ARTICLE_COMMENTS);
        return articleComments.get(0).getText();
    }

    public void clickAddToBookmarkButton() {
        WebElement addToBookmarkButton = getElementAfterClickable(ADD_TO_BOOKMARK_BUTTON);
        addToBookmarkButton.click();

        SleepHelper.sleepForSeconds(1);

        getWebDriver().navigate().back();
        WebElement commentButton = getElementAfterClickable(COMMENT_BUTTON);
        commentButton.click();
    }

    public void goToWriterProfile() {
        WebElement writerProfile = getElementAfterClickable(WRITER_PROFILE);
        writerProfile.click();
    }
}
