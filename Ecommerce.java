package org.ankit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class Ecommerce {
        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.firefoxdriver().setup();
            WebDriver instance = new FirefoxDriver();
            instance.manage().window().maximize();
            instance.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            WebDriverWait wait = new WebDriverWait(instance,Duration.ofSeconds(15));
            instance.get("https://www.saucedemo.com/");
            System.out.println("Title "+ instance.getTitle());
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("visual_user");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("secret_sauce");
            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
            System.out.println("Logged In");
            wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack"))).click();
            System.out.println("Added Cart");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-test='shopping-cart-link']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout"))).click();
            System.out.println("Clicked Checkout");
            System.out.println("Enter Your Info");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name"))).sendKeys("Mr");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name"))).sendKeys("Singh");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postal-code"))).sendKeys("201310");
            System.out.println("Filled User Details");
            wait.until(ExpectedConditions.elementToBeClickable(By.id("continue"))).click();
            System.out.println("Clicked Continue Button");
            wait.until(ExpectedConditions.elementToBeClickable(By.id("finish"))).click();
            System.out.println("Clicked Finish Button");
        }
    }
