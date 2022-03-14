package com.qaprosoft.carina.igor.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.igor.common.*;
import com.qaprosoft.carina.igor.utils.BurgerMenu;
import com.qaprosoft.carina.igor.utils.TimeConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CarinaHomePageBase.class)
public class CarinaHomePage extends CarinaHomePageBase implements TimeConstants {

    public CarinaHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "content_frame")
    private ExtendedWebElement webViewContent;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement navigateBtn;

    @FindBy(xpath = "//android.view.View[@text = 'CARINA facts']")
    private ExtendedWebElement carinaFactsSubTitle;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text = 'Web View']")
    private ExtendedWebElement webViewLink;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text = 'Charts']")
    private ExtendedWebElement chartsLink;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text = 'Map']")
    private ExtendedWebElement mapLink;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text = 'UI elements']")
    private ExtendedWebElement uiElementsLink;

    @FindBy(className = "android.widget.ImageButton")
    private ExtendedWebElement leftMenuButton;

    @Override
    public CarinaWebViewPageBase navigateToWebViewPage() {
        leftMenuButton.click();
        webViewLink.click();
        return initPage(getDriver(), CarinaWebViewPageBase.class);
    }

    @Override
    public CarinaChartsPageBase navigateToChartsPage() {
        leftMenuButton.click();
        chartsLink.click();
        return initPage(getDriver(), CarinaChartsPageBase.class);
    }

    @Override
    public CarinaMapsPageBase navigateToMapPage() {
        leftMenuButton.click();
        mapLink.click();
        return initPage(getDriver(), CarinaMapsPageBase.class);
    }

    @Override
    public CarinaUIElementsPageBase navigateToUIElementsPage() {
        leftMenuButton.click();
        uiElementsLink.click();
        return initPage(getDriver(), CarinaUIElementsPageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return waitUntil(ExpectedConditions.visibilityOf(webViewContent.getElement()), TWENTY_TIMEOUT);
    }

    @Override
    public String isEnumElementPresent() {
        return webViewLink.getText();
    }

    @Override
    public CarinaWebViewPageBase navigateToUserPage() {
        leftMenuButton.click();
        return initPage(getDriver(), CarinaWebViewPageBase.class);
    }

    @Override
    public ViewBurgerMenuPageBase openBurgerMenu() {
        navigateBtn.click(ONE_SECOND);
        return initPage(getDriver(), ViewBurgerMenuPageBase.class);
    }
}

