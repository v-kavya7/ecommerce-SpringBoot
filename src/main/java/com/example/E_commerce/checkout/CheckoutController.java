package com.example.E_commerce.checkout;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.E_commerce.entity.Order;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping("/{userId}")
    public Order checkout(@PathVariable Long userId) {
        return checkoutService.checkout(userId);
    }

}
