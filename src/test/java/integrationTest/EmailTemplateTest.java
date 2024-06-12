package integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import dataProviders.TestDataProviders;
import io.restassured.response.Response;
import org.inflectionIo.emailTemplateService.EmailTemplateService;
import org.inflectionIo.models.EmailTemplate.EmailTemplateResponse;
import org.inflectionIo.models.EmailTemplate.ResponseWrapperEmailTemplateResponse;
import org.inflectionIo.models.EmailTemplate.ResponseWrapperListEmailTemplateResponse;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class EmailTemplateTest {

    private final EmailTemplateService emailTemplateService;
    private final ObjectMapper mapper;

    public EmailTemplateTest(){
        this.emailTemplateService = new EmailTemplateService();
        this.mapper = new ObjectMapper();
    }

    @Test
    public void testEmailTemplate() throws IOException {
        Response response = emailTemplateService.getEmailTemplates();
        ResponseWrapperListEmailTemplateResponse responseWrapperListEmailTemplateResponse = mapper.readValue(response.getBody().asString(),
                ResponseWrapperListEmailTemplateResponse.class);
        List<EmailTemplateResponse> listOfEmailTemplateResponse = responseWrapperListEmailTemplateResponse.getData();
        for(EmailTemplateResponse emailTemplateResponse : listOfEmailTemplateResponse){
            System.out.println(emailTemplateResponse.getData());
        }
    }

    @Test(dataProvider = "emailTemplate", dataProviderClass = TestDataProviders.class)
    public void testEmailTemplateById(String id) throws IOException {
        Response response = emailTemplateService.getEmailTemplateById(id);
        ResponseWrapperEmailTemplateResponse responseWrapperListEmailTemplateResponse = mapper.readValue(response.getBody().asString(),
                ResponseWrapperEmailTemplateResponse.class);
        EmailTemplateResponse EmailTemplateResponse = responseWrapperListEmailTemplateResponse.getData();
    }
}
