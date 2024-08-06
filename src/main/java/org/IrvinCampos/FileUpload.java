package org.IrvinCampos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Objects;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException, IOException {
        String downloadPath = System.getProperty("user.dir");
        ChromeOptions chromeOptions = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups",0);
        chromePrefs.put("download.default_directory",downloadPath);
        chromeOptions.setExperimentalOption("prefs",chromePrefs);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://altoconvertpdftojpg.com/");
        driver.findElement(By.id("browse")).click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\Irvin\\Documents\\fileUpload.exe");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("button[class*= 'rounded-lg py']"))));
        driver.findElement(By.cssSelector("button[class*= 'rounded-lg py']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));
        driver.findElement(By.linkText("Download Now")).click();
        File file = new File(downloadPath + "Desktop\\Sample");

        if (file.exists()) {
            System.out.println("File Found!");
            if (file.delete()) {
                System.out.println("File deleted!");
            }
        }
    }
}
