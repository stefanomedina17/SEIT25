package core;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import java.util.logging.Level;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

public class Hooks extends Context {

  public Hooks(Manager manager) {
    super(manager);
  }

  @Before()
  public void before() {
    ChromeOptions options = new ChromeOptions();
    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.BROWSER, Level.ALL);
    options.addArguments("start-maximized");
    options.setCapability(ChromeOptions.LOGGING_PREFS, logPrefs);
    manager.setDriver(new ChromeDriver(options));
    System.out.println("Driver is ready");
    System.out.println("----START TEST----");
  }

  @BeforeStep
  public void beforeStep() {
    System.out.println("----START OF STEP----");
  }

  @AfterStep
  public void afterStep(Scenario scenario) {
    byte[] screenshot = getDriver().getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot, "image/png", "TestArtifact");
    System.out.println("----END OF STEP----");
  }

  @After
  public void after() {
    getDriver().quit();
    System.out.println("Quit driver");
    System.out.println("----FINISHED TEST----");
  }
}
