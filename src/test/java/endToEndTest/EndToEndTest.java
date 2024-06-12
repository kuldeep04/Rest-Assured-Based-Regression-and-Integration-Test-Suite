package endToEndTest;

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

    @Test
    public void endToEndTest() {

    }

}
