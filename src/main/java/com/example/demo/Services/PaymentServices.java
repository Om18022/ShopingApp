package com.example.demo.Services;

import com.example.demo.Entity.Order;
import com.example.demo.Entity.Payment;
import com.example.demo.Repository.OrderRepo;
import com.example.demo.Repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
public class PaymentServices {

    @Autowired
    PaymentRepo paymentRepo;
    @Autowired
    OrderRepo orderRepo;
    public Payment makePayment(long orderId) {
        Optional<Order> orderOptional = orderRepo.findById(orderId);
        if (!orderOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }
        Order order = orderOptional.get();

        Payment payment = paymentRepo.findByOrderId(orderId);
        if (payment!=null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order is already paid");
        }

        Payment payment1 = new Payment();
        payment1.setOrderId(orderId);
        payment1.setStatus("Success");
        return paymentRepo.save(payment1);
    }
}
