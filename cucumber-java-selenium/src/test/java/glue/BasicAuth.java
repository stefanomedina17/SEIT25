package glue;

import core.Context;
import core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import pages.page_Home;

import java.util.List;

public class BasicAuth extends Context{

    public BasicAuth(Manager manager) {
        super(manager);
        //this.homePage = new page_Home(manager.getDriver());
    }
}
