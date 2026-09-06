package core;

import java.util.HashMap;
import org.openqa.selenium.chrome.ChromeDriver;

public class Manager {

  //Used as a stash for any data that needs shared across steps
  final HashMap<String, Object> stash;

  private ChromeDriver driver;

  public Manager() {
    this.stash = new HashMap<>();
  }

  public ChromeDriver getDriver() {
    if (driver == null) {
      driver = new ChromeDriver();
      driver.manage().window().maximize();
    }
    return driver;
  }

  public void setDriver(ChromeDriver driver) {
    this.driver = driver;
  }

  public void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}