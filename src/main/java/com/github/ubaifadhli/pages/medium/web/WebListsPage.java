package com.github.ubaifadhli.pages.medium.web;

import com.github.ubaifadhli.pages.medium.WebPageObject;
import com.github.ubaifadhli.util.SleepHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebListsPage extends WebPageObject {
    private By CREATE_NEW_LIST_BUTTON = By.xpath("//button[text()='New list']");
    private By NEW_LIST_NAME_FIELD = By.xpath("//input[@placeholder='Give it a name']");
    private By POPUP_CREATE_NEW_LIST_BUTTON = By.xpath("//button[child::span[text()='Create']]");
    private By SECOND_LIST_NAME = By.xpath("(//a/div/div/h2)[2]");
    private By LIST_ARTICLE_COUNT = By.xpath("//a[contains(@href, 'reading-list')]//p");

    private By READING_LIST_BUTTON = By.xpath("//h2[text()='Reading list']");

    public WebListsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void createNewList(String newListName) {
        WebElement createNewListButton = getElementAfterClickable(CREATE_NEW_LIST_BUTTON);
        createNewListButton.click();

        WebElement newListNameField = getElementAfterClickable(NEW_LIST_NAME_FIELD);
        newListNameField.sendKeys(newListName);

        WebElement popupCreateNewListButton = getElementAfterClickable(POPUP_CREATE_NEW_LIST_BUTTON);
        popupCreateNewListButton.click();

        SleepHelper.sleepForSeconds(3);
    }

    public String getSecondListName() {
        WebElement secondListName = getElementAfterVisible(SECOND_LIST_NAME);
        return secondListName.getText();
    }

    public int getReadingListArticleCount() {
        WebElement listArticleCount = getElementAfterVisible(LIST_ARTICLE_COUNT);

        String articleCount = listArticleCount.getText().split(" ")[0];

        return articleCount.equals("Nothing") ? 0 : Integer.parseInt(articleCount);
    }

    public void clickSecondList() {
        WebElement secondListName = getElementAfterClickable(SECOND_LIST_NAME);
        secondListName.click();
    }

    public void clickReadingList() {
        WebElement readingListButton = getElementAfterClickable(READING_LIST_BUTTON);
        readingListButton.click();
    }
}
