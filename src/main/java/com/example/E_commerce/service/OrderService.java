package com.example.E_commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.E_commerce.entity.Cart;
import com.example.E_commerce.entity.Order;
import com.example.E_commerce.entity.Product;
import com.example.E_commerce.repository.CartRepository;
import com.example.E_commerce.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    public Order checkout(Long userId){

        List<Cart> cartItems = cartRepository.findByUserId(userId);

        List<Product> products = cartItems.stream()
                .map(Cart::getProduct)
                .toList();

        Order order = new Order();
        order.setProducts(products);

        Order savedOrder = orderRepository.save(order);

        cartRepository.deleteAll(cartItems);

        return savedOrder;
    }

}