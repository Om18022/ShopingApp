package com.example.demo.Services;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;
    public Product save(Product product) {
        return productRepo.save(product);
    }

    public Product addOrder(long productId, int quantity) {
        Product product = productRepo.findById(productId).get();
        if(product == null){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Product Id.");
        }
        if(quantity < 1 || quantity > product.getQuantity()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Quantity.");
        }
        product.setQuantity(product.getQuantity()-quantity);
        product.setTotalOrders(product.getTotalOrders()+1);
        return productRepo.save(product);
    }
    public List<Product> findAll() {
        return productRepo.findAll();
    }
}
