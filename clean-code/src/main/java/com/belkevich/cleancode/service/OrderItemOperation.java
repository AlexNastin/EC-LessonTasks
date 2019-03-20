package com.belkevich.cleancode.service;

import com.belkevich.cleancode.entity.OrderItem;

import java.util.function.Function;

public interface OrderItemOperation extends Function<OrderItem,OrderItem> {
}
