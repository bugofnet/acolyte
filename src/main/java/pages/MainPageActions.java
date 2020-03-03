package pages;

import locators.MainPageLocators;

public class MainPageActions {
    public MainPageActions(MainPageLocators mainPageLocators,
                           CommonActions commonActions) {
        this.mainPageLocators = mainPageLocators;
        this.commonActions = commonActions;
        commonActions.pageFactoryInitElements(mainPageLocators);
    }

    private MainPageLocators mainPageLocators;
    private CommonActions commonActions;

    public void loginButtonClick(){
        commonActions.clickOnElementWithJS(mainPageLocators.loginButton);
    }

    public void loginFormDisplayed(){
        commonActions.isElementDisplayed(mainPageLocators.loginButton);
    }
}
