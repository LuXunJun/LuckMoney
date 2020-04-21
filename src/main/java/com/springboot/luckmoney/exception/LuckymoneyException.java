package com.springboot.luckmoney.exception;

import com.springboot.luckmoney.Enums.ResultEnums;

// RuntimeException 在spring中RuntimeException是带有事务回滚的
public class LuckymoneyException extends RuntimeException {
    private Integer code;

    public LuckymoneyException(ResultEnums enums) {
        super(enums.getMessage());
        this.code = enums.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
