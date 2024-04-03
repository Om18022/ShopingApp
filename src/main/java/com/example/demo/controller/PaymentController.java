package com.example.demo.controller;

import com.example.demo.Entity.Payment;
import com.example.demo.Services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PaymentController {

    @Autowired
    PaymentServices paymentServices;

    //Make Order Payment Using orderId
    @PostMapping("/payment/{orderId}")
    public Payment makePayment(@PathVariable long orderId){
        try {
            return paymentServices.makePayment(orderId);
        }catch (ResponseStatusException ex){
            throw ex;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error.");
        }
    }
}
