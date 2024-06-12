package integrationTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataProviders.TestDataProviders;
import io.restassured.response.Response;
import org.inflectionIo.RecipientService.RecipientService;
import org.inflectionIo.models.Recipient.RecipientListResponse;
import org.inflectionIo.models.Recipient.RecipientResponse;
import org.inflectionIo.models.Recipient.ResponseWrapperListRecipientListResponse;
import org.inflectionIo.models.Recipient.ResponseWrapperRecipientListResponse;
import org.inflectionIo.models.campaign.ErrorResponse;
import org.inflectionIo.models.campaign.ResponseStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RecipientsListTest {

    private final RecipientService recipientService;
    private final ObjectMapper mapper;

    public RecipientsListTest() {
        this.recipientService = new RecipientService();
        this.mapper = new ObjectMapper();
    }

    /*Validate recipient Lists*/

    @Test
    public void testRecipientLists() throws JsonProcessingException {
       Response response =  recipientService.getListOfRecipients();
       ResponseWrapperListRecipientListResponse responseWrapperListRecipientListResponse = mapper.readValue(response.getBody().asString(),
               ResponseWrapperListRecipientListResponse.class);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(responseWrapperListRecipientListResponse.getData());
        Assert.assertEquals(responseWrapperListRecipientListResponse.getMeta().getStatus(), String.valueOf(ResponseStatus.SUCCESS));
        for(RecipientListResponse recipientListResponse : responseWrapperListRecipientListResponse.getData()){
            Assert.assertNotNull(recipientListResponse.getId());
            Assert.assertNotNull(recipientListResponse.getName());
            for(RecipientResponse recipientResponse: recipientListResponse.getRecipients()){
                Assert.assertNotNull(recipientResponse.getId());
                Assert.assertNotNull(recipientResponse.getEmail());
            }
        }
    }

    /*Validate recipient Lists with valid ids*/

    @Test(dataProvider = "recipientList", dataProviderClass = TestDataProviders.class)
    public void testRecipientLists(String id) throws JsonProcessingException {
        Response response =  recipientService.getListOfRecipientsById(id);
        ResponseWrapperRecipientListResponse responseWrapperListRecipientListResponse = mapper.readValue(response.getBody().asString(),
                ResponseWrapperRecipientListResponse.class);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(responseWrapperListRecipientListResponse.getData());
        Assert.assertEquals(responseWrapperListRecipientListResponse.getMeta().getStatus(), String.valueOf(ResponseStatus.SUCCESS));
        RecipientListResponse recipientListResponse = responseWrapperListRecipientListResponse.getData();
        Assert.assertNotNull(recipientListResponse.getId());
        Assert.assertNotNull(recipientListResponse.getName());
        Assert.assertNotNull(recipientListResponse.getRecipients());
        for(RecipientResponse recipientResponse: recipientListResponse.getRecipients()){
            Assert.assertNotNull(recipientResponse.getId());
            Assert.assertNotNull(recipientResponse.getEmail());
        }
    }

    /*Validate recipient Lists with in valid ids*/

    @Test(dataProvider = "recipientInvalidId", dataProviderClass = TestDataProviders.class)
    public void testRecipientInvalidId(String id) throws JsonProcessingException {
        Response response =  recipientService.getListOfRecipientsById(id);
        ResponseWrapperRecipientListResponse responseWrapperListRecipientListResponse = mapper.readValue(response.getBody().asString(),
                ResponseWrapperRecipientListResponse.class);
        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertEquals(responseWrapperListRecipientListResponse.getMeta().getStatus(), String.valueOf(ResponseStatus.FAILURE));
        List<ErrorResponse> errorResponses = responseWrapperListRecipientListResponse.getErrors();
        for(ErrorResponse errorResponse: errorResponses){
            Assert.assertEquals(errorResponse.getErrorCode(), "RLS-E-001");
            Assert.assertNotNull(errorResponse.getMessage(), "Recipient list not found");
        }
    }

}
