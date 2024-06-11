package org.inflectionIo.models.EmailTemplate;

import java.util.List;
import org.inflectionIo.models.campaign.ErrorResponse;
import org.inflectionIo.models.campaign.MetaResponse;
import org.inflectionIo.models.campaign.PaginationResponse;

public class ResponseWrapperListEmailTemplateResponse {

    private List<EmailTemplateResponse> data;
    private PaginationResponse pagination;
    private ErrorResponse error;
    private MetaResponse meta;

    public PaginationResponse getPagination() {
        return pagination;
    }

    public void setPagination(PaginationResponse pagination) {
        this.pagination = pagination;
    }

    public List<EmailTemplateResponse> getData() {
        return data;
    }

    public void setData(List<EmailTemplateResponse> data) {
        this.data = data;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public MetaResponse getMeta() {
        return meta;
    }

    public void setMeta(MetaResponse meta) {
        this.meta = meta;
    }
}
