package com.vmobs.model.alert;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liorm on 20/05/2014.
 */
public class AlertDto {
    @Expose
    private String alertId;
    @Expose
    private String resourceId;
    @Expose
    private String alertLevel;
    @Expose
    private String type;
    @Expose
    private String subType;
    @Expose
    private String status;
    @Expose
    private Long startTimeUTC;
    @Expose
    private Long cancelTimeUTC;
    @Expose
    private Long updateTimeUTC;
    @Expose
    private Long suspendUntilTimeUTC;
    @Expose
    private String controlState;
    @Expose
    private String problemDefinitionId;
    @Expose
    private String problemName;
    @Expose
    private List<Link> links = new ArrayList<Link>();

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getStartTimeUTC() {
        return startTimeUTC;
    }

    public void setStartTimeUTC(Long startTimeUTC) {
        this.startTimeUTC = startTimeUTC;
    }

    public Long getCancelTimeUTC() {
        return cancelTimeUTC;
    }

    public void setCancelTimeUTC(Long cancelTimeUTC) {
        this.cancelTimeUTC = cancelTimeUTC;
    }

    public Long getUpdateTimeUTC() {
        return updateTimeUTC;
    }

    public void setUpdateTimeUTC(Long updateTimeUTC) {
        this.updateTimeUTC = updateTimeUTC;
    }

    public Long getSuspendUntilTimeUTC() {
        return suspendUntilTimeUTC;
    }

    public void setSuspendUntilTimeUTC(Long suspendUntilTimeUTC) {
        this.suspendUntilTimeUTC = suspendUntilTimeUTC;
    }

    public String getControlState() {
        return controlState;
    }

    public void setControlState(String controlState) {
        this.controlState = controlState;
    }

    public String getProblemDefinitionId() {
        return problemDefinitionId;
    }

    public void setProblemDefinitionId(String problemDefinitionId) {
        this.problemDefinitionId = problemDefinitionId;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
