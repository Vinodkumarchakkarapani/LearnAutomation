package Selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumExample {
    public static void main(String[] args) {
        // Set the path to chromedriver if necessary (not needed if in PATH)
//        System.setProperty("webdriver.chrome.driver", "C:/Users/rekha/IdeaProjects/BDD/src/test/Drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
//
//        driver.manage().window().minimize();
        String title = driver.getTitle();
        System.out.println("Title:" +title);

// get the Pagesource
//        String pagesource=driver.getPageSource();
//        System.out.println("Pagesource"+pagesource);

        driver.navigate().to("https://www.leafground.com/dashboard.xhtml");

        String currenturl=driver.getCurrentUrl();
        System.out.println("Current URL: "+currenturl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='logo']")));

        WebElement browserbutton = driver.findElement(By.xpath("//*[@id='menuform:j_idt39']/a"));
        browserbutton.click();
        WebElement browsertab= driver.findElement(By.xpath("//span[normalize-space()='Window']"));
        browsertab.click();

        WebElement newwindow = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        newwindow.click();

        String mainWindow = driver.getWindowHandle(); // Get main window handle

        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window); // Switch to a new window
            if (!window.equals(mainWindow)) {
                driver.close(); // Close the new window
            }
        }
        driver.switchTo().window(mainWindow);

//        driver.switchTo().window(String )





//        driver.navigate().back();
//        driver.navigate().forward();






        // Close the browser
//        driver.quit();
    }
}
