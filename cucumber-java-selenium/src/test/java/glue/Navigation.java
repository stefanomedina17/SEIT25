package glue;

import io.cucumber.java.en.Given;
import core.Context;
import core.Manager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Navigation extends Context {

  public Navigation(Manager manager) {
    super(manager);
  }

  @Given("^the page under test is '(.+)'$")
  public void navToPage(String url) {

    if (manager.getDriver() == null) {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("start-maximized");
      manager.setDriver(new ChromeDriver(options));
    }

    manager.getDriver().get(url);
    stash("exampleKey1", "exampleValue1");
  }
}