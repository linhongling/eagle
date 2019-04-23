package com.eagle.order.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class WebUserPermissionDO implements Serializable {

    private static final long serialVersionUID = -6344592928538534427L;

    private List<String> menuList = new ArrayList<String>();

    private List<String> permissionList= new ArrayList<String>();

}
