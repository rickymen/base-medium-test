package com.github.ubaifadhli.pages.medium.mobile;

import com.github.ubaifadhli.pages.medium.MobilePageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class MobileMembershipPage extends MobilePageObject {
    private By MONTHLY_SUBS_TITLE = MobileBy.id("com.medium.reader:id/subs_upgrade_monthly_title");
    private By ANNUAL_SUBS_TITLE = MobileBy.id("com.medium.reader:id/subs_upgrade_yearly_title");

    public MobileMembershipPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
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
