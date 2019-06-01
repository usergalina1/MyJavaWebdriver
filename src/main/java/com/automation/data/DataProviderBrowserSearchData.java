package com.automation.data;

import org.testng.annotations.DataProvider;

public class DataProviderBrowserSearchData {
    @DataProvider(name = "credentials")
    public Object[][] credentials() {
        return new Object[][]{
                {"testng"},
                {"dataProviders"},
                {"selenium"},
        };
    }
}
