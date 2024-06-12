package org.inflectionIo.models.EmailTemplate;

import org.inflectionIo.models.campaign.ErrorResponse;
import org.inflectionIo.models.campaign.MetaResponse;
import org.inflectionIo.models.campaign.PaginationResponse;

import java.util.List;

public class ResponseWrapperEmailTemplateResponse {

    private EmailTemplateResponse data;
    private PaginationResponse pagination;
    private List<ErrorResponse> errors;
    private MetaResponse meta;

    public ResponseWrapperEmailTemplateResponse() {
    }

    public PaginationResponse getPagination() {
        return pagination;
    }

    public void setPagination(PaginationResponse pagination) {
        this.pagination = pagination;
    }

    public EmailTemplateResponse getData() {
        return data;
    }

    public void setData(EmailTemplateResponse data) {
        this.data = data;
    }

    public List<ErrorResponse> getErrors() {
        return errors;
    }

    public void setError(List<ErrorResponse> errors) {
        this.errors = errors;
    }

    public MetaResponse getMeta() {
        return meta;
    }

    public void setMeta(MetaResponse meta) {
        this.meta = meta;
    }
}
