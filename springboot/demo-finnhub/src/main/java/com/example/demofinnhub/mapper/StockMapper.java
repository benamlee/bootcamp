package com.example.demofinnhub.mapper;

import com.example.demofinnhub.model.CompanyProfile;
import com.example.demofinnhub.model.CompanyProfileDTO;
import com.example.demofinnhub.model.Stock;
import com.example.demofinnhub.model.StockDTO;

public class StockMapper {
    public static StockDTO map(Stock stock, CompanyProfile companyProfile) {
        CompanyProfileDTO cPDTO = CompanyProfileDTO.builder() //
                .country(companyProfile.getCountry()) //
                .companyName(companyProfile.getName()) //
                .ipoDate(companyProfile.getIpo()) //
                .logo(companyProfile.getLogo()) //
                .marketCap(companyProfile.getMarketCapitalization()) //
                .currency(companyProfile.getCurrency()) //
                .build();

        return StockDTO.builder() //
                .companyProfile(cPDTO) //
                .currentPrice(stock.getC()) //
                .dayHigh(stock.getH()) //
                .dayLow(stock.getL()) //
                .dayOpen(stock.getO()) //
                .build();
    }
}
