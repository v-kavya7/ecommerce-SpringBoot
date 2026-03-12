package com.example.E_commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_commerce.entity.Product;
import com.example.E_commerce.service.ProductService;
import com.example.E_commerce.service.RecommendationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService productService;
  @PostMapping
  public Product addProduct(@RequestBody Product product) {
	  return productService.saveProduct(product);
  }
  @GetMapping
  public List<Product> getAllProducts(){
	  return productService.getAllProducts();
  }
  @GetMapping("/{id}")
  public Product getProductById(@PathVariable Long id) {
	  return  productService.getProductById(id);
  }
  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable Long id) {
	  productService.deleteProduct(id);
  }
  @Autowired
  RecommendationService recommendationService;
  @GetMapping("/recommendations")
  public String getRecommendations(@RequestParam String product) {
      return recommendationService.getRecommendations(product);
  }
}
