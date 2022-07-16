package com.github.ubaifadhli.pages.medium.web;

import com.github.ubaifadhli.pages.medium.WebPageObject;
import com.github.ubaifadhli.util.SleepHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebProfilePage extends WebPageObject {
    private By USER_ARTICLE_TITLE = By.xpath("//article//h1/a");
    private By EDIT_ARTICLE_BUTTON = By.xpath("//a[contains(@href, 'edit')]");
    private By ARTICLE_ELLIPSIS = By.xpath("//button[@aria-controls='creatorActionOverflowMenu' or @aria-controls='yourStoryActionsMenu']");
    private By DELETE_ARTICLE_BUTTON = By.xpath("//div[@id='yourStoryActionsMenu']//button");
    private By CONFIRM_DELETE_ARTICLE_BUTTON = By.xpath("//button[text()='Delete']");

    public WebProfilePage(WebDriver webDriver) {
        super(webDriver);
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
