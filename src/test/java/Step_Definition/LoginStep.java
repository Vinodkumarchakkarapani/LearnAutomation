package Step_Definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
//import com.madgag.diff.ImageDiffer;
//import com.madgag.diff.ImageDiff;


public class LoginStep {

    WebDriver driver = null;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("user is on the login page");
        System.setProperty("webdriver.chrome.driver", "C://Users//rekha//IdeaProjects//BDD//src//test//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("user enters the username and password")
    public void user_enters_the_username_and_password() {
        System.out.println("Entering credentials");
        driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--focus']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
    }

    @And("click login button")
    public void click_login_button() {
        System.out.println("Clicked on login button");
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();
    }

    @Then("user should navigate to home page")
    public void user_should_navigate_to_home_page() {
        System.out.println("Landing on home page");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

        String label = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
        Assert.assertEquals("Dashboard", label);

        WebElement logo = driver.findElement(By.xpath("//img[@src='/web/images/orangehrm-logo.png?v=1721393199309']"));

        try {
            BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir") + File.separator + "Images" + File.separator + "ElementScreenshot.png"));
            Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logo);
            BufferedImage actualImage = logoImageScreenshot.getImage();

            ImageDiffer imgDiff = new ImageDiffer();
            ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
            Assert.assertFalse("Images are different", diff.hasDiff());

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Failed to load image files or capture screenshot.");
        }

        // Take screenshot of the logo
//        Screenshot screenshot = new AShot().takeScreenshot(driver, logo);
//        String userDir = System.getProperty("user.dir");
//        File outputDir = new File(userDir + File.separator + "Screenshots");
//        if (!outputDir.exists()) {
//            outputDir.mkdirs(); // Create the directory if it does not exist
//        }
//        File outputFile = new File(outputDir, "Orangehrm.png");
//        try {
//            ImageIO.write(screenshot.getImage(), "PNG", outputFile);
//        } catch (IOException e) {
//            e.printStackTrace(); // Print the exception stack trace
//        }

        int logoWidth = logo.getSize().getWidth();
        System.out.println("Logo width : " + logoWidth + " pixels");
        int logoHeight = logo.getSize().getHeight();
        System.out.println("Logo height : " + logoHeight + " pixels");

        driver.quit(); // Fixed typo here
    }
}