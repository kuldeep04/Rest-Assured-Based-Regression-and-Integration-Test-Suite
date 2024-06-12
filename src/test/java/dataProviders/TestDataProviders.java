package dataProviders;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

    @DataProvider(name = "emailTemplate")
    public static Object[][] emailTemplate() {
        return new Object[][]{{"EM-001"},{"EM-002"}, {"EM-003"}, {"EM-004"}, {"EM-005"}};
    }

    @DataProvider(name = "recipientList")
    public static Object[][] recipientList() {
        return new Object[][]{{"RL-001"},{"RL-002"}, {"RL-005"}};
    }

    @DataProvider(name = "createCampaign")
    public static Object[][] createCampaign() {
        return new Object[][]{{"RL-001"},{"RL-002"}, {"RL-005"}};
    }
}
