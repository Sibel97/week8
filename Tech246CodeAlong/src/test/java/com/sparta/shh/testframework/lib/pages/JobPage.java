package com.sparta.shh.testframework.lib.pages;

import org.openqa.selenium.WebDriver;

public class JobPage extends Page{

    public JobPage(WebDriver webDriver)
    {
        super(webDriver);
        if (!webDriver.getTitle().contains("jobs"))
        {
            throw new IllegalStateException("This is not the job page," +
                    "current page is " + webDriver.getCurrentUrl());
        }

    }

    public HomePage goToHomePage()
    {
        webDriver.findElement(homeLink).click();
        return new HomePage(webDriver);
    }


}
