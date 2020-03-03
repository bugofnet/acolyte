package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPageLocators {

    @FindBy(how = How.ID, using = "get-started-button")
    public WebElement getStartedButton;

    @FindBy(how = How.XPATH, using = "(//a/span[text()='Login'])[1]")
    public WebElement loginButton;

    @FindBy(how = How.CSS, using = ".t-Dialog-bodyWrapperIn")
    public WebElement userForm;
}
