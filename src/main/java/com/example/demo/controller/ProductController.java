package com.example.demo.controller;

import com.example.demo.Entity.Product;
import com.example.demo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    //Add New Product
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.save(product);
    }

    //Print Inventory Of Products
    @GetMapping("inventory")
    public List<Product> getProductsInventory(){
        return  this.productService.findAll();
    }
}
