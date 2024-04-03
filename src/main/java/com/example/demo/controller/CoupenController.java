package com.example.demo.controller;

import com.example.demo.Entity.Coupen;
import com.example.demo.Services.CoupenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoupenController {

    @Autowired
    CoupenServices coupenServices;

    //Add New Coupen Api
    @PostMapping("addCoupen")
    public Coupen addCoupen(@RequestBody Coupen coupen){
        return coupenServices.saveCoupen(coupen);
    }

    //Print All Coupen
    @GetMapping("fetchCoupen")
    public List<CoupenServices.CoupenDto> getCoupen(){
        return this.coupenServices.findAll();
    }
}
