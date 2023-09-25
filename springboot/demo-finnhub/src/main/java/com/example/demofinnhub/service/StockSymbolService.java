package com.example.demofinnhub.service;

import java.util.List;
import com.example.demofinnhub.entity.StockSymbol;
import com.example.demofinnhub.exception.FinnhubException;
import com.example.demofinnhub.model.Symbol;

public interface StockSymbolService {

  List<Symbol> getAllSymbols() throws FinnhubException;

  List<StockSymbol> save(List<Symbol> symbols);

  void deleteAll();

}
