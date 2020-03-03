package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.TestUtilities;

public class Hooks {
    private TestUtilities testUtils;

    public Hooks(TestUtilities testUtils) {
        this.testUtils = testUtils;
    }

    @Before
    public void setUp() {
        testUtils.initializeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        testUtils.screenshotInCaseOfFailure(scenario);
        testUtils.closeBrowser();
    }
}
