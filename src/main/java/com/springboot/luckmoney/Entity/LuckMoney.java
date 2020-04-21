package com.springboot.luckmoney.Entity;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

@Entity
public class LuckMoney {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message = "金额必传!")
    private BigDecimal money;

    private String producer;

    private String consumer;

    public LuckMoney() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    @Override
    public String toString() {
        return "LuckMoney{" +
                "id=" + id +
                ", money=" + money +
                ", producer='" + producer + '\'' +
                ", consumer='" + consumer + '\'' +
                '}';
    }
}
