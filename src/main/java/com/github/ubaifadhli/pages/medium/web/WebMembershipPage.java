package com.github.ubaifadhli.pages.medium.web;

import com.github.ubaifadhli.pages.medium.WebPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebMembershipPage extends WebPageObject {
    private By MONTHLY_SUBS_TITLE = By.xpath("//h2[contains(text(), 'Monthly')]//following-sibling::p");
    private By ANNUAL_SUBS_TITLE = By.xpath("//h2[contains(text(), 'Annual')]//following-sibling::p");

    public WebMembershipPage(WebDriver webDriver) {
        super(webDriver);
    }

    public double getMonthlySubsPrice() {
        String priceNumber = getElementAfterVisible(MONTHLY_SUBS_TITLE).getText().split(" ")[0].replaceAll("[$,]", "");
        return Double.parseDouble(priceNumber);
    }

    public double getAnnualSubsPrice() {
        String priceNumber = getElementAfterVisible(ANNUAL_SUBS_TITLE).getText().split(" ")[0].replaceAll("[$,]", "");
        return Double.parseDouble(priceNumber);
    }
}
