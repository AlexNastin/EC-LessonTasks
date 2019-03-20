package com.belkevich.cleancode;

import com.belkevich.cleancode.entity.Order;
import com.belkevich.cleancode.entity.OrderItem;
import com.belkevich.cleancode.entity.OrderNumber;
//import com.belkevich.cleancode.service.impl.OrderItemOperations;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderTest {

    @Test
    public void testOf(){
        Order order = Order.of(OrderNumber.of(1));
        final BigDecimal orderItemValue = BigDecimal.valueOf(2);
        order.addItem(OrderItem.of("car",1, BigDecimal.valueOf(2)));
        order.getItems().getQuantity();
//        order.apply(OrderItemOperations.DISCOUNT);
        assert order.getItems().getValue().equals(orderItemValue.multiply(BigDecimal.valueOf(0.8)));
    }

}