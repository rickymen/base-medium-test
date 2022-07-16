package com.github.ubaifadhli.pages.medium.web;

import com.github.ubaifadhli.pages.medium.WebPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebWriterPage extends WebPageObject {
    private By FOLLOW_BUTTON = By.xpath("(//button[text()='Follow'])[2]");
    private By WRITER_NAME_TEXT = By.xpath("//h2[contains(@class, 'pw-author-name')]");

    public WebWriterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void followWriter() {
        WebElement followButton = getElementAfterClickable(FOLLOW_BUTTON);
        followButton.click();
    }

    public String getWriterName() {
        WebElement writerNameText = getElementAfterVisible(WRITER_NAME_TEXT);
        return writerNameText.getText();
    }
}
