package com.example.demofinnhub.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
@Getter
@Builder
public class CompanyProfile {
    String country;
    String currency;
    String estimateCurrency;
    String exchange;
    String finnhubIndustry;
    LocalDate ipo;
    String logo;
    double marketCapitalization;
    String name;
    String phone;
    double shareOutstanding;
    String ticker;
    String weburl;
}
