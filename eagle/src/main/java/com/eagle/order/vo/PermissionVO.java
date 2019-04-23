package com.eagle.order.vo;

import java.util.ArrayList;
import java.util.List;

public class PermissionVO {

    private Long id;

    private String label;

    private List<PermissionVO> children = new ArrayList<PermissionVO>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<PermissionVO> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionVO> children) {
        this.children = children;
    }
}
