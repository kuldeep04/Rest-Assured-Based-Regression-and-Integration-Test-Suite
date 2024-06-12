package org.inflectionIo.models.campaign;


import java.util.Objects;

public class CampaignRequest {

    private String campaignName;
    private String emailTemplateId;
    private String recipientListId;
    private Integer scheduledTime;

    public CampaignRequest(String campaignName, String emailTemplateId, String recipientListId, Integer scheduledTime) {
        this.campaignName = campaignName;
        this.emailTemplateId = emailTemplateId;
        this.recipientListId = recipientListId;
        this.scheduledTime = scheduledTime;
    }

    public static CampaignRequestBuilder builder() {
     return new CampaignRequestBuilder();
    }


    public String getRecipientListId() {
        return recipientListId;
    }

    public void setRecipientListId(String recipientListId) {
        this.recipientListId = recipientListId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getEmailTemplateId() {
        return emailTemplateId;
    }

    public void setEmailTemplateId(String emailTemplateId) {
        this.emailTemplateId = emailTemplateId;
    }

    public Integer getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Integer scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampaignRequest that = (CampaignRequest) o;
        return Objects.equals(campaignName, that.campaignName) && Objects.equals(emailTemplateId, that.emailTemplateId) && Objects.equals(recipientListId, that.recipientListId) && Objects.equals(scheduledTime, that.scheduledTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campaignName, emailTemplateId, recipientListId, scheduledTime);
    }


    @Override
    public String toString() {
        return "CampaignRequest{" +
                "campaignName='" + campaignName + '\'' +
                ", emailTemplateId='" + emailTemplateId + '\'' +
                ", recipientListId='" + recipientListId + '\'' +
                ", scheduledTime=" + scheduledTime +
                '}';
    }

    public static class CampaignRequestBuilder {

        private String campaignName;
        private String emailTemplateId;
        private String recipientListId;
        private Integer scheduledTime;

        public CampaignRequestBuilder() {
        }

        public CampaignRequestBuilder campaignName(String campaignName) {
            this.campaignName = campaignName;
            return this;
        }

        public CampaignRequestBuilder emailTemplateId(String emailTemplateId) {
            this.emailTemplateId = emailTemplateId;
            return this;
        }

        public CampaignRequestBuilder recipientListId(String recipientListId) {
            this.recipientListId = recipientListId;
            return this;
        }

        public CampaignRequestBuilder scheduledTime(Integer scheduledTime) {
            this.scheduledTime = scheduledTime;
            return this;
        }

        public CampaignRequest build() {
            return new CampaignRequest(this.campaignName, this.emailTemplateId, this.recipientListId, this.scheduledTime);
        }

        @Override
        public String toString() {
            return "CampaignRequestBuilder{" +
                    "campaignName='" + campaignName + '\'' +
                    ", emailTemplateId='" + emailTemplateId + '\'' +
                    ", recipientListId='" + recipientListId + '\'' +
                    ", scheduledTime=" + scheduledTime +
                    '}';
        }
    }

}
