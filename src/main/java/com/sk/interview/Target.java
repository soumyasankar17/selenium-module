package com.sk.interview;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class Target {

    WebDriver driver;
    JSONObject input;

    @BeforeTest
    public void setup() throws IOException, ParseException {
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        input = (JSONObject) new JSONParser().parse(new FileReader("/Users/SankarEdala/Desktop/selenium-module/src/main/resources/input.json"));
    }

    @Test
    public void targetTest() throws InterruptedException {
        String url = "https://www.target.com/";
        driver.get(url);
        Thread.sleep(1000);
        TargetHomePage homePage = new TargetHomePage(driver);
        homePage.getAccountSignIn().click();
        Thread.sleep(1000);
        homePage.getCreateAcc().click();
        Thread.sleep(1000);
        homePage.getUserName().sendKeys(email());
        homePage.getFirstName().sendKeys((CharSequence) input.get("firstName"));
        homePage.getLastName().sendKeys((CharSequence) input.get("lastName"));
        homePage.getPhoneNum().sendKeys((CharSequence) input.get("phoneNum"));
        homePage.getPassword().sendKeys((CharSequence) input.get("password"));
        Thread.sleep(1000);
        Actions act = new Actions(driver);
        act.moveToElement(homePage.getKeepMeSignIn()).click().build().perform();
        Thread.sleep(1000);
        homePage.getCreateAccountButton().click();
        Thread.sleep(10000);

        // this OTP page - Target throwing error "something went wrong" - I believe Target might be
        // tracking the IP due to multiple hits.
        homePage.getNotNowButton().click();
        Thread.sleep(5000);
        driver.quit();
    }

    private String email() {
        return RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
    }
}
