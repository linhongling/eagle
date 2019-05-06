package com.eagle.order.domain;

import java.util.Date;

public class Goods {
    private Long id;

    private String name;

    private String remark;

    private Date createDate;

    private Date modifyDate;

    private Byte isValidate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Byte getIsValidate() {
        return isValidate;
    }

    public void setIsValidate(Byte isValidate) {
        this.isValidate = isValidate;
    }
}