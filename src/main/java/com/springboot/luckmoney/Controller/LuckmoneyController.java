package com.springboot.luckmoney.Controller;


import com.springboot.luckmoney.Entity.LuckMoney;
import com.springboot.luckmoney.Entity.LuckMoneyRequest;
import com.springboot.luckmoney.Entity.ResultResponse;
import com.springboot.luckmoney.Helper.LuckMoneySQLHelper;
import com.springboot.luckmoney.ResultUtils.ResultUtil;
import com.springboot.luckmoney.service.LuckMoneyByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
public class LuckmoneyController extends BaseController {

    @Autowired
    private LuckMoneySQLHelper helper;

    @Autowired
    private LuckMoneyByService service;

    @GetMapping("/Luckmoneys")
    public List<LuckMoney> List() {
        return helper.findAll();
    }

    @GetMapping("/Luckmoneys/{id}")
    public ResultResponse getById(@PathVariable("id") Integer id) {
        return ResultUtil.success(service.getById(id));

    }

    /*这个只是争对form表单的提交*/
    @PostMapping("/SaveLuckmoneys")
    public ResultResponse<?> Save(@Valid LuckMoney money, BindingResult bindingResult) {
        ResultResponse response = new ResultResponse();
        response.setCode(1);
        if (bindingResult.hasErrors()) {
            PrintLogError("错误:{}", bindingResult.getFieldError().getDefaultMessage());
            response.setCode(1);
            response.setMessage("错误:{" + bindingResult.getFieldError().getDefaultMessage() + "}");
            return response;
        }
        LuckMoney m = money;
        helper.save(money);
        response.setData(List());
        return response;
    }

    /*请求方为json格式 API请求*/
    @RequestMapping(value = "/LuckMoneyByJson", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void LuckMoneyByJson(@RequestBody LuckMoneyRequest request) {
        System.out.println(request);
    }
}
