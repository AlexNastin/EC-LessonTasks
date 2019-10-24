package com.nastsin.ec.springweb.service;

import com.nastsin.ec.springweb.entity.Address;
import com.nastsin.ec.springweb.exception.NotFoundException;

import java.util.List;

public interface AddressService {

    Address getAddress(Long id) throws NotFoundException;

    Address saveAddress(Address address);

    List<Address> getAddresses();
}