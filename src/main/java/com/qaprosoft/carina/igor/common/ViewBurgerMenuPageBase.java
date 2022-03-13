package com.qaprosoft.carina.igor.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.igor.utils.BurgerMenu;
import com.qaprosoft.carina.igor.utils.TimeConstants;
import org.openqa.selenium.WebDriver;

public abstract class ViewBurgerMenuPageBase extends AbstractPage implements TimeConstants {

    public ViewBurgerMenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isBurgerMenuPresent(BurgerMenu page);

    public abstract AbstractPage openPageFromBurgerMenu(BurgerMenu page);

    public abstract boolean isPageOpened();
}
