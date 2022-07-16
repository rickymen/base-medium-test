package com.github.ubaifadhli.pages.medium.web;

import com.github.ubaifadhli.pages.medium.WebPageObject;
import com.github.ubaifadhli.util.SleepHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebHomePage extends WebPageObject {
    private By SIGN_IN_BUTTON = By.xpath("//a[text()='Sign In']");
    private By SIGN_IN_WITH_TWITTER = By.xpath("//div[text()='Sign in with Twitter']");

    private By SETTINGS_BUTTON = By.xpath("//a[contains(@href, 'settings')]");
    private By LISTS_BUTTON = By.xpath("//a[contains(@href, 'lists')]");
    private By SEARCH_INPUT = By.xpath("//input[@aria-label='search']");
    private By SEARCH_RESULT_TITLE = By.xpath("//a[@aria-label='Post Preview Title']//h2");

    private By HOME_BUTTON = By.xpath("//*[local-name()='svg' and @aria-label='Home']");

    private By HOME_ARTICLE = By.xpath("//a[@aria-label='Post Preview Title']");

    private By PROFILE_BUTTON = By.xpath("//button[@aria-label='user options menu']");
    private By DROPDOWN_PROFILE_BUTTON = By.xpath("//a[contains(@href, '/@') and descendant::img]");

    private By CREATE_NEW_ARTICLE_BUTTON = By.xpath("//a[contains(@href, 'new-story')]");
    private By USER_ARTICLE_TITLE = By.xpath("//a[contains(@href, 'your_stories_page') and parent::h3]");
    private By GET_MEMBERSHIP_BUTTON = By.xpath("(//a[text()='Get unlimited access'])[2]");
    private By FOLLOWING_BUTTON = By.xpath("//a[contains(@href, 'following')]//p");

    public WebHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        getWebDriver().manage().window().maximize();
        getWebDriver().get("https://www.medium.com");

        SleepHelper.sleepForSeconds(1);
    }

    public void goToTwitterLoginPage() {
        WebElement signInButton = getElementAfterClickable(SIGN_IN_BUTTON);
        signInButton.click();

        WebElement signInWithTwitterButton = getElementAfterClickable(SIGN_IN_WITH_TWITTER);
        signInWithTwitterButton.click();
    }

    public void openFollowingPage() {
        SleepHelper.sleepForSeconds(1);

        WebElement profileButton = getElementAfterClickable(PROFILE_BUTTON);
        profileButton.click();

        WebElement followingButton = getElementAfterClickable(FOLLOWING_BUTTON);
        followingButton.click();
    }

    public void backToHomeFromArticleWriter() {
        WebElement homeButton = getElementAfterClickable(HOME_BUTTON);
        homeButton.click();
    }

    public void goToMembershipPage() {
        WebElement getMembershipButton = getElementAfterClickable(GET_MEMBERSHIP_BUTTON);
        getMembershipButton.click();
    }

    public void searchForArticle(String keyword) {
        WebElement searchInput = getElementAfterClickable(SEARCH_INPUT);

        searchInput.click();
        searchInput.sendKeys(keyword);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void goToSettingsPage() {
        WebElement profileButton = getElementAfterClickable(PROFILE_BUTTON);
        profileButton.click();

        WebElement settingsButton = getElementAfterClickable(SETTINGS_BUTTON);
        settingsButton.click();
    }

    public void goToListsPage() {
        WebElement listsButton = getElementAfterClickable(LISTS_BUTTON);
        listsButton.click();

        SleepHelper.sleepForSeconds(1);
    }

    public void goToPublishedArticlePage() {
        WebElement profileButton = getElementAfterClickable(PROFILE_BUTTON);
        profileButton.click();

        WebElement dropdownArticleButton = getElementAfterClickable(DROPDOWN_PROFILE_BUTTON);
        dropdownArticleButton.click();
    }

    public void openFirstUserArticle() {
        goToPublishedArticlePage();

        SleepHelper.sleepForSeconds(1);
    }

    public void createNewArticle() {
        SleepHelper.sleepForSeconds(2);

        WebElement createNewArticleButton = getElementAfterClickable(CREATE_NEW_ARTICLE_BUTTON);
        createNewArticleButton.click();
    }

    public void openFirstHomeArticle() {
        List<WebElement> homeArticles = getElementsAfterVisible(HOME_ARTICLE);
        homeArticles.get(0).click();
    }

    public String getFirstArticleTitle() {
        List<WebElement> searchResultTitles = getElementsAfterVisible(SEARCH_RESULT_TITLE);
        return searchResultTitles.get(0).getText();
    }

    public String getFirstUserArticleTitle() {
        List<WebElement> userArticleTitles = getElementsAfterVisible(USER_ARTICLE_TITLE);
        return userArticleTitles.get(0).getText();
    }
}
