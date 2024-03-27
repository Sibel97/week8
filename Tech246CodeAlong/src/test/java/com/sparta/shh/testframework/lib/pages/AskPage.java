package com.sparta.shh.testframework.lib.pages;

import org.openqa.selenium.WebDriver;

public class AskPage extends Page
{
    public AskPage(WebDriver webDriver)
    {
        super(webDriver);
        if (!webDriver.getTitle().contains("Ask"))
        {
            throw new IllegalStateException("This is not the Ask page," +
                    "current page is " + webDriver.getCurrentUrl());
        }

    }

    public HomePage goToHomePage()
    {
        webDriver.findElement(homeLink).click();
        return new HomePage(webDriver);
    }
}
