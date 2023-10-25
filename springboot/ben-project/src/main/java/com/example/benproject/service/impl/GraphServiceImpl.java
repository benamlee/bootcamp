package com.example.benproject.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.benproject.model.graph.Candlestick;
import com.example.benproject.model.mapper.FinnhubMapper;
import com.example.benproject.repository.TradeRecordRepository;
import com.example.benproject.service.GraphService;

@Service
public class GraphServiceImpl implements GraphService {

    @Autowired
    private FinnhubMapper finnhubMapper;

    @Autowired
    private TradeRecordRepository tradeRecordRepository;

    @Override
    public List<Candlestick> graph() {
        return finnhubMapper.map(tradeRecordRepository.findAll());
    }

}
