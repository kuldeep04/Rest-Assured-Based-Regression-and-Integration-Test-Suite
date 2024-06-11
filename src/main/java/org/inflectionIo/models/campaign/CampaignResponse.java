package org.inflectionIo.models.campaign;

import java.util.Objects;

public class CampaignResponse {

    private String id;
    private String campaignName;
    private String emailTemplateId;
    private String recipientListId;
    private Integer scheduledTime;

    public CampaignResponse(String id, String campaignName, String emailTemplateId, String recipientListId, Integer scheduledTime) {
        this.id = id;
        this.campaignName = campaignName;
        this.emailTemplateId = emailTemplateId;
        this.recipientListId = recipientListId;
        this.scheduledTime = scheduledTime;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipientListId() {
        return recipientListId;
    }

    public void setRecipientListId(String recipientListId) {
        this.recipientListId = recipientListId;
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
        CampaignResponse that = (CampaignResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(campaignName, that.campaignName) && Objects.equals(emailTemplateId, that.emailTemplateId) && Objects.equals(recipientListId, that.recipientListId) && Objects.equals(scheduledTime, that.scheduledTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, campaignName, emailTemplateId, recipientListId, scheduledTime);
    }


}
