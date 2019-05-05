package com.eagle.order.domain;

import java.util.Date;

public class Order {
    private Long id;

    private String no;

    private Date orderDate;

    private Long clientId;

    private String addr;

    private Long goodsId;

    private Integer count;

    private Long weight;

    private Long volume;

    private Long freightMonthly;

    private Long freightNow;

    private Long freightArrive;

    private Long costFreight;

    private Long costDirect;

    private Long costInsurance;

    private Long transferCompanyId;

    private String transferNo;

    private Date receipt;

    private String remark;

    private Date createDate;

    private Date modifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Long getFreightMonthly() {
        return freightMonthly;
    }

    public void setFreightMonthly(Long freightMonthly) {
        this.freightMonthly = freightMonthly;
    }

    public Long getFreightNow() {
        return freightNow;
    }

    public void setFreightNow(Long freightNow) {
        this.freightNow = freightNow;
    }

    public Long getFreightArrive() {
        return freightArrive;
    }

    public void setFreightArrive(Long freightArrive) {
        this.freightArrive = freightArrive;
    }

    public Long getCostFreight() {
        return costFreight;
    }

    public void setCostFreight(Long costFreight) {
        this.costFreight = costFreight;
    }

    public Long getCostDirect() {
        return costDirect;
    }

    public void setCostDirect(Long costDirect) {
        this.costDirect = costDirect;
    }

    public Long getCostInsurance() {
        return costInsurance;
    }

    public void setCostInsurance(Long costInsurance) {
        this.costInsurance = costInsurance;
    }

    public Long getTransferCompanyId() {
        return transferCompanyId;
    }

    public void setTransferCompanyId(Long transferCompanyId) {
        this.transferCompanyId = transferCompanyId;
    }

    public String getTransferNo() {
        return transferNo;
    }

    public void setTransferNo(String transferNo) {
        this.transferNo = transferNo == null ? null : transferNo.trim();
    }

    public Date getReceipt() {
        return receipt;
    }

    public void setReceipt(Date receipt) {
        this.receipt = receipt;
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
}