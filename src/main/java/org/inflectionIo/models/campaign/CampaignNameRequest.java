package org.inflectionIo.models.campaign;

import java.util.Objects;

public class CampaignNameRequest {

    private String campaignName;

    public CampaignNameRequest(String campaignName) {
        this.campaignName = campaignName;
    }

    public static CampaignNameRequestBuilder builder() {
        return new CampaignNameRequestBuilder();
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampaignNameRequest that = (CampaignNameRequest) o;
        return Objects.equals(campaignName, that.campaignName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(campaignName);
    }

    @Override
    public String toString() {
        return "CampaignNameRequest{" +
                "campaignName='" + campaignName + '\'' +
                '}';
    }

    public static class CampaignNameRequestBuilder {

        private String campaignName;

        CampaignNameRequestBuilder() {
        }


        public CampaignNameRequestBuilder campaignName(String campaignName) {
            this.campaignName = campaignName;
            return this;
        }

        public CampaignNameRequest build() {
            return new CampaignNameRequest(this.campaignName);
        }

        @Override
        public String toString() {
            return "CampaignNameRequest.CampaignNameRequestBuilder{" +
                    "campaignName='" + campaignName + '\'' +
                    '}';
        }
    }

}
