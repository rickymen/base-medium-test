package com.github.ubaifadhli.pages.medium.mobile;

import com.github.ubaifadhli.pages.medium.MobilePageObject;
import com.github.ubaifadhli.util.SleepHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MobileProfilePage extends MobilePageObject {
    private By USER_ARTICLE_TITLE = MobileBy.xpath("//android.widget.TextView[@resource-id='com.medium.reader:id/common_item_paragraph_text']");
    private By EDIT_ARTICLE_BUTTON = MobileBy.xpath("//android.widget.TextView[@text='Edit']");
    private By ARTICLE_ELLIPSIS = MobileBy.AccessibilityId("More options");
    private By DELETE_ARTICLE_BUTTON = MobileBy.xpath("//android.widget.TextView[@text='Delete']");
    private By CONFIRM_DELETE_ARTICLE_BUTTON = MobileBy.id("android:id/button1");

    public MobileProfilePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    public void clickUserArticleTitle() {
        WebElement userArticleTitle = getElementAfterClickable(USER_ARTICLE_TITLE);
        userArticleTitle.click();
    }

    public String getFirstUserArticleTitle() {
        WebElement userArticleTitle = getElementAfterVisible(USER_ARTICLE_TITLE);
        return userArticleTitle.getText();
    }

    public void editArticle() {
        WebElement articleEllipsis = getElementAfterClickable(ARTICLE_ELLIPSIS);
        articleEllipsis.click();

        WebElement editArticleButton = getElementAfterClickable(EDIT_ARTICLE_BUTTON);
        editArticleButton.click();

        SleepHelper.sleepForSeconds(2);
    }

    public void deleteArticle() {
        List<WebElement> articleEllipses = getElementsAfterVisible(ARTICLE_ELLIPSIS);
        articleEllipses.get(0).click();

        WebElement deleteArticleButton = getElementAfterClickable(DELETE_ARTICLE_BUTTON);
        deleteArticleButton.click();

        WebElement confirmDeleteArticleButton = getElementAfterClickable(CONFIRM_DELETE_ARTICLE_BUTTON);
        confirmDeleteArticleButton.click();

        SleepHelper.sleepForSeconds(2);
    }
}
