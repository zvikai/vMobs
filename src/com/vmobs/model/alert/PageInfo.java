
package com.vmobs.model.alert;

import com.google.gson.annotations.Expose;


public class PageInfo {

    @Expose
    private Integer totalCount;
    @Expose
    private Integer page;
    @Expose
    private Integer pageSize;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
