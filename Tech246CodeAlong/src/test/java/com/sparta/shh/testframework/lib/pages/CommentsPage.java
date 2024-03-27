package com.sparta.shh.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CommentsPage extends Page{


    private By searchField = new By.ByName("q");

    public CommentsPage(WebDriver webDriver) {
        super(webDriver);
        if (!webDriver.getTitle().contains("New Comments"))
        {
            throw new IllegalStateException("This is not the comments page," +
                    "current page is " + webDriver.getCurrentUrl());
        }
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
}
