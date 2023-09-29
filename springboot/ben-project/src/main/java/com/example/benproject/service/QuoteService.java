package com.example.benproject.service;

import com.example.benproject.exception.FinnhubException;
import com.example.benproject.model.dto.finnhub.resp.QuoteDTO;

public interface QuoteService {

    QuoteDTO getQuote(String symbol) throws FinnhubException;

}
