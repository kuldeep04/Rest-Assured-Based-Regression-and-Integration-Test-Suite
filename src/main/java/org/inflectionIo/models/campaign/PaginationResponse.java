package org.inflectionIo.models.campaign;

import java.util.Objects;

public class PaginationResponse {


    private int pageNumber;
    private int pageSize;
    private int totalElements;
    private int totalPages;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaginationResponse that = (PaginationResponse) o;
        return pageNumber == that.pageNumber && pageSize == that.pageSize && totalElements == that.totalElements && totalPages == that.totalPages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNumber, pageSize, totalElements, totalPages);
    }

}
