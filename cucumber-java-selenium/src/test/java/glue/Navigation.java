package glue;

import io.cucumber.java.en.Given;
import core.Context;
import core.Manager;
import pages.page_Home;

public class Navigation extends Context {

  public page_Home homePage;

  public Navigation(Manager manager) {
    super(manager);
    this.homePage = new page_Home(manager.getDriver());
  }

  @Given("^the page under test is '(.+)'$")
  public void navToPage(String url) {
    manager.getDriver().get(url);
    stash("user", "admin");
    stash("pass", "admin");
  }
}