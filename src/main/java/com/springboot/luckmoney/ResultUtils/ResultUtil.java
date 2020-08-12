package com.springboot.luckmoney.ResultUtils;

import com.springboot.luckmoney.Entity.ResultResponse;
import com.springboot.luckmoney.Enums.ResultEnums;

public class ResultUtil {
//    测试
    public static ResultResponse success(Object obj) {
        ResultResponse result = new ResultResponse();
        result.setCode(ResultEnums.SUCCESS.getCode());
        result.setMessage(ResultEnums.SUCCESS.getMessage());
        result.setData(obj);
        return result;
    }

    public static ResultResponse success() {
        return success(null);
    }

    public static ResultResponse error(Integer code, String msg) {
        ResultResponse result = new ResultResponse();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    public static ResultResponse error(ResultEnums enums) {
        ResultResponse result = new ResultResponse();
        result.setCode(enums.getCode());
        result.setMessage(enums.getMessage());
        return result;
    }
}
