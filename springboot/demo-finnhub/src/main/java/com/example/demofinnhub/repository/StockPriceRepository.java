package com.example.demofinnhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demofinnhub.entity.StockPrice;


@Repository // this interface is like query in SQL
public interface StockPriceRepository extends JpaRepository<StockPrice,Long>{
    // in the back, it will generate many class to do new obj doing things
}
