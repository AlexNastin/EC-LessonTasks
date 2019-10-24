package com.nastsin.ec.springweb.dto;

import lombok.Data;

@Data
public class UserDto {

    private String id;
    private String name;
    private String addressId;
    private String street;
    private String city;
}