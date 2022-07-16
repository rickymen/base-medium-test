package com.github.ubaifadhli.pages.medium.web;

import com.github.ubaifadhli.pages.medium.WebPageObject;
import com.github.ubaifadhli.util.SleepHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebListDetailPage extends WebPageObject {
    private By LIST_ELLIPSIS = By.xpath("//button[@aria-label='More options']");
    private By DELETE_LIST_BUTTON = By.xpath("//p[text()='Delete list']");
    private By CONFIRM_DELETE_LIST_BUTTON = By.xpath("//span[text()='Delete']");
    private By LIST_ARTICLE_ELLIPSIS = By.xpath("//button[contains(@aria-label, 'List item menu')]");
    private By REMOVE_ITEM_FROM_LIST_BUTTON = By.xpath("//button[text()='Remove item']");

    public WebListDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void deleteList() {
        WebElement listEllipsis = getElementAfterClickable(LIST_ELLIPSIS);
        listEllipsis.click();

        WebElement deleteListButton = getElementAfterClickable(DELETE_LIST_BUTTON);
        deleteListButton.click();

        WebElement confirmDeleteListButton = getElementAfterClickable(CONFIRM_DELETE_LIST_BUTTON);
        confirmDeleteListButton.click();

        SleepHelper.sleepForSeconds(2);
    }

    public void removeFirstArticleFromList() {
        WebElement listArticleEllipsis = getElementAfterClickable(LIST_ARTICLE_ELLIPSIS);
        listArticleEllipsis.click();

        WebElement removeItemFromListButton = getElementAfterClickable(REMOVE_ITEM_FROM_LIST_BUTTON);
        removeItemFromListButton.click();
    }
}
