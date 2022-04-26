package com.example.tema_10.controller;

import com.example.tema_10.model.Product;
import com.example.tema_10.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getAllProducts")
    public List<Product> getAll(){
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping("/addNewProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
}
