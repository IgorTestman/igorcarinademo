package com.qaprosoft.carina.igor;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.igor.common.*;
import com.qaprosoft.carina.igor.utils.TextConstants;
import com.qaprosoft.carina.igor.utils.TimeConstants;
import com.qaprosoft.carina.igor.utils.BurgerMenu;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CarinaPageTest implements IAbstractTest, IMobileUtils, TextConstants, TimeConstants {

    @Test()
    @MethodOwner(owner = "IgorB")
    @TestLabel(name = "test 7", value = {"mobile", "regression"})
    public void validationUiElementsOnUserProfilePageTest() {
        SoftAssert softAssert = new SoftAssert();

        StartPageBase startPageBase = initPage(getDriver(), StartPageBase.class);
        Assert.assertTrue(startPageBase.isPageOpened(), "Start page isn't opened");
        LoginPageUiBase loginPageUiBase = startPageBase.clickNextBtn();
        CarinaHomePageBase carinaHomePage = loginPageUiBase.login();
        Assert.assertTrue(carinaHomePage.isPageOpened(), "Carina page isn't opened");
        CarinaWebViewPageBase carinaUserPage = carinaHomePage.navigateToUserPage();
        softAssert.assertTrue(carinaUserPage.isUserAvatarPresent(), "Avatar isn't present");
        softAssert.assertTrue(carinaUserPage.isUserNamePresent(), "User name isn't present");
        softAssert.assertTrue(carinaUserPage.isUserStatusPresent(), "User status isn't present");
        Assert.assertEquals(carinaUserPage.getUserNameText(), USER_NAME,"User name is different");
        Assert.assertEquals(carinaUserPage.getUserStatusText(),USER_STATUS, "User status is different");

        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "IgorB")
    @TestLabel(name = "test 8", value = {"mobile", "regression"})
    public void validationUiElementsOnChartPageTest() {
        SoftAssert softAssert = new SoftAssert();

        StartPageBase startPageBase = initPage(getDriver(), StartPageBase.class);
        Assert.assertTrue(startPageBase.isPageOpened(), "Start page isn't opened");
        LoginPageUiBase loginPageUiBase = startPageBase.clickNextBtn();
        CarinaHomePageBase carinaHomePage = loginPageUiBase.login();
        Assert.assertTrue(carinaHomePage.isPageOpened(), "Carina page isn't opened");
        ViewBurgerMenuPageBase viewBurgerMenuPageBase = carinaHomePage.openBurgerMenu();
        CarinaChartsPageBase carinaChartsPage = (CarinaChartsPageBase) viewBurgerMenuPageBase.openPageFromBurgerMenu(BurgerMenu.CHARTS);
        Assert.assertTrue(carinaChartsPage.isPageOpened(), "Charts page isn't opened!");
        softAssert.assertTrue(carinaChartsPage.isDiagramPresent(), "Diagram is not present");
        softAssert.assertTrue(carinaChartsPage.isImageMainMenuPresent(), "Image is not present");
        softAssert.assertTrue(carinaChartsPage.isFruitsChartPresent(), "Fruit chart is not present");
        softAssert.assertTrue(carinaChartsPage.isChartViewPresent(), "View chart is not present");
        softAssert.assertTrue(carinaChartsPage.isCycleDiagramPresent(), "Cycle diagram is not present");

        softAssert.assertAll();

    }

    @Test()
    @MethodOwner(owner = "IgorB")
    @TestLabel(name = "test 9", value = {"mobile", "acceptance"})
    public void validationOnUiElementsPageTest() {
        SoftAssert softAssert = new SoftAssert();

        StartPageBase startPageBase = initPage(getDriver(), StartPageBase.class);
        Assert.assertTrue(startPageBase.isPageOpened(), "Start page isn't opened");
        LoginPageUiBase loginPageUiBase = startPageBase.clickNextBtn();
        CarinaHomePageBase carinaHomePage = loginPageUiBase.login();
        Assert.assertTrue(carinaHomePage.isPageOpened(), "Carina page isn't opened");
        CarinaUIElementsPageBase carinaUIElementsPageBase = carinaHomePage.navigateToUIElementsPage();
        Assert.assertTrue(carinaUIElementsPageBase.isPageOpened(), "UI Elements page is not opened");
        carinaUIElementsPageBase.typeText(TEXT);
        Assert.assertEquals(carinaUIElementsPageBase.getText(), TEXT, "Text was not typed");
        carinaUIElementsPageBase.typeEmail(EMAIL);
        Assert.assertEquals(carinaUIElementsPageBase.getEmail(), EMAIL, "Email was not typed");
        carinaUIElementsPageBase.typeDate(DATE);
        Assert.assertEquals(carinaUIElementsPageBase.getDate(), DATE, "Date was not typed");
        carinaUIElementsPageBase.swipeToSwitchBtn();
        carinaUIElementsPageBase.checkCopy();
        Assert.assertTrue(carinaUIElementsPageBase.isCopyChecked(), "Copy checkbox was not checked");
        carinaUIElementsPageBase.clickOnFemaleRadioButton();
        Assert.assertTrue(carinaUIElementsPageBase.isFemaleRadioButtonSelected(), "Female radio button was not selected!");
        carinaUIElementsPageBase.clickOnOtherRadioButton();
        Assert.assertTrue(carinaUIElementsPageBase.isOthersRadioButtonSelected(), "Others radio button was not selected!");
        softAssert.assertTrue(carinaUIElementsPageBase.isProgressBarPresent(), "Progress bar is not present");
        softAssert.assertTrue(carinaUIElementsPageBase.isSwitchBtnPresent(), "Switch button is not present");

        softAssert.assertAll();

    }

    @Test()
    @MethodOwner(owner = "IgorB")
    @TestLabel(name = "test 10", value = {"mobile", "acceptance"})
    public void validationAllUiElementsPageTest() {
        StartPageBase startPageBase = initPage(getDriver(), StartPageBase.class);
        Assert.assertTrue(startPageBase.isPageOpened(), "Start page isn't opened");
        LoginPageUiBase loginPageUiBase = startPageBase.clickNextBtn();
        CarinaHomePageBase carinaHomePage = loginPageUiBase.login();
        Assert.assertTrue(carinaHomePage.isPageOpened(), "Carina page isn't opened");
        ViewBurgerMenuPageBase viewBurgerMenuPageBase = carinaHomePage.openBurgerMenu();
        CarinaUIElementsPageBase carinaUIElementsPageBase = (CarinaUIElementsPageBase) viewBurgerMenuPageBase.openPageFromBurgerMenu(BurgerMenu.UI_ELEMENTS);
        Assert.assertTrue(carinaUIElementsPageBase.isPageOpened(), "UI Elements page isn't opened!");
        carinaUIElementsPageBase.registrationOnUIElementsPage();
        Assert.assertTrue(carinaUIElementsPageBase.isPageStillOpened(), "UI Elements page is not opened");
   }


    @Test()
    @MethodOwner(owner = "IgorB")
    @TestLabel(name = "test 11", value = {"mobile", "acceptance"})
    public void validationOnUiElementsOnMapPageTest() {
        SoftAssert softAssert = new SoftAssert();

        StartPageBase startPageBase = initPage(getDriver(), StartPageBase.class);
        Assert.assertTrue(startPageBase.isPageOpened(), "Start page isn't opened");
        LoginPageUiBase loginPageUiBase = startPageBase.clickNextBtn();
        CarinaHomePageBase carinaHomePage = loginPageUiBase.login();
        Assert.assertTrue(carinaHomePage.isPageOpened(), "Carina page isn't opened");
        ViewBurgerMenuPageBase viewBurgerMenuPageBase = carinaHomePage.openBurgerMenu();
        CarinaMapsPageBase carinaMapsPageBase = (CarinaMapsPageBase) viewBurgerMenuPageBase.openPageFromBurgerMenu(BurgerMenu.MAP);
        Assert.assertTrue(carinaMapsPageBase.isPageOpened(), "Map page isn't opened!");
        softAssert.assertTrue(carinaMapsPageBase.isAnimationImagePresent(), "Animation image is not present");
        softAssert.assertTrue(carinaMapsPageBase.isNameMenuPresent(), "Name menu is not present");
        Assert.assertTrue(carinaMapsPageBase.isZoomInClickable(), "'Zoom in' is not clickable");
        Assert.assertTrue(carinaMapsPageBase.isZoomOutClickable(), "'Zoom out' is not clickable");

        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "IgorB")
    @TestLabel(name = "test 12", value = {"mobile", "acceptance"})
    public void validationOnWebViewPageTest() {
        SoftAssert softAssert = new SoftAssert();

        StartPageBase startPageBase = initPage(getDriver(), StartPageBase.class);
        Assert.assertTrue(startPageBase.isPageOpened(), "Start page isn't opened");
        LoginPageUiBase loginPageUiBase = startPageBase.clickNextBtn();
        CarinaHomePageBase carinaHomePage = loginPageUiBase.login();
        ViewBurgerMenuPageBase viewBurgerMenuPageBase = carinaHomePage.openBurgerMenu();
        CarinaWebViewPageBase carinaWebViewPageBase = (CarinaWebViewPageBase) viewBurgerMenuPageBase.openPageFromBurgerMenu(BurgerMenu.WEB_VIEW);
        Assert.assertTrue(carinaWebViewPageBase.isPageOpened(), "Web View page isn't opened!");
        softAssert.assertTrue(carinaWebViewPageBase.isBurgerMenuBtnPresent(), "Burger button isn't present");
        softAssert.assertTrue(carinaWebViewPageBase.isImageAnimationPresent(), "Image animation isn't present");
        softAssert.assertTrue(carinaWebViewPageBase.isNavigateBtnPresent(), "Navigation button isn't present");
        carinaWebViewPageBase.clickOnBurgerMenuBtn();
        carinaWebViewPageBase.swipeToReadOnGitHubBtn();
        Assert.assertTrue(carinaWebViewPageBase.isContactsPageOpened(), "Contacts page isn't opened");
        carinaWebViewPageBase.clickOnBurgerMenuBtn();
        carinaWebViewPageBase.swipeToReadOnGitHubBtn();
        softAssert.assertTrue(carinaWebViewPageBase.isReadOnGitHubBtnPresent(), "'Read on git hub' button isn't present");

        softAssert.assertAll();
    }
}