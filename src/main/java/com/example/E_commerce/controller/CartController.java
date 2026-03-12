package com.example.E_commerce.controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.E_commerce.entity.Cart;
import com.example.E_commerce.service.CartService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Add to cart
    @PostMapping("/add")
    public Cart addToCart(@RequestParam Long userId,
                          @RequestParam Long productId){

        return cartService.addToCart(userId, productId);
    }
    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable Long userId){
        return cartService.getCartByUser(userId);
    }
    @DeleteMapping("/remove/{id}")
    public void removeItem(@PathVariable Long id){
        cartService.removeItem(id);
    }

//    @DeleteMapping("/clear/{userId}")
//    public void clearCart(@PathVariable Long userId){
//        cartService.clearCart(userId);
//    }
}
