package com.example.benproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.benproject.model.trade.TradeRecord;

@Repository
public interface TradeRecordRepository
                extends JpaRepository<TradeRecord, Long> {

}
