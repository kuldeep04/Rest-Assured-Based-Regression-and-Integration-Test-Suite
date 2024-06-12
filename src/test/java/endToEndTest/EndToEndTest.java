package endToEndTest;

import dataProviders.EndToEndDataProvider;
import io.restassured.response.Response;
import org.inflectionIo.RecipientService.RecipientService;
import org.inflectionIo.campaignService.CampaignService;
import org.inflectionIo.emailTemplateService.EmailTemplateService;
import org.testng.annotations.Test;

public class EndToEndTest {

    private final CampaignService campaignService;
    private final EmailTemplateService emailTemplateService;
    private final RecipientService recipientService;

    public EndToEndTest() {
        this.campaignService = new CampaignService();
        this.emailTemplateService = new EmailTemplateService();
        this.recipientService = new RecipientService();
    }

    @Test(dataProvider = "endToEndData", dataProviderClass = EndToEndDataProvider.class)
    public void endToEndTest(String campaignName, Integer scheduledId) {
        Response emailTemplateResponse = emailTemplateService.getEmailTemplates();
        Response recipientsResponse = recipientService.getListOfRecipients();
        Response campaignServiceResponse = campaignService.createCampaign(campaignName, "", "", scheduledId);
    }

}
