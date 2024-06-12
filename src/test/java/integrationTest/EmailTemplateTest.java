package integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import dataProviders.TestDataProviders;
import io.restassured.response.Response;
import org.inflectionIo.emailTemplateService.EmailTemplateService;
import org.inflectionIo.models.EmailTemplate.EmailTemplateResponse;
import org.inflectionIo.models.EmailTemplate.ResponseWrapperEmailTemplateResponse;
import org.inflectionIo.models.EmailTemplate.ResponseWrapperListEmailTemplateResponse;
import org.inflectionIo.models.campaign.ErrorResponse;
import org.inflectionIo.models.campaign.ResponseStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class EmailTemplateTest {

    private final EmailTemplateService emailTemplateService;
    private final ObjectMapper mapper;

    public EmailTemplateTest() {
        this.emailTemplateService = new EmailTemplateService();
        this.mapper = new ObjectMapper();
    }

    /*Get Email template list and validate*/

    @Test
    public void testEmailTemplate() throws IOException {
        Response response = emailTemplateService.getEmailTemplates();
        ResponseWrapperListEmailTemplateResponse responseWrapperListEmailTemplateResponse = mapper.readValue(response.getBody().asString(),
                ResponseWrapperListEmailTemplateResponse.class);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(responseWrapperListEmailTemplateResponse.getMeta().getStatus(), String.valueOf(ResponseStatus.SUCCESS));
        List<EmailTemplateResponse> listOfEmailTemplateResponse = responseWrapperListEmailTemplateResponse.getData();
        for (EmailTemplateResponse emailTemplateResponse : listOfEmailTemplateResponse) {
            Assert.assertNotNull(emailTemplateResponse.getData());
            Assert.assertNotNull(emailTemplateResponse.getId());
            Assert.assertNotNull(emailTemplateResponse.getName());
        }
    }

    /*Get Email template by id  and validate with valid Id*/

    @Test(dataProvider = "emailTemplate", dataProviderClass = TestDataProviders.class)
    public void testEmailTemplateById(String id) throws IOException {
        Response response = emailTemplateService.getEmailTemplateById(id);
        ResponseWrapperEmailTemplateResponse responseWrapperListEmailTemplateResponse = mapper.readValue(response.getBody().asString(),
                ResponseWrapperEmailTemplateResponse.class);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(responseWrapperListEmailTemplateResponse.getMeta().getStatus(), String.valueOf(ResponseStatus.SUCCESS));
        EmailTemplateResponse emailTemplateResponse = responseWrapperListEmailTemplateResponse.getData();
        Assert.assertEquals(emailTemplateResponse.getId(), id);
        Assert.assertNotNull(emailTemplateResponse.getName());
        Assert.assertNotNull(emailTemplateResponse.getData());

    }

    /*Get Email template by id  and validate with invalid Id*/

    @Test(dataProvider = "emailTemplateWithInvalidId", dataProviderClass = TestDataProviders.class)
    public void testEmailTemplateByInvalidId(String id) throws IOException {
        Response response = emailTemplateService.getEmailTemplateById(id);
        ResponseWrapperEmailTemplateResponse responseWrapperListEmailTemplateResponse = mapper.readValue(response.getBody().asString(),
                ResponseWrapperEmailTemplateResponse.class);
        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertEquals(responseWrapperListEmailTemplateResponse.getMeta().getStatus(), String.valueOf(ResponseStatus.FAILURE));
        List<ErrorResponse> errorResponses = responseWrapperListEmailTemplateResponse.getErrors();
        for (ErrorResponse errorResponse : errorResponses) {
            Assert.assertEquals(errorResponse.getErrorCode(), "ETS-E-001");
            Assert.assertEquals(errorResponse.getMessage(), "Email Template Not Found");
        }

    }
}
