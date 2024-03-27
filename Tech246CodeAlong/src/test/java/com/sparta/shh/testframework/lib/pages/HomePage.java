package com.sparta.shh.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page
{

    private By pastLink = new By.ByLinkText("past");
    private By commentsLink = new By.ByLinkText("comments");
    private By jobsLink = new By.ByLinkText("jobs");
    private By askLink = new By.ByLinkText("ask");
    private By showLink = new By.ByLinkText("show");

    private By searchField = new By.ByName("q");

    public HomePage(WebDriver webDriver)
    {
        super(webDriver);
        if (!webDriver.getTitle().equals("Hacker News"))
        {
            throw new IllegalStateException("This is not the home page," +
                    "current page is " + webDriver.getCurrentUrl());
        }

        this.webDriver = webDriver;
    }

    public PastPage goToPastPage()
    {
        webDriver.findElement(pastLink).click();
        return new PastPage(webDriver);
    }
    public CommentsPage goToCommentsPage()
    {
        webDriver.findElement(commentsLink).click();
        return new CommentsPage(webDriver);
    }
    public JobPage goToJobsPage()
    {
        webDriver.findElement(jobsLink).click();
        return new JobPage(webDriver);
    }
    public SearchPage search(String value)
    {
        webDriver.findElement(searchField).sendKeys(value, Keys.ENTER);
        return new SearchPage(webDriver);
    }
    public AskPage goToAskPage()
    {
        webDriver.findElement(askLink).click();
        return new AskPage(webDriver);
    }
    public ShowPage goToShowPage()
    {
        webDriver.findElement(showLink).click();
        return new ShowPage(webDriver);
    }

}
