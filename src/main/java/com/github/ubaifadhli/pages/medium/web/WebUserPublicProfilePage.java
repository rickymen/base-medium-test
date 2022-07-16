package com.github.ubaifadhli.pages.medium.web;

import com.github.ubaifadhli.pages.medium.WebPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebUserPublicProfilePage extends WebPageObject {
    private By USER_BIO = By.xpath("//h2/parent::a/following-sibling::p");

    public WebUserPublicProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getUserBio() {
        WebElement userBio = getElementAfterVisible(USER_BIO);
        return userBio.getText();
    }
}
