package com.example.benproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.infra.Code;
import com.example.benproject.infra.Protocol;
import com.example.benproject.model.dto.finnhub.resp.CompanyProfile2DTO;
import com.example.benproject.service.CompanyProfileService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyProfileServiceImpl implements CompanyProfileService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier(value = "finnhubToken")
    private String token;
  
    @Value(value = "${api.finnhub.domain}")
    private String domain;
  
    @Value(value = "${api.finnhub.base-url}")
    private String baseUrl;
  
    @Value(value = "${api.finnhub.endpoints.stock.profile2}")
    private String companyProfile2Endpoint;

    @Override
    public CompanyProfile2DTO getCompanyProfile(String symbol)
            throws FinnhubException {
        String url = UriComponentsBuilder.newInstance() //
                .scheme(Protocol.HTTPS.name().toLowerCase()) //
                .host(domain) //
                .pathSegment(baseUrl) //
                .path(companyProfile2Endpoint) //
                .queryParam("symbol", symbol) //
                .queryParam("token", token) //
                .build() //
                .toUriString();
                log.info("url = " + url);
        System.out.println("url=" + url);
        // url="https://finnhub.io/api/v1/stock/profile2?symbol=AAPL&token=ck5rdg9r01qls0umc6mgck5rdg9r01qls0umc6n0";
        try {
            CompanyProfile2DTO profile =
                    restTemplate.getForObject(url, CompanyProfile2DTO.class);
            return profile;
        } catch (RestClientException e) {
            throw new FinnhubException(Code.FINNHUB_PROFILE2_NOTFOUND);
        }
    }
}