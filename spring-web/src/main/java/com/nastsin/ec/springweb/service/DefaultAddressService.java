package com.nastsin.ec.springweb.service;

import com.nastsin.ec.springweb.entity.Address;
import com.nastsin.ec.springweb.exception.NotFoundException;
import com.nastsin.ec.springweb.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultAddressService implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public DefaultAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional
    public Address getAddress(Long id) throws NotFoundException {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            return address.get();
        } else {
            throw new NotFoundException("Address with id: " + id + " was not found");
        }
    }

    @Override
    @Transactional
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    @Transactional
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }
}
