package glue;

import core.Context;
import core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import pages.page_Home;

import java.util.List;

public class Home extends Context {

  public page_Home homePage;

  public Home(Manager manager) {
    super(manager);
    this.homePage = new page_Home(manager.getDriver());
  }

  @And("the home page is loaded successfully")
  public void loadHomePage() {
    homePage.homePageLoad();
  }

  @Then("the actual displayed list matches expected list")
  public void verifyHomePageList(){
    List<String> actualList = homePage.getActualHomeList();
    List<String> expectedList = homePage.getExpectedHomeList();

    homePage.areListValuesMatched(actualList, expectedList);
  }
}