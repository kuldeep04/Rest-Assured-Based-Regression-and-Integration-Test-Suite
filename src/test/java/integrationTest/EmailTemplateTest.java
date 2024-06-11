package integrationTest;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
import org.inflectionIo.RequestionSpecification.RequestSpecification;
import org.inflectionIo.emailTemplateService.EmailTemplateService;
import org.testng.annotations.Test;

public class EmailTemplateTest {

    private final EmailTemplateService emailTemplateService;

    public EmailTemplateTest(){
        this.emailTemplateService = new EmailTemplateService();
    }

    @Test
    public void testEmailTemplate() {
        ResponseSpecification response =  emailTemplateService.getEmailTemplates();
    }
}
