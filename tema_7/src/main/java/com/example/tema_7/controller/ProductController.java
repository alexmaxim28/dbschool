package com.example.tema_7.controller;

import com.example.tema_7.model.Product;
import com.example.tema_7.repository.ProductRepository;
import com.example.tema_7.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public void addNewProduct(@RequestBody Product p) {
        productService.addProduct(p);
    }

    @DeleteMapping("/products/{id}")
    public void removeProduct(@PathVariable Integer id) {
        productService.removeProduct(getProductById(id));
    }

}
