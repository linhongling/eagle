package com.eagle.order.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ClientVO {
    private Long id;

    private String name;

    private String phone;

    private String contact;

    private String cellphone;

    private String addr;

    private String remark;

    private Date createDate;

    private Date modifyDate;

    private Byte isValidate;

    private Long salesmanId;

    private String salesmanName;
}