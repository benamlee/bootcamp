package com.example.demofinnhub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDTO {
    // @JsonProperty("companyProfile")
    CompanyProfileDTO companyProfile;
    double currentPrice;
    double dayHigh;
    double dayLow;
    double dayOpen;
    double prevDayClose;
}
