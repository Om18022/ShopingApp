package com.example.demo.Repository;

import com.example.demo.Entity.Coupen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoupenRepo extends JpaRepository<Coupen, Long> {
    Coupen findByName(String coupenName); //Find coupen using coupenName
}
