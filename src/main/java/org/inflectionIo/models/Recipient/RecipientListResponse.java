package org.inflectionIo.models.Recipient;

import java.util.List;
import java.util.Objects;

public class RecipientListResponse {

    private String id;
    private String name;
    private List<RecipientResponse> recipients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<RecipientResponse> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<RecipientResponse> recipients) {
        this.recipients = recipients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipientListResponse that = (RecipientListResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(recipients, that.recipients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, recipients);
    }

}
