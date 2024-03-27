package com.sparta.shh.testframework.lib.MyStepDefs;

import com.sparta.shh.testframework.lib.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.Before;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.hamcrest.Matchers.containsString;

public class MyStepdefs {

    private static ChromeDriverService service;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    private static final String BASE_URL = "https://news.ycombinator.com/";

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");// this will show just content
        options.addArguments("--remote-allow-origins=*");
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        return options;
    }

    @BeforeAll
    public static void beforeAll() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(DRIVER_LOCATION))
                .usingAnyFreePort()//use any available port
                .build();//once build
        service.start();;//start the service
    }

    WebDriver webDriver;
    private HomePage homepage;
    private PastPage pastPage;
    private  SearchPage searchPage;
    private CommentsPage commentsPage;
    private JobPage jobsPage;
    private AskPage askPage;
    private ShowPage showPage;


    @AfterAll
    static void afterAll() {
        service.stop();//this will stop the server.
    }

    @Before
    public void setup() {
        webDriver = new RemoteWebDriver(service.getUrl(), getChromeOptions());//create a new remote webdriver.will get the url.
    }

//    @After
//    public void afterEach() {
//        webDriver.quit();
//    }


    @When("I click the past link")
    public void iClickThePastLink() {
        pastPage = homepage.goToPastPage();
    }

    @Given("I am on the Hacker News Website")
    public void iAmOnTheHackerNewsWebsite() {
        webDriver.get(BASE_URL);
        homepage = new HomePage(webDriver);
        
    }

    @Then("i will go to the past page")
    public void iWillGoToThePastPage() {

        MatcherAssert.assertThat(pastPage.getUrl(), Is.is("https://news.ycombinator.com/front"));
    }

    @When("I search for the term java")
    public void iSearchForTheTermJava() {
        searchPage = homepage.search("java");
    }

    @Then("I will receive a list of stories based on java")
    public void iWillReceiveAListOfStoriesBasedOnJava() {

        MatcherAssert.assertThat(searchPage.getUrl(),Is.is("https://hn.algolia.com/?q=java"));
    }

    @When("I click on the comments link")
    public void iClickOnTheCommentsLink() {
        commentsPage = homepage.goToCommentsPage();
    }

    @Then("I will go to the comments page")
    public void iWillGoToTheCommentsPage()
    {
        MatcherAssert.assertThat(commentsPage.getUrl(), Is.is("https://news.ycombinator.com/newcomments"));
    }

    @When("I click on the jobs link")
    public void iClickOnTheJobsLink() {
        jobsPage = homepage.goToJobsPage();

    }

    @Then("I will go the the jobs page")
    public void iWillGoTheTheJobsPage() {
        MatcherAssert.assertThat(jobsPage.getUrl(), Is.is("https://news.ycombinator.com/jobs"));
    }

    @When("I click on the ask link")
    public void iClickOnTheAskLink() {
        askPage = homepage.goToAskPage();

    }

    @Then("I will go to the ask page")
    public void iWillGoToTheAskPage() {
        MatcherAssert.assertThat(askPage.getUrl(), Is.is("https://news.ycombinator.com/ask"));
    }

    @When("I click on the show page")
    public void iClickOnTheShowPage() {
        showPage = homepage.goToShowPage();
    }

    @Then("I will go to the show page")
    public void iWillGoToTheShowPage()
    {
        MatcherAssert.assertThat(showPage.getUrl(), Is.is("https://news.ycombinator.com/show"));
    }
}
