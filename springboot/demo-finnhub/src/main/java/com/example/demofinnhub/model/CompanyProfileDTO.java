package com.example.demofinnhub.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyProfileDTO {
    
String country;
// @JsonProperty("companyName")
String companyName;
// @JsonProperty("ipoDate")
LocalDate ipoDate;
String logo;
// @JsonProperty("marketCap")
double marketCap;
String currency;




}
