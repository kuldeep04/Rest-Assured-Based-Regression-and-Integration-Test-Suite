package org.inflectionIo.campaignService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.inflectionIo.RequestionSpecification.RequestSpecification;
import org.inflectionIo.models.campaign.CampaignNameRequest;
import org.inflectionIo.models.campaign.CampaignRequest;
import java.util.HashMap;
import java.util.Map;
import static org.inflectionIo.constants.Constants.campaignBaseUrl;
import static org.inflectionIo.utils.TestUtils.serializeObject;

public class CampaignService {

    private final RequestSpecification requestSpecification;

    public CampaignService() {
        this.requestSpecification = new RequestSpecification(campaignBaseUrl);
    }

    public Response createCampaign(String campaignName, String emailTemplateId, String recipientListId, Integer scheduledId) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "*/*");
        CampaignRequest campaignRequest = CampaignRequest.builder()
                .campaignName(campaignName)
                .emailTemplateId(emailTemplateId)
                .recipientListId(recipientListId)
                .scheduledTime(scheduledId)
                .build();
        return RestAssured.given().spec(requestSpecification.getRequestSpecification(headers, "campaigns",
                        serializeObject(campaignRequest)))
                .when().post();
    }

    public Response updateCampaignName(String campaignName, String campaignId) {
        Map<String, String> headers = new HashMap<>();
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("campaignId", campaignId);
        headers.put("Content-Type", "application/json");
        CampaignNameRequest campaignNameRequest = CampaignNameRequest.builder().campaignName(campaignName).build();
        return RestAssured.given().spec(requestSpecification.getRequestSpecification(headers, pathParams, "campaigns/{campaignId}/name",
                        serializeObject(campaignNameRequest)))
                .when().patch();
    }

    public Response getCampaignById(String campaignId) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("campaignId", campaignId);
        return RestAssured.given().spec(requestSpecification.getRequestSpecification(headers, "campaigns/{campaignId}", pathParams))
                .when().get();
    }

}
