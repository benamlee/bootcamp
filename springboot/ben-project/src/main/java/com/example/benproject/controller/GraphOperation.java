package com.example.benproject.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.benproject.model.graph.Candlestick;

public interface GraphOperation {
    
    @GetMapping(value = "/graph")
    List<Candlestick> graph();
}
