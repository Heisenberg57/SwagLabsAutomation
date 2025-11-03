package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String testName){
        String folderPath = System.getProperty("user.dir") + "/screenshots/";
        new File(folderPath).mkdirs();

        // File name with timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = folderPath + testName + "_" + timestamp + ".png";

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(filePath);
            Files.copy(src.toPath(), dest.toPath());
            System.out.println("📸 Screenshot captured: " + filePath);
        } catch (IOException e) {
            System.out.println("❌ Error while capturing screenshot: " + e.getMessage());
        }

        return filePath;
    }
}
