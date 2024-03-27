package com.sparta.shh.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class SearchPage extends Page {
    private By searchBox = new By.ByClassName("SearchInput");
    private By firstResult = new By.ByCssSelector(".Story:nth-child(1)");
    public SearchPage(WebDriver driver) {
        super(driver);
        // check on correct page
    }

    public void enterSearchTerm(String searchTerm) {

        WebElement searchBoxClickable = webDriverWait
                .until(ExpectedConditions.elementToBeClickable(searchBox));

        searchBoxClickable.sendKeys(searchTerm, Keys.ENTER);

        webDriverWait
                .until(ExpectedConditions.elementToBeClickable(searchBox));
    }

    public String getText() {
        return webDriver.findElement(firstResult).getText().toLowerCase();
    }
}

