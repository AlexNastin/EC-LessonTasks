package com.example.mscatalog.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@ToString
public class Offer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double price;
}
