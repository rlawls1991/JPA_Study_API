package com.study.repository;


import com.study.domain.OrderStatus;
import lombok.Getter;

@Getter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus;
}
