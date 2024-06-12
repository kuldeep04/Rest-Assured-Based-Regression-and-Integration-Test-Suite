package dataProviders;

import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class EndToEndDataProvider {

    @DataProvider(name = "endToEndData")
    public static Object[][] endToEndData() {
        return new Object[][]{{"EM-002452"}};
    }
}
