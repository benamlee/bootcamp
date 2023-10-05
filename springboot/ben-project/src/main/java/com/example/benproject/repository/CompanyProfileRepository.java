package com.example.benproject.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.benproject.entity.CompanyProfile;
import com.example.benproject.entity.StockSymbol;


@Repository
public interface CompanyProfileRepository extends JpaRepository<CompanyProfile, Long>{
    
    // self write to use
    Optional<CompanyProfile> findByStockSymbol(StockSymbol stockSymbol);

}
