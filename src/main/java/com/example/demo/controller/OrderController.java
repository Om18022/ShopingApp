package com.example.demo.controller;
import com.example.demo.Dto.orderResponse;
import com.example.demo.Entity.Order;
import com.example.demo.Services.CoupenServices;
import com.example.demo.Services.OrderService;
import com.example.demo.Services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    CoupenServices coupenServices;

    @Autowired
    PaymentServices paymentServices;
    @PostMapping("/addOrder")
    public ResponseEntity<Order> addOrder(@RequestParam long productId,@RequestParam int quantity,String coupen){
        try{
            coupenServices.checkCoupenUsed(coupen); //Coupen check for use one time
            return new ResponseEntity<>(orderService.saveOrder(productId,quantity,coupen), HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Print All Order Details Of Order Table
    @GetMapping("allOrders")
    public List<Order> getAllOrders(){
        return this.orderService.findAll();
    }

    @GetMapping({"/orders/{id}"})
    public ResponseEntity<orderResponse> getOrderById(@PathVariable("id") int id) {
        try {
            return this.orderService.getOrderById(id);
        } catch (Exception var3) {
            var3.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
