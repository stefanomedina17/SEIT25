package glue;

import core.Context;
import core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import pages.page_Home;

import java.util.List;

public class Home extends Context {

  public page_Home homePage;

  public Home(Manager manager) {
    super(manager);
    this.homePage = new page_Home(manager.getDriver());
  }

  @When("the home page is loaded successfully")
  public void verifyHomePageLoad() {
    //System.out.println("printing shared stash :" + getTestStash().toString());
    boolean homePageLoaded = homePage.isHomePageLoaded();
    Assertions.assertTrue(homePageLoaded);
  }

  @When("the 'Basic Auth' example is opened")
  public void verifyBasicAuthRedirection(){

  }


  @Then("verify if actual displayed list matches expected list")
  public void verifyHomePageList(){
    List<String> actualList = homePage.getHomeList();
    String[] expectedList = {"A/B Testing", "Add/Remove Elements", "Basic Auth (user and pass: admin)",
            "Broken Images", "Challenging DOM", "Context Menu", "Digest Authentication (user and pass: admin)",
            "Disappearing Elements", "Drag and Drop", "Dropdown", "Dynamic Content", "Dynamic Controls",
            "Dynamic Loading", "Entry Ad", "Exit Intent", "File Download", "File Upload", "Floating Menu",
            "Forgot Password", "Form Authentication", "Geolocation", "Horizontal Slider", "Infinite Scroll",
            "Inputs", "JavaScript Alerts", "JavaScript onload event error", "Key Presses", "Large & Deep DOM",
            "Multiple Windows", "Nested Frames", "Notification Messages", "Redirect Link", "Secure File Download",
            "Shadow DOM", "Shifting Content", "Slow Resources", "Sortable Data Tables", "Status Codes", "Typos",
            "WYSIWYG Editor"};

    Assertions.assertNotEquals(actualList, List.of(expectedList), "Results do not match");
  }

  @And("verify if actual displayed list matches expected list")
  public void
}