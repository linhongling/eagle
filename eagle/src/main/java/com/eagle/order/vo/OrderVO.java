package com.eagle.order.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderVO {
    private Long id;

    private String no;

    private Date orderDate;

    private Long clientId;

    private String clientName;

    private String addr;

    private Long goodsId;

    private String goodsName;

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

    private String transferCompanyName;

    private String transferNo;

    private Date receipt;

    private String remark;

    private Date createDate;

    private Date modifyDate;

    private BigDecimal commission;

    private String salesmansName;

    private String destination;

    private String recipient;

    private String recipientPhone;

    private String deliveryman;
}