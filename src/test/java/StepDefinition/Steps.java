package StepDefinition;

import Locator.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

public class Steps {
    WebDriver driver;


    @Given("Hit the testleaf web URL")
    public void hit_the_testleaf_web_url() {
     driver=new ChromeDriver();
     driver.get("https://www.leafground.com/dashboard.xhtml");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Write code here that turns the phrase above into concrete actions

    }

    @When("Click the home button when lands on dashboard screen")
    public void click_the_home_button_when_lands_on_dashboard_screen() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath(Locator.Home)).click();
        String home_text=driver.findElement(By.xpath(Locator.Home)).getText();
        System.out.println(home_text);
        driver.findElement(By.xpath(Locator.Basic)).click();
        String basic_auth_text = driver.findElement(By.xpath(Locator.Basic_auth_button)).getText();
        System.out.println(basic_auth_text);
//        driver.findElement(By.xpath(Locator.Basic_auth_button)).click();



    }

    @And("Click on Authenctication tile")
    public void click_on_authenctication_tile(){
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath(Locator.Basic_auth_button)).click();
//        String mainWindowHandle = driver.getWindowHandle();
//
//        // Perform an action that opens a new window
//        // (Example: clicking a link that opens a new tab/window)
//
//        // Wait for the second window to appear
//        Thread.sleep(3000);
//
//        // Get all window handles
//        Set<String> allWindowHandles = driver.getWindowHandles();
//        Iterator<String> iterator = allWindowHandles.iterator();
//
//        while (iterator.hasNext()) {
//            String windowHandle = iterator.next();
//
//            // Switch to the new window (ignore the main window)
//            if (!windowHandle.equals(mainWindowHandle)) {
//                driver.switchTo().window(windowHandle);
//                System.out.println("Switched to second window: " + windowHandle);
//                break;
//            }
//        }
//
//        // Now, perform actions in the second window
////        driver.get("http://leafground.com:8090");
//
//
////        String username = "Admin";
////        String password = "testleaf";
////        String url = "http://" + username + ":" + password + "@leafground.com:8090";
////
////        // Open the URL with credentials
////        driver.get(url);
////        driver.get("http://leafground.com:8090");
////        Thread.sleep(3000);
//
//
//        Robot robot = new Robot();
//
//        Thread.sleep(3000); // Wait for popup to appear
//
//        // Enter Username
//        robot.keyPress(KeyEvent.VK_A);
//        robot.keyRelease(KeyEvent.VK_A);
//        robot.keyPress(KeyEvent.VK_D);
//        robot.keyRelease(KeyEvent.VK_D);
//        robot.keyPress(KeyEvent.VK_M);
//        robot.keyRelease(KeyEvent.VK_M);
//        robot.keyPress(KeyEvent.VK_I);
//        robot.keyRelease(KeyEvent.VK_I);
//        robot.keyPress(KeyEvent.VK_N);
//        robot.keyRelease(KeyEvent.VK_N);
//
//        // Press TAB to switch to password
//        robot.keyPress(KeyEvent.VK_TAB);
//        robot.keyRelease(KeyEvent.VK_TAB);
//
//        // Enter Password
//        robot.keyPress(KeyEvent.VK_T);
//        robot.keyRelease(KeyEvent.VK_T);
//        robot.keyPress(KeyEvent.VK_E);
//        robot.keyRelease(KeyEvent.VK_E);
//        robot.keyPress(KeyEvent.VK_S);
//        robot.keyRelease(KeyEvent.VK_S);
//        robot.keyPress(KeyEvent.VK_T);
//        robot.keyRelease(KeyEvent.VK_T);
//        robot.keyPress(KeyEvent.VK_L);
//        robot.keyRelease(KeyEvent.VK_L);
//        robot.keyPress(KeyEvent.VK_E);
//        robot.keyRelease(KeyEvent.VK_E);
//        robot.keyPress(KeyEvent.VK_A);
//        robot.keyRelease(KeyEvent.VK_A);
//        robot.keyPress(KeyEvent.VK_F);
//        robot.keyRelease(KeyEvent.VK_F);
//
//        // Press ENTER to submit
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        Thread.sleep(3000);
//        driver.close();

