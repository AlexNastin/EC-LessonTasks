package com.belkevich.cleancode.entity;

import com.belkevich.cleancode.service.OrderItemOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

public class Order {

    private Long id;

    private OrderNumber number;

    private List<OrderItem> items = new ArrayList<>();

    private Order(OrderNumber number) {
        this.number = number;
    }

    public static Order of(OrderNumber number) {
        checkNotNull(number);
        return new Order(number);
    }

    public void addItem(OrderItem item) {
        if (!items.contains(item)) {
            items.add(item);
        }
    }

    public void apply(OrderItemOperation operation) {
        items = items
                .stream()
                .map(operation)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public OrderNumber getNumber() {
        return number;
    }

    public OrderItems getItems() {
        return OrderItems.of(items);
    }

}
