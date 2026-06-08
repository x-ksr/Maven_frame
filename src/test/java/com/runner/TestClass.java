package com.runner;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;

public class TestClass extends Base_Class {
    public static void main(String[] args) throws Exception {
        launchBrowser(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("browser"));
        launchUrl(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("url"));
        PageObjectManager.getPageObjectManager().getLoginPage().validLogin();
        PageObjectManager.getPageObjectManager().getSearchPage().addToCart();
        PageObjectManager.getPageObjectManager().getCartPage().checkoutProduct();
        PageObjectManager.getPageObjectManager().getCartPage().checkoutProduct();
    }
}