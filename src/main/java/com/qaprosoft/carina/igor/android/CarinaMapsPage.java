package com.qaprosoft.carina.igor.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.igor.common.CarinaMapsPageBase;
import com.qaprosoft.carina.igor.common.ViewBurgerMenuPageBase;
import com.qaprosoft.carina.igor.utils.TimeConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CarinaMapsPageBase.class)
public class CarinaMapsPage extends CarinaMapsPageBase implements TimeConstants {

    public CarinaMapsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement navigateBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Map']")
    private ExtendedWebElement nameMenu;

    @FindBy(id = "com.solvd.carinademoapplication:id/image_view")
    private ExtendedWebElement animationImage;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Zoom in']")
    private ExtendedWebElement zoomIn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Zoom out']")
    private ExtendedWebElement zoomOut;

    @Override
    public boolean isNavigateBtnPresent() {
        return navigateBtn.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isNameMenuPresent() {
        return nameMenu.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isAnimationImagePresent() {
        return animationImage.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isZoomInClickable() {
        return zoomIn.isClickable(THREE_SECONDS);
    }

    @Override
    public boolean isZoomOutClickable() {
        return zoomOut.isClickable(THREE_SECONDS);
    }

    @Override
    public boolean isPageOpened() {
        return waitUntil(ExpectedConditions.visibilityOf(animationImage.getElement()), TWENTY_TIMEOUT);
    }

    @Override
    public ViewBurgerMenuPageBase openBurgerMenu() {
        navigateBtn.click(ONE_SECOND);
        return initPage(getDriver(), ViewBurgerMenuPageBase.class);
    }
}
