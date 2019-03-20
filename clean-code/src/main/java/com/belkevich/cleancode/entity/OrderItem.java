package com.belkevich.cleancode.entity;

import com.google.common.base.MoreObjects;

import java.math.BigDecimal;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class OrderItem {

    private String product;

    private Integer quantity;

    private BigDecimal value;

    private OrderItem(String product, Integer quantity, BigDecimal value) {
        this.product = product;
        this.quantity = quantity;
        this.value = value;
    }

    public static OrderItem of(String product, Integer quantity, BigDecimal value) {
        checkNotNull(product);
        checkNotNull(quantity);
        checkArgument(quantity > 0);
        checkNotNull(value);
        return new OrderItem(product, quantity, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OrderItem) {
            OrderItem other = (OrderItem) obj;
            return Objects.equals(this.value, other.value) && Objects.equals(this.product, other.product)
                    && Objects.equals(this.quantity, other.quantity);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value, this.product, this.product);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", value)
                .add("product", product)
                .add("quantity", quantity)
                .toString();
    }

    public String getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getValue() {
        return value;
    }
}
