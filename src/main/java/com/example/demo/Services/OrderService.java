package com.example.demo.Services;

import com.example.demo.Dto.orderResponse;
import com.example.demo.Entity.*;
import com.example.demo.Repository.CoupenRepo;
import com.example.demo.Repository.OrderRepo;
import com.example.demo.Repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;
    @Autowired
    ProductService productService;
    @Autowired
    CoupenRepo coupenRepo;

    @Autowired
    PaymentRepo paymentRepo;
    public Order saveOrder(long productId, int quantity, String coupen) {
        Product product = productService.addOrder(productId, quantity);
        int amount = product.getAmount() * quantity;
        Coupen coupen1 = coupenRepo.findByName(coupen);
        if(coupen1 != null){
            int disc = product.getAmount() * coupen1.getDisc() / 100;
            if(coupen1.isUsed()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Coupen.");
            }
            coupen1.setUsed(true);
            coupenRepo.save(coupen1);
            amount = amount - disc;
        }
        Order order = new Order();
        order.setQuantity(quantity);
        order.setAmount(amount);
        order.setDate(new Date());
        order.setProductid(productId);
        order.setCoupen(coupen);

        return orderRepo.save(order);
    }

    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    public ResponseEntity<orderResponse> getOrderById(int id) {
        try {
            Order order = this.orderRepo.findById((long) id).get();
            Payment payment =  this.paymentRepo.findByOrderId(id);
            if(order != null && payment != null){
                return new ResponseEntity<>(makeResponse(order,payment),HttpStatus.OK);
            }
            return new ResponseEntity<>(new orderResponse(),HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new orderResponse(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private orderResponse makeResponse(Order order, Payment payment) {
        orderResponse orderResponse = new orderResponse();
        orderResponse.setAmount(order.getAmount());
        orderResponse.setCoupen(order.getCoupen());
        orderResponse.setDate(order.getDate());
        orderResponse.setOrderId(order.getOrderId());
        orderResponse.setProductid(order.getProductid());
        orderResponse.setQuantity(order.getQuantity());
        orderResponse.setStatus(payment.getStatus());
        orderResponse.setTransactionid(payment.getTransactionid());
        return orderResponse;
    }
}