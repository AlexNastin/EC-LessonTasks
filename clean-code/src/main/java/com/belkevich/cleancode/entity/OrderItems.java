package com.belkevich.cleancode.entity;

import com.google.common.collect.ForwardingList;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;
import static jdk.nashorn.internal.objects.NativeMath.log;

@Slf4j
public class OrderItems extends ForwardingList<OrderItem> {

    private final List<OrderItem> delegate;

    private OrderItems(List<OrderItem> delegate) {
        this.delegate = delegate;
    }

    static OrderItems of(List<OrderItem> delegate) {
        checkNotNull(delegate);
        return new OrderItems(delegate);
    }

    @Override
    public void add(int index, OrderItem orderItem) {
        checkNotNull(orderItem);
        log(index, orderItem);
        super.add(index, orderItem);
    }
    @Override
    public boolean add(OrderItem orderItem) {
        checkNotNull(orderItem);
        return standardAdd(orderItem);
    }
    @Override
    public boolean addAll(Collection<? extends OrderItem> orderItems) {
        return standardAddAll(orderItems);
    }

    @Override
    protected List<OrderItem> delegate() {
        return delegate;
    }

    public Integer getQuantity() {
        return delegate.stream()
                .map(OrderItem::getQuantity)
                .reduce(0, Integer::sum);
    }

    public BigDecimal getValue() {
        return delegate.stream()
                .map(OrderItem::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<OrderItem> getOrdersFilteredByQuantity(Integer quantity) {
        return delegate.stream()
                .filter(orderItem -> orderItem.getQuantity().equals(quantity))
                .collect(Collectors.toList());
    }

    public List<OrderItem> getOrdersFilteredByQuantityAndValue(Integer quantity,BigDecimal value) {
        return delegate.stream()
                .filter(orderItem -> orderItem.getQuantity().equals(quantity) && orderItem.getValue().equals(value))
                .collect(Collectors.toList());
    }

    public List<OrderItem> getOrdersFilteredByPredicate(Predicate<OrderItem> orderItemPredicate) {
        return delegate.stream()
                .filter(orderItemPredicate)
                .collect(Collectors.toList());
    }
}