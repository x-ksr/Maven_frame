package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelement.SearchPageInterfaceElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Base_Class
        implements SearchPageInterfaceElement {

    @FindBy(linkText = "Laptops")
    private WebElement laptopsCategory;

    @FindBy(linkText = "Sony vaio i7")
    private WebElement sonyVaioi7;

    @FindBy(linkText = "Add to cart")
    private WebElement addToCart;
    public SearchPage(){
        PageFactory.initElements(driver, this);
    }
    public void addToCart() throws InterruptedException{
        clickOnElement(laptopsCategory);
        Thread.sleep(1000);
        clickOnElement(sonyVaioi7);
        Thread.sleep(1000);
        clickOnElement(addToCart);
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();

        System.out.println("Alert Message: " + alert.getText());
        alert.accept();
    }

    }

