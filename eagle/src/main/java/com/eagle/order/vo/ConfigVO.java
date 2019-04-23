package com.eagle.order.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.eagle.order.entity.Config;

public class ConfigVO {

    public ConfigVO(){}

    public ConfigVO(boolean success) {
        this.success = success;
    }

    public ConfigVO(Config config) {
        this.appConfig = config;
    }

    private boolean success = true;

    private Config appConfig;

    @JsonProperty("success")
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @JsonProperty("AppConfig")
    public Config getAppConfig() {
        return appConfig;
    }

    public void setAppConfig(Config appConfig) {
        this.appConfig = appConfig;
    }
}
