package endToEndTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataProviders.EndToEndDataProvider;
import io.restassured.response.Response;
import org.inflectionIo.RecipientService.RecipientService;
import org.inflectionIo.campaignService.CampaignService;
import org.inflectionIo.emailTemplateService.EmailTemplateService;
import org.inflectionIo.models.EmailTemplate.EmailTemplateResponse;
import org.inflectionIo.models.EmailTemplate.ResponseWrapperListEmailTemplateResponse;
import org.inflectionIo.models.Recipient.RecipientListResponse;
import org.inflectionIo.models.Recipient.ResponseWrapperListRecipientListResponse;
import org.inflectionIo.models.campaign.ResponseStatus;
import org.inflectionIo.models.campaign.ResponseWrapperCampaignResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Random;

import static org.inflectionIo.utils.TestUtils.getDateAndTime;

public class EndToEndTest {

    private final CampaignService campaignService;
    private final EmailTemplateService emailTemplateService;
    private final RecipientService recipientService;
    private final ObjectMapper mapper;

    public EndToEndTest() {
        this.campaignService = new CampaignService();
        this.emailTemplateService = new EmailTemplateService();
        this.recipientService = new RecipientService();
        this.mapper = new ObjectMapper();
    }

    /*Create campaign with scheduled time*/

