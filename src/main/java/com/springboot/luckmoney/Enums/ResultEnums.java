package com.springboot.luckmoney.Enums;

public enum ResultEnums {
    EROR(-1, "错误信息"),
    SUCCESS(0, "成功"),
    ERROR1(100, "金额大于100");
    private Integer code;
    private String Message;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.Message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
