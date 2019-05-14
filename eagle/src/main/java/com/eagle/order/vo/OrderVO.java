package com.eagle.order.vo;

import lombok.Data;

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

    private Long weight;

    private Long volume;

    private Long freightMonthly;

    private Long freightNow;

    private Long freightArrive;

    private Long costFreight;

    private Long costDirect;

    private Long costInsurance;

    private Long transferCompanyId;

    private String transferCompanyName;

    private String transferNo;

    private Date receipt;

    private String remark;

    private Date createDate;

    private Date modifyDate;

    private Long commission;
}