package com.eagle.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Config implements Serializable {

    private Integer id;

    private String pushKey;

    private String acceptCount;

    private String appId;

    private String showWeb;

    private String del;

    private String url;

    private String remark;

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("PushKey")
    public String getPushKey() {
        return pushKey;
    }

    public void setPushKey(String pushKey) {
        this.pushKey = pushKey;
    }

    @JsonProperty("AcceptCount")
    public String getAcceptCount() {
        return acceptCount;
    }

    public void setAcceptCount(String acceptCount) {
        this.acceptCount = acceptCount;
    }

    @JsonProperty("AppId")
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @JsonProperty("ShowWeb")
    public String getShowWeb() {
        return showWeb;
    }

    public void setShowWeb(String showWeb) {
        this.showWeb = showWeb;
    }

    @JsonProperty("Del")
    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    @JsonProperty("Url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("Remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
