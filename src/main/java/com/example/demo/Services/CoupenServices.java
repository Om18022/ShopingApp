package com.example.demo.Services;

import com.example.demo.Entity.Coupen;
import com.example.demo.Repository.CoupenRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Data
public class CoupenServices {
    @Autowired
    CoupenRepo coupenRepo;

    //Coupen save
    public Coupen saveCoupen(Coupen coupen) {
        return coupenRepo.save(coupen);
    }

    //Check Coupen In One Time Used Or Not
    public void checkCoupenUsed(String coupenName) {
        Coupen coupen = coupenRepo.findByName(coupenName);
        if(coupen != null && coupen.isUsed()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Coupen");
        }
    }

    //Print All Coupen
    public List<CoupenDto> findAll() {
        return coupenRepo.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public CoupenDto convertToDto(Coupen coupen){
        CoupenDto coupenDto = new CoupenDto();
        coupenDto.setName(coupen.getName());
        coupenDto.setDisc(coupen.getDisc());
        return coupenDto;
    }

    public static class CoupenDto{
        public String name;
        public double disc;

        public void setName(String name) {
            this.name = name;
        }
        public void setDisc(double disc){
            this.disc=disc;
        }
    }
}
