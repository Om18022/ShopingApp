package com.example.demo.Repository;

import com.example.demo.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    Payment findByOrderId(long orderId); //Find Payment for checking payment done or not
}
