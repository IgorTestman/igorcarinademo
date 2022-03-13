package com.qaprosoft.carina.igor.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.igor.common.CarinaChartsPageBase;
import com.qaprosoft.carina.igor.common.ViewBurgerMenuPageBase;
import com.qaprosoft.carina.igor.utils.TimeConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CarinaChartsPageBase.class)
public class CarinaChartsPage extends CarinaChartsPageBase implements IMobileUtils, TimeConstants {

    public CarinaChartsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.solvd.carinademoapplication:id/image_view")
    private ExtendedWebElement imageMainMenu;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement navigateBtn;

    @FindBy(id = "com.solvd.carinademoapplication:id/fragmentFruitChart")
    private ExtendedWebElement chartsFruitsDiagram;

    @FindBy(id = "com.solvd.carinademoapplication:id/fragmentVennDiagram")
    private ExtendedWebElement chartsFruitsChart;

    @FindBy(id = "com.solvd.carinademoapplication:id/chartView")
    private ExtendedWebElement chartView;

    @FindBy(xpath = "//*[@resource-id='ac_chart_2']")
    private ExtendedWebElement cycleDiagram;

    @FindBy(xpath = "//*[@resource-id='ac_rect_z']")
    private ExtendedWebElement temperatureChart;

    @FindBy(xpath = "//*[@resource-id='container']")
    private ExtendedWebElement container;

    @Override
    public boolean isDiagramPresent() {
        return chartsFruitsDiagram.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isImageMainMenuPresent() {
        return imageMainMenu.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isFruitsChartPresent() {
        return chartsFruitsChart.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isChartViewPresent() {
        return chartView.isElementPresent(THREE_SECONDS);
    }

    @Override
    public void isChartViewClickable() {
        chartView.click();
    }

    @Override
    public boolean isCycleDiagramPresent() {
        return swipe(cycleDiagram, Direction.DOWN, FIVE_SWIPES, SLOW_SWIPES);
    }

    @Override
    public boolean isTemperatureChartPresent() {
        return swipe(temperatureChart, Direction.DOWN, FIVE_SWIPES, SLOW_SWIPES);
    }

    @Override
    public boolean isPageOpened() {
        return chartsFruitsDiagram.isElementPresent(THREE_SECONDS);
    }

    @Override
    public ViewBurgerMenuPageBase openBurgerMenu() {
        navigateBtn.click(ONE_SECOND);
        return initPage(getDriver(), ViewBurgerMenuPageBase.class);
    }
}



