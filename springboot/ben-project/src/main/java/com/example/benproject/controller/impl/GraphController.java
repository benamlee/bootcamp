package com.example.benproject.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.benproject.controller.GraphOperation;
import com.example.benproject.model.graph.Candlestick;
import com.example.benproject.service.GraphService;

@RestController
@RequestMapping(value = "/api/v2")
public class GraphController implements GraphOperation{
    
    @Autowired
    private GraphService graphService;

    @Override
    public List<Candlestick> graph(){
        return graphService.graph();
    }

}
