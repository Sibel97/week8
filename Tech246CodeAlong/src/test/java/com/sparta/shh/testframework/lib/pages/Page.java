package com.sparta.shh.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Page {

    protected WebDriver webDriver;
    protected Wait<WebDriver> webDriverWait;

    protected By homeLink = new By.ByLinkText("new");

    public Page(WebDriver webDriver)
    {   this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

    }

    public String getUrl()
    {
        return webDriver.getCurrentUrl();
    }

    public String getTitle()
    {
        return webDriver.getTitle();
    }
}
