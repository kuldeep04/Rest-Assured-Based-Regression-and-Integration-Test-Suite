package integrationTest;

import dataProviders.TestDataProviders;
import org.inflectionIo.campaignService.CampaignService;
import org.testng.annotations.Test;

public class CampaignTest {

    private final CampaignService campaignService;

    public CampaignTest() {
        this.campaignService = new CampaignService();
    }

    @Test(dataProviderClass = TestDataProviders.class, dataProvider = "createCampaign")
    public void createCampaignTest() {

    }
}
