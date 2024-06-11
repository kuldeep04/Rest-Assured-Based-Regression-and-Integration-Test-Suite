package org.inflectionIo.models.campaign;

import java.util.Arrays;
import java.util.Objects;

public class MetaResponse {

    private ResponseStatus[] status;
    private Integer timestamp;

    public ResponseStatus[] getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus[] status) {
        this.status = status;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaResponse that = (MetaResponse) o;
        return Objects.deepEquals(status, that.status) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(status), timestamp);
    }

    public MetaResponse(ResponseStatus[] status) {
        this.status = status;
    }

}
