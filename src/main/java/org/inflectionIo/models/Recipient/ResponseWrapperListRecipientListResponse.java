package org.inflectionIo.models.Recipient;

import org.inflectionIo.models.campaign.ErrorResponse;
import org.inflectionIo.models.campaign.MetaResponse;
import org.inflectionIo.models.campaign.PaginationResponse;

public class ResponseWrapperListRecipientListResponse {

    private RecipientListResponse data;
    private PaginationResponse pagination;
    private ErrorResponse errors;
    public MetaResponse meta;

    public PaginationResponse getPagination() {
        return pagination;
    }

    public void setPagination(PaginationResponse pagination) {
        this.pagination = pagination;
    }

    public RecipientListResponse getData() {
        return data;
    }

    public void setData(RecipientListResponse data) {
        this.data = data;
    }

    public ErrorResponse getErrors() {
        return errors;
    }

    public void setErrors(ErrorResponse errors) {
        this.errors = errors;
    }

    public MetaResponse getMeta() {
        return meta;
    }

    public void setMeta(MetaResponse meta) {
        this.meta = meta;
    }

}
