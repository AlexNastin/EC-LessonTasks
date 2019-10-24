package com.nastsin.ec.springweb.web.controller;

import com.nastsin.ec.springweb.dto.AddressDto;
import com.nastsin.ec.springweb.entity.Address;
import com.nastsin.ec.springweb.exception.NotFoundException;
import com.nastsin.ec.springweb.mapper.AddressMapper;
import com.nastsin.ec.springweb.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;
    private final AddressMapper mapper;

    @Autowired
    public AddressController(AddressService addressService, AddressMapper mapper) {
        this.addressService = addressService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable("id") Long id) throws NotFoundException {
        Address address = addressService.getAddress(id);
        AddressDto addressDto = mapper.toDto(address);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressDto> saveAddress(@RequestBody AddressDto addressDto) {
        Address address = mapper.toEntity(addressDto);
        Address savedAddress = addressService.saveAddress(address);
        AddressDto savedAddressDto = mapper.toDto(savedAddress);
        return new ResponseEntity<>(savedAddressDto, HttpStatus.OK);
    }
}