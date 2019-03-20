package com.belkevich.cleancode.entity;

import com.google.common.base.MoreObjects;


import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class OrderNumber {

    private final Integer value;

    private OrderNumber(Integer value) {
        this.value = value;
    }

    public static OrderNumber of(Integer value) {
        checkNotNull(value);
        checkArgument(value > 0);
        return new OrderNumber(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OrderNumber) {
            OrderNumber other = (OrderNumber) obj;
            return Objects.equals(this.value,other.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value",value)
                .toString();
    }

    public Integer toInteger() {
        return value;
    }
}
