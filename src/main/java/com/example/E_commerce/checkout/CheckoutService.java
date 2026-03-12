package com.example.E_commerce.checkout;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.E_commerce.entity.Cart;
import com.example.E_commerce.entity.Order;
import com.example.E_commerce.repository.CartRepository;
import com.example.E_commerce.repository.OrderRepository;

@Service
public class CheckoutService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Order checkout(Long userId){

        List<Cart> cartItems = cartRepository.findByUserId(userId);

        double total = 0;

//        for(Cart item : cartItems){
//            total += item.getPrice() * item.getQuantity();
//        }

        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(total);
        order.setStatus("PLACED");

        Order savedOrder = orderRepository.save(order);

        cartRepository.deleteAll(cartItems);

        return savedOrder;
    }
}