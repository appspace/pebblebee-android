package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by Eugene on 2015-02-19.
 */
public class Page implements Serializable {

    private Integer page;
    private Integer totalPages;
    private Integer pageSize;
    private Integer total;

    /**
     * @return The page retrieved or, in the case of a request parameter, the specific page requested.
     */
    public Integer getPage() {
        return page;
    }

    /**
     * @param page The page retrieved or, in the case of a request parameter, the specific page requested.
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * @return The total pages available.
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * @param totalPages The total pages available.
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * @return The number of objects on this page.
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize The number of objects on this page.
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return The total number of objects available.
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total The total number of objects available.
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}
