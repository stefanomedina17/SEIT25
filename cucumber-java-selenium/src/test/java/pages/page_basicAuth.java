package pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.jupiter.api.Assertions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.Robot;

import locators.BasicAuth;

public class page_basicAuth extends Page {

    public BasicAuth locatorBasicAuth;
    Robot robot = new Robot();

    public page_basicAuth(ChromeDriver driver) throws AWTException {
        super(driver);
        this.locatorBasicAuth = new BasicAuth();

        PageFactory.initElements(driver,  this.locatorBasicAuth);
    }

    public Robot getRobot() {
        if (robot == null) {
            try {
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
        return robot;
    }

    public void login(String user, String pass){
        getRobot().delay(1000);
        copyCredentialsClipboardToInput(user);
        System.out.println("Username entered.....");
        getRobot().keyPress(KeyEvent.VK_TAB);
        getRobot().keyRelease(KeyEvent.VK_TAB);
        getRobot().delay(300);
        copyCredentialsClipboardToInput(pass);
        System.out.println("Password entered.....");
        getRobot().keyPress(KeyEvent.VK_TAB);
        getRobot().keyRelease(KeyEvent.VK_TAB);
        getRobot().delay(300);
        getRobot().keyPress(KeyEvent.VK_ENTER);
    }

    private void copyCredentialsClipboardToInput(String value) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(value), null);
        getRobot().keyPress(KeyEvent.VK_CONTROL);
        getRobot().keyPress(KeyEvent.VK_V);
        getRobot().keyRelease(KeyEvent.VK_V);
        getRobot().keyRelease(KeyEvent.VK_CONTROL);
    }

    public void isCongratulationsDisplayed() {
        System.out.println("Checking if page is loaded.....");
        boolean isTextVisible = locatorBasicAuth.txt_Congratulations.isDisplayed();

        Assertions.assertTrue(isTextVisible, "Congratulations text is not visible");
    }
}
