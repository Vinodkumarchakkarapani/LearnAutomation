package Locator;
import java.awt.*;
import java.awt.event.KeyEvent;
public class AuthPopupHandler {
    public static void handleAuthPopup(String username, String password) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Thread.sleep(2000);  // Wait for popup

        // Enter Username
        for (char c : username.toCharArray()) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
        }

        // Press TAB to switch to password field
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        // Enter Password
        for (char c : password.toCharArray()) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
        }

        // Press ENTER to submit
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("Authentication Completed!");
    }
}

