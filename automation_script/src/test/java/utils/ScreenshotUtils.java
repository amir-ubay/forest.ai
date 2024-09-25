package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Capture screenshot as a file
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Create the screenshots folder if it doesn't exist
            File screenshotsDir = new File(System.getProperty("user.dir") + "/screenshots");
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdirs();
            }

            // Define the screenshot file location and name
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String destination = screenshotsDir + "/" + screenshotName + "_" + timestamp + ".png";

            // Copy the screenshot to the destination path
            FileUtils.copyFile(srcFile, new File(destination));

            System.out.println("Screenshot taken: " + destination);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
