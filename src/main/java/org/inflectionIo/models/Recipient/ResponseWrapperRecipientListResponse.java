package org.inflectionIo.models.Recipient;

import org.inflectionIo.models.campaign.ErrorResponse;
import org.inflectionIo.models.campaign.MetaResponse;
import org.inflectionIo.models.campaign.PaginationResponse;

import java.util.List;
import java.util.Objects;

public class ResponseWrapperRecipientListResponse {

    private RecipientListResponse data;
    private PaginationResponse pagination;
    private List<ErrorResponse> errors;
    public MetaResponse meta;

    public ResponseWrapperRecipientListResponse(){}

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

    public List<ErrorResponse> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorResponse> errors) {
        this.errors = errors;
    }

    public MetaResponse getMeta() {
        return meta;
    }

    public void setMeta(MetaResponse meta) {
        this.meta = meta;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseWrapperRecipientListResponse that = (ResponseWrapperRecipientListResponse) o;
        return Objects.equals(data, that.data) && Objects.equals(pagination, that.pagination) && Objects.equals(errors, that.errors) && Objects.equals(meta, that.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, pagination, errors, meta);
    }


}
