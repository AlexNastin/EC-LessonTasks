package com.nastsin.ec.springweb.repository;

import com.nastsin.ec.springweb.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
