package com.example.E_commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.E_commerce.entity.Cart;
import com.example.E_commerce.entity.Product;
import com.example.E_commerce.entity.User;
import com.example.E_commerce.repository.CartRepository;
import com.example.E_commerce.repository.ProductRepository;
import com.example.E_commerce.repository.UserRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;
    public Cart addToCart(Long userId, Long productId){

        User user = userRepository.findById(userId).orElse(null);

        Product product = productRepository.findById(productId).orElse(null);

        Cart cart = new Cart();

        cart.setUser(user);
        cart.setProduct(product);
        cart.setPrice(product.getPrice());
        cart.setQuantity(1);

        return cartRepository.save(cart);
    }

    public List<Cart> getCartByUser(Long userId){

        return cartRepository.findByUserId(userId);
    }
    public void removeItem(Long id){
        cartRepository.deleteById(id);
    }

 }
