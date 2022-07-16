package com.github.ubaifadhli.pages.medium.mobile;

import com.github.ubaifadhli.pages.medium.MobilePageObject;
import com.github.ubaifadhli.util.SleepHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MobileCreateArticlePage extends MobilePageObject {

    private By ARTICLE_TEXT_AREA = MobileBy.id("com.medium.reader:id/common_edit_post_paragraph_text");
    private By PUBLISH_ARTICLE_BUTTON = MobileBy.id("com.medium.reader:id/publish_button");
    private By CONFIRM_PUBLISH_ARTICLE_BUTTON = MobileBy.id("com.medium.reader:id/edit_post_add_tags_dialog_publish");
    private By TITLE_TOOLBAR = MobileBy.id("com.medium.reader:id/edit_post_toolbar_title");

    public MobileCreateArticlePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void fillAndPublishArticle(String articleTitle) {
        WebElement articleTextArea = getElementAfterClickable(ARTICLE_TEXT_AREA);

        articleTextArea.click();
        articleTextArea.sendKeys(articleTitle);

        WebElement titleToolbar = getElementAfterClickable(TITLE_TOOLBAR);
        titleToolbar.click();

        WebElement publishArticleButton = getElementAfterClickable(PUBLISH_ARTICLE_BUTTON);
        publishArticleButton.click();

        WebElement confirmPublishArticleButton = getElementAfterClickable(CONFIRM_PUBLISH_ARTICLE_BUTTON);
        confirmPublishArticleButton.click();
        SleepHelper.sleepForSeconds(2);
    }

    public void fillAndRepublishArticle(String articleTitle) {
        WebElement articleTextArea = getElementAfterClickable(ARTICLE_TEXT_AREA);

        articleTextArea.click();
        articleTextArea.clear();
        articleTextArea.sendKeys(articleTitle);

        WebElement publishArticleButton = getElementAfterClickable(PUBLISH_ARTICLE_BUTTON);
        publishArticleButton.click();

        SleepHelper.sleepForSeconds(4);
    }
}
