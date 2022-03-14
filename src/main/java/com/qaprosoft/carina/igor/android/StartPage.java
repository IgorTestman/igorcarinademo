package com.qaprosoft.carina.igor.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.igor.common.LoginPageUiBase;
import com.qaprosoft.carina.igor.common.StartPageBase;
import com.qaprosoft.carina.igor.utils.TimeConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = StartPageBase.class)
public class StartPage extends StartPageBase implements TimeConstants {

    @FindBy(id = "com.solvd.carinademoapplication:id/carina_logo")
    private ExtendedWebElement carinaLogo;

    @FindBy(id = "com.solvd.carinademoapplication:id/next_button")
    private ExtendedWebElement nextBtn;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCarinaLogoPresent() {
        return carinaLogo.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isNextBtnPresent() {
        return nextBtn.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isPageOpened() {
        return waitUntil(ExpectedConditions.visibilityOf(nextBtn.getElement()), TWENTY_TIMEOUT);
    }

    @Override
    public LoginPageUiBase clickNextBtn() {
        nextBtn.click(THREE_SECONDS);
        return initPage(getDriver(), LoginPageUiBase.class);
    }

    @Override
    public String getNextBtnText() {
        return nextBtn.getText();
    }
}
