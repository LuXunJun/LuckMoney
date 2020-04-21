package com.springboot.luckmoney.service;

import com.springboot.luckmoney.Entity.LuckMoney;
import com.springboot.luckmoney.Enums.ResultEnums;
import com.springboot.luckmoney.Helper.LuckMoneySQLHelper;
import com.springboot.luckmoney.exception.LuckymoneyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class LuckMoneyByService {

    @Autowired
    private LuckMoneySQLHelper helper;

    public LuckMoney getById(Integer id) throws LuckymoneyException {
        Optional<LuckMoney> source = helper.findById(id);
        LuckMoney luckmoney = source.get();
        if(luckmoney.getMoney().compareTo(new BigDecimal(100)) == 1) {
            throw new LuckymoneyException(ResultEnums.ERROR1);
        }
        return luckmoney;
    }
}
