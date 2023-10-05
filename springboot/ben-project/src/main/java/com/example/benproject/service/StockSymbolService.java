package com.example.benproject.service;

import java.util.List;
import com.example.benproject.entity.StockSymbol;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.model.dto.finnhub.resp.SymbolDTO;

public interface StockSymbolService {

    // no database
    List<SymbolDTO> getAllSymbols() throws FinnhubException;

    // database
    List<StockSymbol> save(List<SymbolDTO> symbolDTOs);

    
    // void deleteAll();

}
