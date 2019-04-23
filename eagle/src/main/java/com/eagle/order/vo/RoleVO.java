package com.eagle.order.vo;

import java.util.Date;

public class RoleVO {

    private Long id;

    private String roleName;

    private Date createTime;

    private Date updateTime;

    private Long[] permIds;

    private Long[] pPermIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long[] getPermIds() {
        return permIds;
    }

    public void setPermIds(Long[] permIds) {
        this.permIds = permIds;
    }

    public Long[] getpPermIds() {
        return pPermIds;
    }

    public void setpPermIds(Long[] pPermIds) {
        this.pPermIds = pPermIds;
    }
}