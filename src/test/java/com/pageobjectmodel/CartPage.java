package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelement.CartPageInterfaceElement;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends Base_Class implements CartPageInterfaceElement {
    @FindBy(linkText = "Cart")
    private WebElement cartLink;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "card")
    private WebElement card;

    @FindBy(id = "month")
    private WebElement month;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseBtn;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement okBtn;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase! ']")
    private WebElement thankYouMsg;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    private WebElement orderDetails;

    @FindBy(id = "logout2")
    public WebElement logoutBtn;

    public CartPage(){
        PageFactory.initElements(driver, this);
    }

    public void checkoutProduct() throws InterruptedException {
        clickOnElement(cartLink);
        Thread.sleep(2000);
        takeScreenshot();
        clickOnElement(placeOrderButton);
        Thread.sleep(2000);

        passInput(name, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("name"));
        passInput(country, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("country"));
        passInput(city, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("city"));
        passInput(card, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("card"));
        passInput(month, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("month"));
        passInput(year, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("year"));

        clickOnElement(purchaseBtn);
        Thread.sleep(2000);
        getText(thankYouMsg.getText());
        getText(orderDetails.getText());
        clickOnElement(okBtn);
        takeScreenshot("PurchasePage");

        System.out.println("Successfully purchased");


    }

    private void takeScreenshot() {
    }
}

