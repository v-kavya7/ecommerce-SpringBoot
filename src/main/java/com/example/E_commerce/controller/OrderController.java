package com.example.E_commerce.controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.E_commerce.dto.OrderRequest;
import com.example.E_commerce.entity.Order;
import com.example.E_commerce.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Place order
//    @PostMapping
//    public Order placeOrder(@RequestBody Order order) {
//        return orderService.placeOrder(order);
//    }
    
  
    @PostMapping("/checkout")
    public Order checkout(@RequestParam Long userId){
        return orderService.checkout(userId);
    }
}
