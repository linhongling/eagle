package com.eagle.order.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderTaskVO {
    private Long id;

    private String taskDesc;

    private String orderNO;

    private Byte status;

    private Date startCreateDate;

    private Date endCreateDate;

    private Date createDate;

    private Date modifyDate;
}