    @Test(dataProvider = "endToEndData", dataProviderClass = EndToEndDataProvider.class)
    public void endToEndTestWithScheduledTime(String campaignName, LocalDateTime scheduleDate) throws JsonProcessingException {
        String emailTempId = "";
        String recipientListId = "";
        Response emailTemplateResponse = emailTemplateService.getEmailTemplates();
        ResponseWrapperListEmailTemplateResponse emailTemplates = mapper.readValue(emailTemplateResponse.getBody().asString(),
                ResponseWrapperListEmailTemplateResponse.class);
        for(EmailTemplateResponse emailTemplate: emailTemplates.getData()){
            emailTempId  = emailTemplate.getId();
            if(emailTempId != null){
                break;
            }
        }
        Response recipientsResponse = recipientService.getListOfRecipients();
        ResponseWrapperListRecipientListResponse recipientResponse  = mapper.readValue(recipientsResponse.getBody().asString(),
                ResponseWrapperListRecipientListResponse.class);

        for(RecipientListResponse response : recipientResponse.getData()){
            recipientListId =  response.getId();
            if(recipientListId != null){
                break;
            }
        }

        Response campaignServiceResponse = campaignService.createCampaign(campaignName, emailTempId, recipientListId, getDateAndTime(scheduleDate));
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(campaignServiceResponse.getBody().asString(), ResponseWrapperCampaignResponse.class);

        Assert.assertEquals(campaignServiceResponse.getStatusCode(), 201);
        Assert.assertNotNull(responseWrapperCampaignResponse);
        Assert.assertNotNull(responseWrapperCampaignResponse.getData());
        Assert.assertEquals(responseWrapperCampaignResponse.getMeta().getStatus(), String.valueOf(ResponseStatus.SUCCESS));
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getCampaignName(), campaignName);
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getRecipientListId(), recipientListId);
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getEmailTemplateId(), emailTempId);
        Assert.assertNotNull(responseWrapperCampaignResponse.getData().getId());
        Assert.assertNotNull(responseWrapperCampaignResponse.getData().getScheduledTime());
    }

    /*End to End for Selected recipient*/

    @Test(dataProvider = "endToEndTestForSelectedRecipient", dataProviderClass = EndToEndDataProvider.class)
    public void endToEndTestForSelectedRecipient(String campaignName, LocalDateTime scheduleDate, String selectedRecipientId) throws JsonProcessingException {
        String emailTempId = "";
        String recipientListId = "";
        Response emailTemplateResponse = emailTemplateService.getEmailTemplates();
        ResponseWrapperListEmailTemplateResponse emailTemplates = mapper.readValue(emailTemplateResponse.getBody().asString(),
                ResponseWrapperListEmailTemplateResponse.class);
        for(EmailTemplateResponse emailTemplate: emailTemplates.getData()){
            emailTempId  = emailTemplate.getId();
            if(emailTempId != null){
                break;
            }
        }
        Response recipientsResponse = recipientService.getListOfRecipients();
        ResponseWrapperListRecipientListResponse recipientResponse  = mapper.readValue(recipientsResponse.getBody().asString(),
                ResponseWrapperListRecipientListResponse.class);

        for(RecipientListResponse response : recipientResponse.getData()){
            recipientListId =  response.getId();
            if(recipientListId.equals(selectedRecipientId)){
                break;
            }
        }

        Response campaignServiceResponse = campaignService.createCampaign(campaignName, emailTempId, recipientListId, getDateAndTime(scheduleDate));
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(campaignServiceResponse.getBody().asString(), ResponseWrapperCampaignResponse.class);

        Assert.assertEquals(campaignServiceResponse.getStatusCode(), 201);
        Assert.assertNotNull(responseWrapperCampaignResponse);
        Assert.assertNotNull(responseWrapperCampaignResponse.getData());
        Assert.assertEquals(responseWrapperCampaignResponse.getMeta().getStatus(), String.valueOf(ResponseStatus.SUCCESS));
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getCampaignName(), campaignName);
        /*Selected recipient is getting validated into the response*/
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getRecipientListId(), selectedRecipientId);
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getEmailTemplateId(), emailTempId);
        Assert.assertNotNull(responseWrapperCampaignResponse.getData().getId());
        Assert.assertNotNull(responseWrapperCampaignResponse.getData().getScheduledTime());
    }

    /*End to End for Selected email template*/

    @Test(dataProvider = "endToEndTestForSelectedEmailTemplate", dataProviderClass = EndToEndDataProvider.class)
    public void endToEndTestForSelectedEmailTemplate(String campaignName, LocalDateTime scheduleDate, String selectedEmailTemplate) throws JsonProcessingException {
        String emailTempId = "";
        String recipientListId = "";
        Response emailTemplateResponse = emailTemplateService.getEmailTemplates();
        ResponseWrapperListEmailTemplateResponse emailTemplates = mapper.readValue(emailTemplateResponse.getBody().asString(),
                ResponseWrapperListEmailTemplateResponse.class);
        for(EmailTemplateResponse emailTemplate: emailTemplates.getData()){
            emailTempId  = emailTemplate.getId();
            if(emailTempId.equals(selectedEmailTemplate)){
                break;
            }
        }
        Response recipientsResponse = recipientService.getListOfRecipients();
        ResponseWrapperListRecipientListResponse recipientResponse  = mapper.readValue(recipientsResponse.getBody().asString(),
                ResponseWrapperListRecipientListResponse.class);

        for(RecipientListResponse response : recipientResponse.getData()){
            recipientListId =  response.getId();
            if(recipientListId != null){
                break;
            }
        }

        Response campaignServiceResponse = campaignService.createCampaign(campaignName, emailTempId, recipientListId, getDateAndTime(scheduleDate));
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(campaignServiceResponse.getBody().asString(), ResponseWrapperCampaignResponse.class);

        Assert.assertEquals(campaignServiceResponse.getStatusCode(), 201);
        Assert.assertNotNull(responseWrapperCampaignResponse);
        Assert.assertNotNull(responseWrapperCampaignResponse.getData());
        Assert.assertEquals(responseWrapperCampaignResponse.getMeta().getStatus(), String.valueOf(ResponseStatus.SUCCESS));
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getCampaignName(), campaignName);
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getRecipientListId(), recipientListId);
        /*Selected email template is getting validated into the response*/
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getEmailTemplateId(), selectedEmailTemplate);
        Assert.assertNotNull(responseWrapperCampaignResponse.getData().getId());
        Assert.assertNotNull(responseWrapperCampaignResponse.getData().getScheduledTime());
    }

    /*End to End for edit name*/

    @Test(dataProvider = "endToEndTestEditName", dataProviderClass = EndToEndDataProvider.class)
    public void endToEndTestEditName(String campaignName, LocalDateTime scheduleDate) throws JsonProcessingException {
        String emailTempId = "";
        String recipientListId = "";
        Response emailTemplateResponse = emailTemplateService.getEmailTemplates();
        ResponseWrapperListEmailTemplateResponse emailTemplates = mapper.readValue(emailTemplateResponse.getBody().asString(),
                ResponseWrapperListEmailTemplateResponse.class);
        for(EmailTemplateResponse emailTemplate: emailTemplates.getData()){
            emailTempId  = emailTemplate.getId();
            if(emailTempId != null){
                break;
            }
        }
        Response recipientsResponse = recipientService.getListOfRecipients();
        ResponseWrapperListRecipientListResponse recipientResponse  = mapper.readValue(recipientsResponse.getBody().asString(),
                ResponseWrapperListRecipientListResponse.class);

        for(RecipientListResponse response : recipientResponse.getData()){
            recipientListId =  response.getId();
            if(recipientListId != null){
                break;
            }
        }

        Response campaignServiceResponse = campaignService.createCampaign(campaignName, emailTempId, recipientListId, getDateAndTime(scheduleDate));
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(campaignServiceResponse.getBody().asString(), ResponseWrapperCampaignResponse.class);
        String campaignId = responseWrapperCampaignResponse.getData().getId();
        String latestName = "campaignName-"+ new Random().nextInt(100);
        Response response = campaignService.updateCampaignName(latestName, campaignId);
        ResponseWrapperCampaignResponse updateResponse = mapper.readValue(response.getBody().asString(), ResponseWrapperCampaignResponse.class);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(updateResponse.getData());
        Assert.assertEquals(updateResponse.getData().getCampaignName(), latestName);
        Assert.assertEquals(updateResponse.getData().getId(), campaignId);
        Assert.assertNotNull(updateResponse.getData().getEmailTemplateId());
        Assert.assertNotNull(updateResponse.getData().getRecipientListId());
    }

}
