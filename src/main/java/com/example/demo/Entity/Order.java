package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long OrderId;
    int quantity;
    int amount;
    Date date;
    long productid;
    String coupen;
}
