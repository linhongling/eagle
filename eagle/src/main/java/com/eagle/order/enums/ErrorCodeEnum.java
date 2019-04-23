package com.eagle.order.enums;

/**
 * @author lin.hongling
 */

public enum ErrorCodeEnum {

    SUCCESS(200),
    REQUEST_INVALID(400),
    SERVICE_ERROR(500);

    private int code;

    // 构造方法
    ErrorCodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
