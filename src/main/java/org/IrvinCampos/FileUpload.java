package org.IrvinCampos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://altoconvertpdftojpg.com/");
        driver.findElement(By.id("browse")).click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\Irvin\\Documents\\fileUpload.exe");
        driver.findElement(By.id("submit_btn")).click();

    }
}
