package com.github.ubaifadhli.pages.medium.mobile;

import com.github.ubaifadhli.pages.medium.MobilePageObject;
import com.github.ubaifadhli.util.SleepHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MobileListDetailPage extends MobilePageObject {
    private By LIST_ELLIPSIS = MobileBy.AccessibilityId("More options");

    private By DELETE_LIST_BUTTON = MobileBy.xpath("//android.widget.TextView[@text='Delete list']");
    private By CONFIRM_DELETE_LIST_BUTTON = MobileBy.id("com.medium.reader:id/btn_delete");
    private By LIST_ARTICLE_ELLIPSIS = MobileBy.id("com.medium.reader:id/post_preview_overflow_menu_button");
    private By REMOVE_ITEM_FROM_LIST_BUTTON = MobileBy.xpath("//android.widget.TextView[@text='Remove from list']");


    public MobileListDetailPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void deleteList() {
        WebElement listEllipsis = getElementAfterClickable(LIST_ELLIPSIS);
        listEllipsis.click();

        WebElement deleteListButton = getElementAfterClickable(DELETE_LIST_BUTTON);
        deleteListButton.click();

        WebElement confirmDeleteListButton = getElementAfterClickable(CONFIRM_DELETE_LIST_BUTTON);
        confirmDeleteListButton.click();

        SleepHelper.sleepForSeconds(2);

        refreshPage();
        SleepHelper.sleepForSeconds(1);
    }

    public void removeFirstArticleFromList() {
        WebElement listArticleEllipsis = getElementAfterClickable(LIST_ARTICLE_ELLIPSIS);
        listArticleEllipsis.click();

        WebElement removeItemFromListButton = getElementAfterClickable(REMOVE_ITEM_FROM_LIST_BUTTON);
        removeItemFromListButton.click();

        pressBack();
    }
}
