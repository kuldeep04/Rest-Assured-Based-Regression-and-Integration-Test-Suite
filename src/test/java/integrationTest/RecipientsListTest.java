package integrationTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataProviders.TestDataProviders;
import io.restassured.response.Response;
import org.inflectionIo.RecipientService.RecipientService;
import org.inflectionIo.models.Recipient.ResponseWrapperListRecipientListResponse;
import org.inflectionIo.models.Recipient.ResponseWrapperRecipientListResponse;
import org.testng.annotations.Test;

public class RecipientsListTest {

    private final RecipientService recipientService;
    private final ObjectMapper mapper;

    public RecipientsListTest() {
        this.recipientService = new RecipientService();
        this.mapper = new ObjectMapper();
    }

    @Test
    public void testRecipientLists() throws JsonProcessingException {
       Response response =  recipientService.getListOfRecipients();
       ResponseWrapperListRecipientListResponse responseWrapperListRecipientListResponse = mapper.readValue(response.getBody().asString(),
               ResponseWrapperListRecipientListResponse.class);
    }

    @Test(dataProvider = "recipientList", dataProviderClass = TestDataProviders.class)
    public void testRecipientLists(String id) throws JsonProcessingException {
        Response response =  recipientService.getListOfRecipientsById(id);
        ResponseWrapperRecipientListResponse responseWrapperListRecipientListResponse = mapper.readValue(response.getBody().asString(),
                ResponseWrapperRecipientListResponse.class);
    }

}
