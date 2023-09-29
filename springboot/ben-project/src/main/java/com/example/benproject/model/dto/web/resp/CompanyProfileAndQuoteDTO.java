package com.example.benproject.model.dto.web.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyProfileAndQuoteDTO {

    private CompanyProfileTempDTO companyProfileTempDTO;

    private double currentPrice;

    private double dayHigh;

    private double dayLow;

    private double dayOpen;

    private double prevDayClose;
}
