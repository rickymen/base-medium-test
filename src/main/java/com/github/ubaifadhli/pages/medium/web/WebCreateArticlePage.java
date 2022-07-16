package com.github.ubaifadhli.pages.medium.web;

import com.github.ubaifadhli.pages.medium.WebPageObject;
import com.github.ubaifadhli.util.SleepHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebCreateArticlePage extends WebPageObject {
    private By ARTICLE_TEXT_AREA = By.xpath("//h3[contains(@class, 'graf--title')]");
    private By PUBLISH_ARTICLE_BUTTON = By.xpath("//button[@data-action='show-prepublish' or @data-action='republish']");
    private By CONFIRM_PUBLISH_ARTICLE_BUTTON = By.xpath("//button[@data-action='publish']");

    public WebCreateArticlePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillAndPublishArticle(String articleTitle) {
        WebElement articleTextArea = getElementAfterClickable(ARTICLE_TEXT_AREA);

        articleTextArea.click();
        articleTextArea.sendKeys(articleTitle);

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

        SleepHelper.sleepForSeconds(2);

        goToPublishedArticlePage();
    }

    public void goToPublishedArticlePage() {
        getWebDriver().get("https://medium.com/me/stories/public");
    }
}
