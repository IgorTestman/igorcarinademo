package com.qaprosoft.carina.igor.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.igor.common.CarinaUIElementsPageBase;
import com.qaprosoft.carina.igor.common.ViewBurgerMenuPageBase;
import com.qaprosoft.carina.igor.utils.TimeConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CarinaUIElementsPageBase.class)
public class CarinaUIElementsPage extends CarinaUIElementsPageBase implements TimeConstants, IMobileUtils {

    @FindBy(id = "editText")
    private ExtendedWebElement textField;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement navigateBtn;

    @FindBy(id = "editText2")
    private ExtendedWebElement emailField;

    @FindBy(id = "editText3")
    private ExtendedWebElement dateField;

    @FindBy(id = "checkBox2")
    private ExtendedWebElement checkBoxButton;

    @FindBy(id = "com.solvd.carinademoapplication:id/radioButton")
    private ExtendedWebElement maleRadioButton;

    @FindBy(id = "com.solvd.carinademoapplication:id/radioButton3")
    private ExtendedWebElement femaleRadioButton;

    @FindBy(id = "com.solvd.carinademoapplication:id/radioButton5")
    private ExtendedWebElement otherRadioButton;

    @FindBy(id = "radioButton5")
    private ExtendedWebElement seekBarRadioButton;

    @FindBy(xpath = "//android.widget.ScrollView[@index='0']")
    private ExtendedWebElement container;

    @FindBy(id = "com.solvd.carinademoapplication:id/progressBar2")
    private ExtendedWebElement progressBar;

    @FindBy(id = "com.solvd.carinademoapplication:id/switch1")
    private ExtendedWebElement switchBtn;

    public CarinaUIElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeText(String text) {
        textField.type(text);
    }

    @Override
    public void typeEmail(String email) {
        emailField.type(email);
    }

    @Override
    public String getEmail() {
        return emailField.getText();
    }

    @Override
    public String getText() {
        return textField.getText();
    }

    @Override
    public String getDate() {
        return dateField.getText();
    }

    @Override
    public void typeDate(String date) {
        dateField.type(date);
    }

    @Override
    public void clickOnMaleRadioButton() {
        maleRadioButton.click();
    }

    @Override
    public void clickOnFemaleRadioButton() {
        femaleRadioButton.click();
    }

    @Override
    public void clickOnOtherRadioButton() {
        otherRadioButton.click();
    }

    @Override
    public boolean isFemaleRadioButtonSelected() {
        return femaleRadioButton.isChecked();
    }

    @Override
    public boolean isOthersRadioButtonSelected() {
        return otherRadioButton.isChecked();
    }

    @Override
    public void checkCopy() {
        checkBoxButton.click();
    }

    @Override
    public boolean isProgressBarPresent() {
        return progressBar.isElementPresent(THREE_SECONDS);
    }

    @Override
    public void clickOnProgressbar() {
        progressBar.click();
    }

    @Override
    public boolean isSwitchBtnPresent() {
        return switchBtn.isElementPresent(THREE_SECONDS);
    }

    @Override
    public void clickOnSwitchBtn() {
        switchBtn.click();
    }

    @Override
    public boolean isCopyChecked() {
        return checkBoxButton.isChecked();
    }

    @Override
    public void swipeToSwitchBtn() {
        swipe(switchBtn, container, 10);
    }

    @Override
    public boolean isFemaleRadioBtnPresent() {
        return femaleRadioButton.isElementPresent(THREE_SECONDS);
    }

    @Override
    public void registrationOnUIElementsPage() {
        String text = "Ukraine";
        String email = "ukraine@isfree.com";
        String date = "02/24/2021";
        typeText(text);
        typeEmail(email);
        typeDate(date);
        swipe(switchBtn, container, 10);
        checkCopy();
        clickOnFemaleRadioButton();
        clickOnProgressbar();
        clickOnFemaleRadioButton();
        clickOnSwitchBtn();
    }

    @Override
    public boolean isTextFieldPresent() {
        return textField.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isPageOpened() {
        return isTextFieldPresent();
    }

    @Override
    public boolean isPageStillOpened() {
        return isSwitchBtnPresent() && isProgressBarPresent();
    }

    @Override
    public ViewBurgerMenuPageBase openBurgerMenu() {
        navigateBtn.click(ONE_SECOND);
        return initPage(getDriver(), ViewBurgerMenuPageBase.class);
    }
}
