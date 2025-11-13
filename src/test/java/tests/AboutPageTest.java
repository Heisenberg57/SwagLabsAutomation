package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.LoginPage;

public class AboutPageTest extends BaseTest {

    @Test
    public void verifyAboutPageNavigation(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("standard_user", "secret_sauce");

        AboutPage aboutPage = new AboutPage(getDriver());
        aboutPage.openMenu();
        aboutPage.clickAbout();

        String aboutTitle = aboutPage.switchToAboutPageAndGetTitle();
        System.out.println("About Page Title: " + aboutTitle);

        Assert.assertTrue(aboutTitle.contains("Sauce Labs"), "About Page opened successfully!");

        // Step 4: Close About tab and return
        aboutPage.goBackToApp();


    }

}
