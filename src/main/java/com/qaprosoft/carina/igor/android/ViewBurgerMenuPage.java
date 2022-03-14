package com.qaprosoft.carina.igor.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.igor.common.ViewBurgerMenuPageBase;
import com.qaprosoft.carina.igor.utils.TimeConstants;
import com.qaprosoft.carina.igor.utils.BurgerMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ViewBurgerMenuPageBase.class)
public class ViewBurgerMenuPage extends ViewBurgerMenuPageBase implements TimeConstants {

    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout")
    private ExtendedWebElement userProfile;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement navigateBtn;

    @FindBy(xpath = "//*[@class = 'android.widget.CheckedTextView'][@text = '%s']")
    private ExtendedWebElement nameMenuBtn;

    @FindBy(id = "com.solvd.carinademoapplication:id/design_navigation_view")
    private ExtendedWebElement navigationView;

    public ViewBurgerMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return navigationView.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isBurgerMenuPresent(BurgerMenu page) {
        return nameMenuBtn.format(page.getName()).isElementPresent(ONE_SECOND);
    }

    @Override
    public AbstractPage openPageFromBurgerMenu (BurgerMenu page) {
        nameMenuBtn.format(page.getName()).click(THREE_SECONDS);
        return initPage(getDriver(), page.getPageClass());
    }
}

