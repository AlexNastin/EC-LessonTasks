package com.example.msinventory.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`order`")
@Data
@ToString
public class Order {

    @Id
    @GeneratedValue
    private Long Id;

    private String name;

    private Double price;

    private Long orderId;

}
