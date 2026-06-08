package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelement.LoginPageInterfaceElement;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base_Class implements LoginPageInterfaceElement {

    @FindBy(linkText = linkText_login)
    private static  WebElement loginLink;
    @FindBy(id = username_login)
    private static WebElement username;
    @FindBy(css = password_login)
    private static WebElement password;
    @FindBy(xpath = signin_xpath)
    private static WebElement signin;
    @FindBy(id = tittle_id)
    private static WebElement title;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    public void validLogin() throws InterruptedException {
        clickOnElement(loginLink);
        Thread.sleep(1000);
        passInput(username, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("username"));
        passInput(password, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("password"));
        clickOnElement(signin);
        Thread.sleep(2000);
        getText(title.getText());
    }

}