//        driver.get("http://username:password@leafground.com:8090");
//        Process process = Runtime.getRuntime().exec("C:/Users/rekha/OneDrive/Desktop/auth_popup.exe");
//        process.waitFor();
//        System.out.println("Authentication completed!");


//        Object[] mainWindow = driver.getWindowHandles().toArray();
//        System.out.println("Main Window Handle: " + Arrays.toString(mainWindow));
//        assertNotNull(mainWindow);
//        driver.switchTo().window((String) mainWindow[1]);
//        Alert alert =driver.switchTo().alert();
//        alert.sendKeys("Admin");
//        alert.sendKeys("testleaf");
//
//        alert.accept();

        // Click an element that opens a new window (Assume there is a link that opens a new tab)
        // driver.findElement(By.linkText("Open New Window")).click();

        // Get all open window handles
//        Set<String> allWindows = driver.getWindowHandles();
//
//        // Switch to the new window
//        for (String window : allWindows) {
//            if (!window.equals(mainWindow)) {
//                driver.switchTo().window(window);
//                System.out.println("Switched to new window: " + window);
//                break;
//            }
//        }



    }

    @Then("Lands on Basic authentication")
    public void lands_on_basic_authentication(String username,String password) throws IOException, InterruptedException, AWTException {

        String mainWindowHandle = driver.getWindowHandle();

        // Perform an action that opens a new window
        // (Example: clicking a link that opens a new tab/window)

        // Wait for the second window to appear
        Thread.sleep(3000);

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        while (iterator.hasNext()) {
            String windowHandle = iterator.next();

            // Switch to the new window (ignore the main window)
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Switched to second window: " + windowHandle);
                break;
            }
        }

        // Now, perform actions in the second window
//        driver.get("http://leafground.com:8090");


//        String username = "Admin";
//        String password = "testleaf";
//        String url = "http://" + username + ":" + password + "@leafground.com:8090";
//
//        // Open the URL with credentials
//        driver.get(url);
//        driver.get("http://leafground.com:8090");
//        Thread.sleep(3000);


        Robot robot = new Robot();

        Thread.sleep(3000); // Wait for popup to appear
        AuthPopupHandler.handleAuthPopup(username, password);
        // Enter Username
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyRelease(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);

        // Press TAB to switch to password
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        // Enter Password
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_F);

        // Press ENTER to submit
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        String basic_auth_text = driver.findElement(By.xpath(Locator.login_success)).getText();
        System.out.println(basic_auth_text);
//
        driver.close();

//        driver.get("http://username:password@leafground.com:8090");
//        Process process = Runtime.getRuntime().exec("C:/Users/rekha/OneDrive/Desktop/auth_popup.exe");
//        process.waitFor();
//        System.out.println("Authentication completed!");


//        Object[] mainWindow = driver.getWindowHandles().toArray();
//        System.out.println("Main Window Handle: " + Arrays.toString(mainWindow));
//        assertNotNull(mainWindow);
//        driver.switchTo().window((String) mainWindow[1]);
//        Alert alert =driver.switchTo().alert();
//        alert.sendKeys("Admin");
//        alert.sendKeys("testleaf");
//
//        alert.accept();

        // Click an element that opens a new window (Assume there is a link that opens a new tab)
        // driver.findElement(By.linkText("Open New Window")).click();

        // Get all open window handles
//        Set<String> allWindows = driver.getWindowHandles();
//
//        // Switch to the new window
//        for (String window : allWindows) {
//            if (!window.equals(mainWindow)) {
//                driver.switchTo().window(window);
//                System.out.println("Switched to new window: " + window);
//                break;
//            }
//        }



        // Write code here that turns the phrase above into concrete actions

    }


}
