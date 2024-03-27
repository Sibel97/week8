package com.sparta.shh.testframework.lib.pages;

import org.openqa.selenium.WebDriver;

public class ShowPage extends Page{

    public ShowPage(WebDriver webDriver)
    {
        super(webDriver);
        if (!webDriver.getTitle().contains("Show"))
        {
            throw new IllegalStateException("This is not the Show page," +
                    "current page is " + webDriver.getCurrentUrl());
        }

    }

    public HomePage goToHomePage()
    {
        webDriver.findElement(homeLink).click();
        return new HomePage(webDriver);
    }
}


