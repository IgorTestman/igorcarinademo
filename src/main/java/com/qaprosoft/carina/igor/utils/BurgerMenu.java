package com.qaprosoft.carina.igor.utils;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.igor.common.CarinaChartsPageBase;
import com.qaprosoft.carina.igor.common.CarinaMapsPageBase;
import com.qaprosoft.carina.igor.common.CarinaUIElementsPageBase;
import com.qaprosoft.carina.igor.common.CarinaWebViewPageBase;

public enum BurgerMenu {
    WEB_VIEW("Web View", CarinaWebViewPageBase.class),
    CHARTS("Charts", CarinaChartsPageBase.class),
    MAP("Map", CarinaMapsPageBase.class),
    UI_ELEMENTS("UI elements", CarinaUIElementsPageBase.class);

    private String name;
    private Class<? extends AbstractPage> pageClass;

    BurgerMenu(String name, Class<? extends AbstractPage> pageClass) {
        this.name = name;
        this.pageClass = pageClass;
    }

    public String getName() {
        return name;
    }

    public Class<? extends AbstractPage> getPageClass() {
        return this.pageClass;
    }
}