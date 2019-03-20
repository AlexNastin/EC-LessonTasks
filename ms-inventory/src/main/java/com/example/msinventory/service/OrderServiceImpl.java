package com.example.msinventory.service;

import com.example.msinventory.entity.OfferDTO;
import com.example.msinventory.entity.Order;
import com.example.msinventory.repository.OrderRepository;
import com.example.msinventory.web.client.CatalogClient;
import com.example.msinventory.web.client.CatalogFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private CatalogFeignClient catalogClient;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CatalogFeignClient catalogClient) {
        this.orderRepository = orderRepository;
        this.catalogClient = catalogClient;
    }

    @Override
    public Order createOrder(Long offerId) {
        OfferDTO offer = catalogClient.getOffer(offerId);
        return orderRepository.save(createOrderFromOffer(offer));
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findOne(id);
    }

    private Order createOrderFromOffer(OfferDTO offer) {
        Order order = new Order();
        order.setName("Order#" + offer.getName());
        order.setPrice(offer.getPrice());
        order.setOrderId(offer.getId());
        return order;
    }
}
