package com.example.msinventory.service;

import com.example.msinventory.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    Order createOrder(Long offerId);

    Order getOrderById(Long id);
}
