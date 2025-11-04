package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExcelUtil;

public class LoginExcelTest extends BaseTest {

    @Test
    public void testLoginWithExcelData() throws Exception {

        String excelPath = System.getProperty("user.dir") + "/src/test/resources/testdata/LoginData.xlsx";
        ExcelUtil.loadExcel(excelPath);

        int totalRows = ExcelUtil.getRowCount("Sheet1");
        System.out.println("📄 Total Rows in Excel: " + totalRows);

        for (int i = 1; i < totalRows; i++) {
            String username = ExcelUtil.getCellData("Sheet1", i, 0);
            String password = ExcelUtil.getCellData("Sheet1", i, 1);

            System.out.println(" Trying login with: " + username + " / " + password);

            basedriver.get("https://www.saucedemo.com/");
            basedriver.findElement(By.id("user-name")).sendKeys(username);
            basedriver.findElement(By.id("password")).sendKeys(password);
            basedriver.findElement(By.id("login-button")).click();

            // Verify login success
            boolean loggedIn = basedriver.getCurrentUrl().contains("inventory");

            if (loggedIn) {
                System.out.println(" Login successful for user: " + username);
                basedriver.findElement(By.id("react-burger-menu-btn")).click();
                Thread.sleep(1000);
                basedriver.findElement(By.id("logout_sidebar_link")).click();
            } else {
                System.out.println(" Login failed for user: " + username);
                Assert.assertTrue(basedriver.findElement(By.cssSelector("h3[data-test='error']")).isDisplayed(),
                        "Expected error message for invalid login");
            }
        }

        ExcelUtil.closeExcel();
    }
}
