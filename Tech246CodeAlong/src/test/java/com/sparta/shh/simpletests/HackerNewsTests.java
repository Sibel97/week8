package com.sparta.shh.simpletests;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class HackerNewsTests {
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    private static final String BASE_URL = "https://news.ycombinator.com/";
    private static ChromeDriverService service;


    WebDriver webDriver;

    @BeforeAll
    public static void beforeAll() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(DRIVER_LOCATION))
                .usingAnyFreePort()//use any available port
                .build();//once build
        service.start();;//start the service
    }

    @AfterAll
    static void afterAll() {
        service.stop();//this will stop the server.
    }

    @BeforeEach
    public void setup() {
        webDriver = new RemoteWebDriver(service.getUrl(), getChromeOptions());//create a new remote webdriver.will get the url.
    }

    @AfterEach
    public void afterEach() {
        webDriver.quit();
    }


    @Test
    @DisplayName("Check that the webdriver works")
    public void checkWebDriver() {
        webDriver.get(BASE_URL);
        Assertions.assertEquals("https://news.ycombinator.com/", webDriver.getCurrentUrl());
        Assertions.assertEquals("Hacker News", webDriver.getTitle());
    }

    @Test
    @DisplayName("Check that the link to the past page works")
    public void checkPastLink() {
        // Arrange
        webDriver.get(BASE_URL);
        // Act
        WebElement pastLink = webDriver.findElement(By.linkText("past"));
        pastLink.click();
        // Assert
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://news.ycombinator.com/front"));
        MatcherAssert.assertThat(webDriver.getTitle(), containsString("front"));
    }

    //*[@id="hnmain"]/tbody/tr[3]/td/div/text()
//    what should the date be?
//    where is it?
//    what is the best selector?
//    what format should it be in?

     @Test
     @DisplayName("Checking areas of the past page")
     public void checkPastPage()
     {
         webDriver.get(BASE_URL);
         WebElement pastLink = webDriver.findElement(By.linkText("past"));
         pastLink.click();

         LocalDate now = LocalDate.now();
         LocalDate yesterdayDate = now.minusDays(1);

         MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://news.ycombinator.com/front"));
         MatcherAssert.assertThat(webDriver.findElement(By.id("hnmain")).getText().toLowerCase(), containsString(yesterdayDate.toString()));

     }
    @Test
    @DisplayName("Checking areas of the past page")
    public void checkLoginPage()
    {
        webDriver.get(BASE_URL);
        WebElement loginLink = webDriver.findElement(By.linkText("login"));
        loginLink.click();

        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://news.ycombinator.com/login?goto=news"));

    }

    @Test
    @DisplayName("Check that the link to the Comment page works")
    public void checkCommentLink() {
        // Arrange
        webDriver.get(BASE_URL);
        // Act
        WebElement commentLink = webDriver.findElement(By.linkText("comments"));
        commentLink.click();
        // Assert
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://news.ycombinator.com/newcomments"));
        MatcherAssert.assertThat(webDriver.getTitle(), containsString("New Comments"));
    }

    @Test
    @DisplayName("Check that the link to the Show page works")
    public void checkShowLink() {
        // Arrange
        webDriver.get(BASE_URL);
        // Act
        WebElement showLink = webDriver.findElement(By.linkText("show"));
        showLink.click();
        // Assert
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://news.ycombinator.com/show"));
        MatcherAssert.assertThat(webDriver.getTitle(), containsString("Show"));
    }

    @Test
    @DisplayName("Check that the link to the Job page works")
    public void checkJobsLink() {
        // Arrange
        webDriver.get(BASE_URL);
        // Act
        WebElement jobLink = webDriver.findElement(By.linkText("jobs"));
        jobLink.click();
        // Assert
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://news.ycombinator.com/jobs"));
        MatcherAssert.assertThat(webDriver.getTitle(), containsString("jobs"));
    }

    @Test
    @DisplayName("Check that we can search for java")
    void searchForJava() {
        // Arrange
        webDriver.get(BASE_URL);
        // Act
        webDriver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        // Assert
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://hn.algolia.com/?q=java"));
    }
    @Test
    @DisplayName("Check that we can use search facility with wait")
    void searchForJavaWithWait() {
        webDriver.get(BASE_URL);
        webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);


        Wait<WebDriver> webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        WebElement searchBox = webDriverWait
                .until(ExpectedConditions.elementToBeClickable(By.className("SearchInput")));

        searchBox.sendKeys("Java", Keys.ENTER);

//    webDriverWait.until(d -> d.getCurrentUrl().contains("query=Java"));

        MatcherAssert.assertThat(
                webDriver.findElement(By.cssSelector(".Story:nth-child(1)")).getText().toLowerCase(),
                containsString("java")
        );
    }


    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");// this will show just content
        options.addArguments("--remote-allow-origins=*");
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        return options;
    }
}

