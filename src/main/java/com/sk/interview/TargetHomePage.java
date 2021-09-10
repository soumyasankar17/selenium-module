package com.sk.interview;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter
public class TargetHomePage {

    private WebDriver webDriver;

    @FindBy(id = "account")
    private WebElement accountSignIn;

    @FindBy(id = "accountNav-createAccount")
    private WebElement createAcc;

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "phone")
    private WebElement phoneNum;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "Check me!")
    private WebElement keepMeSignIn;

    @FindBy(id = "createAccount")
    private WebElement createAccountButton;


    @FindBy(id = "notNowButton")
    private WebElement notNowButton;

    public TargetHomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

}
