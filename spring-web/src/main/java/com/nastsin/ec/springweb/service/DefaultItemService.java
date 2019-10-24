package com.nastsin.ec.springweb.service;

import com.nastsin.ec.springweb.entity.Item;
import com.nastsin.ec.springweb.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultItemService implements ItemService {

    @Override
    public Item getItem(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public Item saveItem(Item item) {
        return null;
    }

    @Override
    public List<Item> getItems() {
        return null;
    }
}
