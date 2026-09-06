package glue;

import core.Context;
import core.Manager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.page_basicAuth;

import java.awt.*;

public class BasicAuth extends Context{

    public page_basicAuth basicAuthPage;

    public BasicAuth(Manager manager) throws AWTException {
        super(manager);
        this.basicAuthPage = new page_basicAuth(manager.getDriver());
    }

    @And("user logs in")
    public void enterCredentials() {
        String user = fetch("user");
        String pass = fetch("pass");
        basicAuthPage.login(user, pass);
    }

    @Then("Congratulations text should be displayed")
    public void verifyCongratulationsIsDisplayed() {
        basicAuthPage.isCongratulationsDisplayed();
    }
}
