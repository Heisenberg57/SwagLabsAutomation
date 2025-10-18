package tests;

import base.BaseTest;
import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
import org.openqa.selenium.WebDriver;

public class SwagLabsTest extends BaseTest {
    public static void main(String[] args) {
        SwagLabsTest test = new SwagLabsTest();
        test.setUp();

        try{
            test.basedriver.get("https://www.saucedemo.com/");
            System.out.println(test.basedriver.getTitle());



        } catch (Exception e) {
            e.printStackTrace();

        }
        finally {
            test.tearDown();
        }



    }
}
