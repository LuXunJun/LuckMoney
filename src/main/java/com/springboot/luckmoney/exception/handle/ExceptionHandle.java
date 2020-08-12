package com.springboot.luckmoney.exception.handle;

import com.springboot.luckmoney.Entity.ResultResponse;
import com.springboot.luckmoney.Enums.ResultEnums;
import com.springboot.luckmoney.ResultUtils.ResultUtil;
import com.springboot.luckmoney.exception.LuckymoneyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
/*全局错误拦截*/
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultResponse handle(Exception e) {
        // 业务代码错误截获
        if (e instanceof LuckymoneyException) {
            LuckymoneyException le = (LuckymoneyException) e;
            return ResultUtil.error(le.getCode(), le.getMessage());
        }
        // 全局错误拦截
        /* return ResultUtil.error(-1,e.getMessage());*/
        return ResultUtil.error(ResultEnums.EROR);
    }
}
