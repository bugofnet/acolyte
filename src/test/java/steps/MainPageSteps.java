package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import locators.MainPageLocators;
import pages.MainPageActions;
import utilities.TestUtilities;

public class MainPageSteps {
    private MainPageActions mainPageActions;
    private TestUtilities testUtilities;
    private final String SITE_URL = "http://acolytemeetings.com/";

    public MainPageSteps(MainPageActions mainPageActions, TestUtilities testUtilities){
        this.mainPageActions = mainPageActions;
        this.testUtilities = testUtilities;
    }

    @Given("^I go to the main page$")
    public void iGoToTheMainPage() {
        testUtilities.openBrowser(SITE_URL);
    }

    @When("^I click button login$")
    public void iClickButtonLogin(){
        mainPageActions.loginButtonClick();
    }

    @Then("^I see the form$")
    public void iSeeTheForm(){
        mainPageActions.loginFormDisplayed();
    }
}
