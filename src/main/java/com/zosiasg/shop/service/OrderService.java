package com.zosiasg.shop.service;

import com.zosiasg.shop.Cart;
import com.zosiasg.shop.dto.OrderDto;
import com.zosiasg.shop.mapper.OrderMapper;
import com.zosiasg.shop.model.order.Order;
import com.zosiasg.shop.model.order.OrderItem;
import com.zosiasg.shop.repository.order.OrderItemRepository;
import com.zosiasg.shop.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final Cart cart;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderService(Cart cart, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.cart = cart;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public void saveOrder(OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        orderRepository.save(order);
        orderItemRepository.saveAll(OrderMapper.mapToOrderItemList(cart, order));
        cart.cleanCart();
    }
}
