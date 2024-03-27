package com.sparta.shh.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PastPage extends Page
{


    private By searchField = new By.ByName("q");

    public PastPage(WebDriver webDriver)
    {
        super(webDriver);
        if (!webDriver.getTitle().contains("front | Hacker News"))
        {
            throw new IllegalStateException("This is not the past page," +
                    "current page is " + webDriver.getCurrentUrl());
        }

        this.webDriver = webDriver;
    }

    public HomePage goToHomePage()
    {
        webDriver.findElement(homeLink).click();
        return new HomePage(webDriver);
    }
    public SearchPage search(String value)
    {
        webDriver.findElement(searchField).sendKeys(value, Keys.ENTER);
        return new SearchPage(webDriver);
    }

//    public String getUrl()
//    {
//        return webDriver.getCurrentUrl();
//    }
//
//    public String getTitle()
//    {
//        return webDriver.getTitle();
//    }
}
