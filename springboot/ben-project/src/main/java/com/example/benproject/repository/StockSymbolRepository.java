package com.example.benproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.benproject.entity.StockSymbol;

@Repository
public interface StockSymbolRepository
        extends JpaRepository<StockSymbol, Long> {

}
