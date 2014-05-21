package com.vmobs.model.alert;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;


public class AlertsDto {

    @Expose
    private PageInfo pageInfo;
    @Expose
    private List<Link> links = new ArrayList<Link>();
    @Expose
    private List<AlertDto> alerts = new ArrayList<AlertDto>();

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<AlertDto> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<AlertDto> alerts) {
        this.alerts = alerts;
    }

}

