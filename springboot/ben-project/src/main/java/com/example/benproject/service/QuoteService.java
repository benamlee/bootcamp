package com.example.benproject.service;

import java.util.List;
import com.example.benproject.entity.Quote;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.model.dto.finnhub.resp.QuoteDTO;

public interface QuoteService {
    
    // web service, no database
    QuoteDTO getQuote(String symbol) throws FinnhubException;


    // database
    List<Quote> findAllQuotes();

}
