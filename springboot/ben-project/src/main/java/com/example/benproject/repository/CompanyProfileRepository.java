package com.example.benproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.benproject.entity.CompanyProfile;

@Repository
public interface CompanyProfileRepository extends JpaRepository<CompanyProfile, Long>{
    
    
}
