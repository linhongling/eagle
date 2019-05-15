package com.eagle.order.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Long id;

    private String no;

    private Date orderDate;

    private Long clientId;

    private String addr;

    private Long goodsId;

    private Integer count;

    private BigDecimal weight;

    private BigDecimal volume;

    private BigDecimal freightMonthly;

    private BigDecimal freightNow;

    private BigDecimal freightArrive;

    private BigDecimal costFreight;

    private BigDecimal costDirect;

    private BigDecimal costInsurance;

    private Long transferCompanyId;

    private String transferNo;

    private Date receipt;

    private String remark;

    private Date createDate;

    private Date modifyDate;

    private BigDecimal commission;

    private Long salesmanId;

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

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getFreightMonthly() {
        return freightMonthly;
    }

    public void setFreightMonthly(BigDecimal freightMonthly) {
        this.freightMonthly = freightMonthly;
    }

    public BigDecimal getFreightNow() {
        return freightNow;
    }

    public void setFreightNow(BigDecimal freightNow) {
        this.freightNow = freightNow;
    }

    public BigDecimal getFreightArrive() {
        return freightArrive;
    }

    public void setFreightArrive(BigDecimal freightArrive) {
        this.freightArrive = freightArrive;
    }

    public BigDecimal getCostFreight() {
        return costFreight;
    }

    public void setCostFreight(BigDecimal costFreight) {
        this.costFreight = costFreight;
    }

    public BigDecimal getCostDirect() {
        return costDirect;
    }

    public void setCostDirect(BigDecimal costDirect) {
        this.costDirect = costDirect;
    }

    public BigDecimal getCostInsurance() {
        return costInsurance;
    }

    public void setCostInsurance(BigDecimal costInsurance) {
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

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Long getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(Long salesmanId) {
        this.salesmanId = salesmanId;
    }
}