package com.example.benproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.benproject.entity.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

}
