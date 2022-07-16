package com.github.ubaifadhli.pages.medium.mobile;

import com.github.ubaifadhli.pages.medium.MobilePageObject;
import com.github.ubaifadhli.util.SleepHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MobileArticlePage extends MobilePageObject {
    private By COMMENT_BUTTON = MobileBy.AccessibilityId("Read responses");
    private By COMMENT_FIELD = MobileBy.id("com.medium.reader:id/response_editor");
    private By PUBLISH_COMMENT_BUTTON = MobileBy.AccessibilityId("Publish response");
    private By ARTICLE_COMMENTS = MobileBy.id("com.medium.reader:id/response_text");
    private By ADD_TO_BOOKMARK_BUTTON = MobileBy.xpath("//android.widget.ImageView[@content-desc='Save']");
    private By CONFIRM_ADD_TO_BOOKMARK_BUTTON = MobileBy.id("com.medium.reader:id/btn_save_to");
    private By WRITER_PROFILE = MobileBy.AccessibilityId("View Author Profile");
    private By COMMENT_ELLIPSIS_BUTTON = MobileBy.id("com.medium.reader:id/overflow_menu");
    private By DELETE_COMMENT_BUTTON = MobileBy.xpath("//android.widget.TextView[@text='Delete']");
    private By REPLY_COMMENT_BUTTON = MobileBy.id("com.medium.reader:id/reply_button");

    public MobileArticlePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public int getReplyCommentCount() {
        return getMobileDriver().findElements(REPLY_COMMENT_BUTTON).size();
    }

    public void deleteComment() {
        WebElement commentEllipsisButton = getElementAfterClickable(COMMENT_ELLIPSIS_BUTTON);
        commentEllipsisButton.click();

        WebElement deleteCommentButton = getElementAfterClickable(DELETE_COMMENT_BUTTON);
        deleteCommentButton.click();

        SleepHelper.sleepForSeconds(2);
    }

    public void createComment(String commentText) {
        WebElement commentButton = getElementAfterClickable(COMMENT_BUTTON);
        commentButton.click();

        WebElement commentField = getElementAfterClickable(COMMENT_FIELD);
        commentField.click();
        commentField.sendKeys(commentText);

        WebElement publishCommentButton = getElementAfterClickable(PUBLISH_COMMENT_BUTTON);
        publishCommentButton.click();

        SleepHelper.sleepForSeconds(2);
    }

    public void clickAddToBookmarkButton() {
        WebElement addToBookmarkButton = getElementAfterClickable(ADD_TO_BOOKMARK_BUTTON);
        addToBookmarkButton.click();

        SleepHelper.sleepForSeconds(2);

        WebElement confirmAddToBookmarkButton = getElementAfterClickable(CONFIRM_ADD_TO_BOOKMARK_BUTTON);
        confirmAddToBookmarkButton.click();

        pressBack();
    }

    public String getFirstCommentText() {
        List<WebElement> articleComments = getElementsAfterVisible(ARTICLE_COMMENTS);
        return articleComments.get(0).getText();
    }

    public void goToWriterProfile() {
        WebElement writerProfile = getElementAfterClickable(WRITER_PROFILE);
        writerProfile.click();
    }
}
