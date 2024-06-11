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

}
