package com.zosiasg.shop.controller;

import com.zosiasg.shop.model.Item;
import com.zosiasg.shop.model.order.Order;
import com.zosiasg.shop.repository.ItemRepository;
import com.zosiasg.shop.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Controller
@RequestMapping("/addItem")
public class AdminController {

    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public AdminController(ItemRepository itemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    private String adminPage() {
        return "adminview/addItem";
    }

    @PostMapping
    private String addItem(Item item) {
        itemRepository.save(item);
        return "redirect:/addItem";
    }

    @GetMapping("/showorders")
    @ResponseBody
    public List<Order> showOrders() {
        return orderRepository.findAll();
    }

    @DeleteMapping("/item/{itemId}")
    public void deleteItem(@PathVariable long itemId) {
        itemRepository.deleteById(itemId);
    }

}