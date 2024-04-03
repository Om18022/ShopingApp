//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class orderResponse {
    long OrderId;
    int quantity;
    int amount;
    Date date;
    long productid;
    String coupen;
    long transactionid;
    String status;
}
