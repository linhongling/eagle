package com.eagle.order.vo;

import java.io.Serializable;

public class ConfigSearchVO implements Serializable {

    private static final long serialVersionUID = -5985170795766458057L;

    private String appId;

    private String pushKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPushKey() {
        return pushKey;
    }

    public void setPushKey(String pushKey) {
        this.pushKey = pushKey;
    }
}
