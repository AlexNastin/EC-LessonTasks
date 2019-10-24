package com.nastsin.ec.springweb.service;

import com.nastsin.ec.springweb.entity.Item;
import com.nastsin.ec.springweb.exception.NotFoundException;

import java.util.List;

public interface ItemService {

    Item getItem(Long id) throws NotFoundException;

    Item saveItem(Item item);

    List<Item> getItems();
}