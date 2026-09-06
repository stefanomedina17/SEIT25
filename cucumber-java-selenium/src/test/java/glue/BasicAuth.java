package glue;

import core.Context;
import core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import pages.page_Home;
import pages.page_basicAuth;

import java.util.List;

public class BasicAuth extends Context{

    public page_Home homePage;
    //public page_basicAuth basicAuthPage;

    public BasicAuth(Manager manager) {
        super(manager);
        this.homePage = new page_Home(manager.getDriver());
    }

    //System.out.println("printing shared stash :" + getTestStash().toString());

    @When("^the '(.+)' example is opened$")
    public void verifyBasicAuthPageRedirection(String option) {
        homePage.clickListOption(option);
//        boolean homePageLoaded = homePage.isHomePageLoaded();
//        Assertions.assertTrue(homePageLoaded);
    }
}
