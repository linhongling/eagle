package com.eagle.order.vo;

import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Date;

public class WebUserVO implements Serializable {

    private static final long serialVersionUID = -2129324708756008082L;

    private Long id;

    private String account;

    private String password;

    private String loginCode;

    private String nickname;

    private Date createTime;

    private Date updateTime;

    private WebUserPermissionDO userPermission;

    private String roles;

    private Long[] roleIds;

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public WebUserPermissionDO getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(WebUserPermissionDO userPermission) {
        this.userPermission = userPermission;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}