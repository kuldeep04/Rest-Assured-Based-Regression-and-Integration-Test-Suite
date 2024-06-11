package org.inflectionIo.models.campaign;

import java.util.Objects;

public class ResponseWrapperCampaignResponse {

    private CampaignResponse data;
    private PaginationResponse pagination;
    private ErrorResponse errors;
    private MetaResponse meta;

    public CampaignResponse getData() {
        return data;
    }

    public void setData(CampaignResponse data) {
        this.data = data;
    }

    public PaginationResponse getPagination() {
        return pagination;
    }

    public void setPagination(PaginationResponse pagination) {
        this.pagination = pagination;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseWrapperCampaignResponse that = (ResponseWrapperCampaignResponse) o;
        return Objects.equals(data, that.data) && Objects.equals(pagination, that.pagination) && Objects.equals(errors, that.errors) && Objects.equals(meta, that.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, pagination, errors, meta);
    }

}
