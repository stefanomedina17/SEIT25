package glue;

import io.cucumber.java.en.Given;
import core.Context;
import core.Manager;
import io.cucumber.java.en.When;
import pages.page_Home;

public class Navigation extends Context {

  public page_Home homePage;

  public Navigation(Manager manager) {
    super(manager);
    this.homePage = new page_Home(manager.getDriver());
  }

  @Given("^the page under test is '(.+)'$")
  public void navToHomePage(String url) {
    manager.getDriver().get(url);
    stash("user", "admin");
    stash("pass", "admin");
  }

  @When("^the '(.+)' example is opened$")
  public void navToOptions(String option) {
    homePage.clickListOption(option);
  }
}