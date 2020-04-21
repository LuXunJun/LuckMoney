package com.springboot.luckmoney.Helper;

import com.springboot.luckmoney.Entity.LuckMoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuckMoneySQLHelper extends JpaRepository<LuckMoney, Integer> {
}
