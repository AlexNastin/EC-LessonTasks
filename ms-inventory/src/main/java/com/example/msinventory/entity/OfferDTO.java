package com.example.msinventory.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OfferDTO {

    private Long id;

    private String name;

    private Double price;
}

