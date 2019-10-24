package com.nastsin.ec.springweb.repository;

import com.nastsin.ec.springweb.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
