package com.nastsin.ec.springweb.mapper;

import com.nastsin.ec.springweb.dto.AddressDto;
import com.nastsin.ec.springweb.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AddressMapper {

    private final ModelMapper mapper;

    @Autowired
    public AddressMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Address toEntity(AddressDto addressDto) {
        return Objects.isNull(addressDto) ? null : mapper.map(addressDto, Address.class);
    }

    public AddressDto toDto(Address entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, AddressDto.class);
    }
}