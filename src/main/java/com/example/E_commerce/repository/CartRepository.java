package com.example.E_commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.E_commerce.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
	 List<Cart> findByUserId(Long userId);
	  void deleteByUserId(Long userId);
}
