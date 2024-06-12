package integrationTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataProviders.TestDataProviders;
import io.restassured.response.Response;
import org.inflectionIo.campaignService.CampaignService;
import org.inflectionIo.models.campaign.ErrorResponse;
import org.inflectionIo.models.campaign.ResponseStatus;
import org.inflectionIo.models.campaign.ResponseWrapperCampaignResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.inflectionIo.utils.TestUtils.getDateAndTime;

public class CampaignTest {

    private final CampaignService campaignService;
    private final ObjectMapper mapper;

    public CampaignTest() {
        this.campaignService = new CampaignService();
        this.mapper = new ObjectMapper();
    }

    /*Test case to create campaign with valid test data */
    @Test(dataProviderClass = TestDataProviders.class, dataProvider = "createCampaignValidData")
    public void createCampaignWithValidTestData(String campaignName, String emailTempId, String recipientListId, LocalDateTime dateTime) throws JsonProcessingException {
        Response response = campaignService.createCampaign(campaignName, emailTempId, recipientListId,
                getDateAndTime(dateTime));
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(response.getBody().asString(), ResponseWrapperCampaignResponse.class);
        response.getBody().print();
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertNotNull(responseWrapperCampaignResponse);
        Assert.assertNotNull(responseWrapperCampaignResponse.getData());
        Assert.assertEquals(responseWrapperCampaignResponse.getMeta().getStatus(), String.valueOf(ResponseStatus.SUCCESS));
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getCampaignName(), campaignName);
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getRecipientListId(), recipientListId);
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getEmailTemplateId(), emailTempId);
        Assert.assertNotNull(responseWrapperCampaignResponse.getData().getId());
        Assert.assertNotNull(responseWrapperCampaignResponse.getData().getScheduledTime());
    }

    /*Test case to create campaign when campaign name is blank */
    @Test(dataProviderClass = TestDataProviders.class, dataProvider = "createCampaignEmptyCampaignName")
    public void createCampaignEmptyCampaignName(String campaignName, String emailTempId, String recipientListId, LocalDateTime dateTime) throws JsonProcessingException {
        Response response = campaignService.createCampaign(campaignName, emailTempId, recipientListId,
                getDateAndTime(dateTime));
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(response.getBody().asString(), ResponseWrapperCampaignResponse.class);
        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertNotNull(responseWrapperCampaignResponse.getErrors());
        for (ErrorResponse errorResponse : responseWrapperCampaignResponse.getErrors()) {
            Assert.assertEquals(errorResponse.getErrorCode(), "BAS-E-002");
            Assert.assertEquals(errorResponse.getMessage(), "Input Validation Error");
            Assert.assertEquals(errorResponse.getDetail(), "campaignName: must not be blank");
        }
    }

    /*Test case to create campaign emailTemplateId is blank */
    @Test(dataProviderClass = TestDataProviders.class, dataProvider = "createCampaignEmptyEmailTempId")
    public void createCampaignEmptyEmailTempId(String campaignName, String emailTempId, String recipientListId, LocalDateTime dateTime) throws JsonProcessingException {
        Response response = campaignService.createCampaign(campaignName, emailTempId, recipientListId,
                getDateAndTime(dateTime));
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(response.getBody().asString(), ResponseWrapperCampaignResponse.class);
        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertNotNull(responseWrapperCampaignResponse.getErrors());
        for (ErrorResponse errorResponse : responseWrapperCampaignResponse.getErrors()) {
            Assert.assertEquals(errorResponse.getErrorCode(), "BAS-E-002");
            Assert.assertEquals(errorResponse.getMessage(), "Input Validation Error");
            Assert.assertEquals(errorResponse.getDetail(), "emailTemplateId: must not be blank");
        }
    }

    /*Test case to create campaign recipientListId is blank */
    @Test(dataProviderClass = TestDataProviders.class, dataProvider = "createCampaignEmptyRecipientId")
    public void createCampaignEmptyRecipientId(String campaignName, String emailTempId, String recipientListId, LocalDateTime dateTime) throws JsonProcessingException {
        Response response = campaignService.createCampaign(campaignName, emailTempId, recipientListId,
                getDateAndTime(dateTime));
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(response.getBody().asString(), ResponseWrapperCampaignResponse.class);
        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertNotNull(responseWrapperCampaignResponse.getErrors());
        for (ErrorResponse errorResponse : responseWrapperCampaignResponse.getErrors()) {
            Assert.assertEquals(errorResponse.getErrorCode(), "BAS-E-002");
            Assert.assertEquals(errorResponse.getMessage(), "Input Validation Error");
            Assert.assertEquals(errorResponse.getDetail(), "recipientListId: must not be blank");
        }
    }

    /*Test case to create campaign with invalid email template id */
    @Test(dataProviderClass = TestDataProviders.class, dataProvider = "createCampaignInvalidEmailTempId")
    public void createCampaignInvalidEmailTempId(String campaignName, String emailTempId, String recipientListId, LocalDateTime dateTime) throws JsonProcessingException {
        Response response = campaignService.createCampaign(campaignName, emailTempId, recipientListId,
                getDateAndTime(dateTime));
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(response.getBody().asString(), ResponseWrapperCampaignResponse.class);
        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertNotNull(responseWrapperCampaignResponse.getErrors());
        for (ErrorResponse errorResponse : responseWrapperCampaignResponse.getErrors()) {
            Assert.assertEquals(errorResponse.getErrorCode(), "CAM-E-002");
            Assert.assertEquals(errorResponse.getMessage(), "Email Template Not Found");
        }
    }

    /*Test case to create campaign with invalid createCampaignInvalidRecipient id */
    @Test(dataProviderClass = TestDataProviders.class, dataProvider = "createCampaignInvalidRecipientId")
    public void createCampaignInvalidRecipientId(String campaignName, String emailTempId, String recipientListId, LocalDateTime dateTime) throws JsonProcessingException {
        Response response = campaignService.createCampaign(campaignName, emailTempId, recipientListId,
                getDateAndTime(dateTime));
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(response.getBody().asString(), ResponseWrapperCampaignResponse.class);
        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertNotNull(responseWrapperCampaignResponse.getErrors());
        for (ErrorResponse errorResponse : responseWrapperCampaignResponse.getErrors()) {
            Assert.assertEquals(errorResponse.getErrorCode(), "CAM-E-003");
            Assert.assertEquals(errorResponse.getMessage(), "Recipient List Not Found");
        }
    }

    /*Test case to create campaign when scheduled date is given null in request*/
    @Test(dataProviderClass = TestDataProviders.class, dataProvider = "createCampaignWithNullDate")
    public void createCampaignWithNullDate(String campaignName, String emailTempId, String recipientListId, LocalDateTime dateTime) throws JsonProcessingException {
        Response response = campaignService.createCampaign(campaignName, emailTempId, recipientListId,
                getDateAndTime(dateTime));
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(response.getBody().asString(), ResponseWrapperCampaignResponse.class);
        Assert.assertEquals(response.getStatusCode(), 400, "Test case failing:: user should not able to create campaign with null date");
        Assert.assertNotNull(responseWrapperCampaignResponse.getErrors());
    }

    /*Test case to create campaign when scheduled date is given null in request*/
    @Test(dataProviderClass = TestDataProviders.class, dataProvider = "createCampaignWithPreviousDate")
    public void createCampaignWithPreviousDate(String campaignName, String emailTempId, String recipientListId, LocalDateTime dateTime) throws JsonProcessingException {
        Response response = campaignService.createCampaign(campaignName, emailTempId, recipientListId,
                getDateAndTime(dateTime));
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(response.getBody().asString(), ResponseWrapperCampaignResponse.class);
        Assert.assertEquals(response.getStatusCode(), 400, "Test case is failing:: User should not be able to create campaign of previous date");
        Assert.assertNotNull(responseWrapperCampaignResponse.getErrors());
    }

    /*Test case to create campaign when campaign name is already used in request*/
    @Test(dataProviderClass = TestDataProviders.class, dataProvider = "createCampaignForSameName")
    public void createCampaignForSameName(String campaignName, String emailTempId, String recipientListId, LocalDateTime dateTime) throws JsonProcessingException {
        Response response = campaignService.createCampaign(campaignName, emailTempId, recipientListId,
                getDateAndTime(dateTime));
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(response.getBody().asString(), ResponseWrapperCampaignResponse.class);
        Assert.assertEquals(response.getStatusCode(), 409);
        Assert.assertNotNull(responseWrapperCampaignResponse.getErrors());
        for (ErrorResponse errorResponse : responseWrapperCampaignResponse.getErrors()) {
            Assert.assertEquals(errorResponse.getErrorCode(), "CAM-E-004");
            Assert.assertEquals(errorResponse.getMessage(), "Campaign Name must be unique");
        }
    }

    /*Update campaign name*/
    @Test(dataProviderClass = TestDataProviders.class, dataProvider = "updateCampaignName")
    public void updateCampaignNameTest(String campaignName, String campaignId) throws JsonProcessingException {
        Response response = campaignService.updateCampaignName(campaignName, campaignId);
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(response.getBody().asString(), ResponseWrapperCampaignResponse.class);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(responseWrapperCampaignResponse.getData());
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getCampaignName(), campaignName);
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getId(), campaignId);
        Assert.assertNotNull(responseWrapperCampaignResponse.getData().getEmailTemplateId());
        Assert.assertNotNull(responseWrapperCampaignResponse.getData().getRecipientListId());

    }

    /*Get Campaign details test*/
    @Test(dataProviderClass = TestDataProviders.class, dataProvider = "getCampaignDetailsTest")
    public void getCampaignDetailsTest(String campaignName, String campaignId) throws JsonProcessingException {
        Response response = campaignService.getCampaignById(campaignId);
        Assert.assertEquals(response.getStatusCode(), 200);
        ResponseWrapperCampaignResponse responseWrapperCampaignResponse = mapper.readValue(response.getBody().asString(), ResponseWrapperCampaignResponse.class);
        Assert.assertNotNull(responseWrapperCampaignResponse);
        Assert.assertNotNull(responseWrapperCampaignResponse.getData());
        Assert.assertEquals(responseWrapperCampaignResponse.getMeta().getStatus(), String.valueOf(ResponseStatus.SUCCESS));
        Assert.assertEquals(responseWrapperCampaignResponse.getData().getCampaignName(), campaignName);
        Assert.assertNotNull(responseWrapperCampaignResponse.getData().getRecipientListId());
        Assert.assertNotNull(responseWrapperCampaignResponse.getData().getEmailTemplateId());
        Assert.assertNotNull(responseWrapperCampaignResponse.getData().getId());
        Assert.assertNotNull(responseWrapperCampaignResponse.getData().getScheduledTime());
    }
}
