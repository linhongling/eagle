package com.eagle.order.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderQuery {

    private String no;

    private Date startOrderDate;

    private Date endOrderDate;

    private List<Long> clientIds;

    private Date startReceipt;

    private Date endReceipt;

    private List<Long> transferCompanyIds;

    private String transferNo;
}