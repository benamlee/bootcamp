package com.example.benproject.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.benproject.entity.Quote;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.infra.Code;
import com.example.benproject.infra.Protocol;
import com.example.benproject.model.dto.finnhub.resp.QuoteDTO;
import com.example.benproject.repository.QuoteRepository;
import com.example.benproject.service.QuoteService;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier(value = "finnhubToken")
    private String token;

    @Value(value = "${api.finnhub.domain}")
    private String domain;

    @Value(value = "${api.finnhub.base-url}")
    private String baseUrl;

    @Value(value = "${api.finnhub.endpoints.stock.quote}")
    private String quoteEndpoint;


    // database
    @Autowired
    private QuoteRepository quoteRepository;

    @Override
    public QuoteDTO getQuote(String symbol) throws FinnhubException {
        String url = UriComponentsBuilder.newInstance() //
                .scheme(Protocol.HTTPS.name()) //
                .host(domain) //
                .pathSegment(baseUrl) //
                .path(quoteEndpoint) //
                .queryParam("symbol", symbol) //
                .queryParam("token", token) //
                .build() //
                .toUriString();
        System.out.println("url=" + url);
        // url="https://finnhub.io/api/v1/quote?symbol=AAPL&token=ck5rdg9r01qls0umc6mgck5rdg9r01qls0umc6n0";
        try {
            return restTemplate.getForObject(url, QuoteDTO.class);
        } catch (RestClientException e) {
            throw new FinnhubException(Code.FINNHUB_QUOTE_NOTFOUND);
        }
    }


    //database
    @Override
    public List<Quote> findAllQuotes(){
        return quoteRepository.findAll();
    }


}
