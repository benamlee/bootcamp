package com.example.benproject.model.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.benproject.entity.CompanyProfile;
import com.example.benproject.entity.Quote;
import com.example.benproject.entity.StockSymbol;
import com.example.benproject.model.dto.finnhub.resp.CompanyProfile2DTO;
import com.example.benproject.model.dto.finnhub.resp.QuoteDTO;
import com.example.benproject.model.dto.finnhub.resp.SymbolDTO;
import com.example.benproject.model.dto.web.resp.CompanyProfileAndQuoteDTO;
import com.example.benproject.model.dto.web.resp.CompanyProfileTempDTO;
import com.example.benproject.model.graph.Candlestick;
import com.example.benproject.model.trade.TradeRecord;

@Component
public class FinnhubMapper {

  @Autowired
  private ModelMapper modelMapper;

  // return for web, directly return to service to controller, no use database
  public CompanyProfileAndQuoteDTO map(CompanyProfile2DTO companyProfile2DTO,
      QuoteDTO quoteDTO) {
    return CompanyProfileAndQuoteDTO.builder() //
        .companyProfileTempDTO(
            modelMapper.map(companyProfile2DTO, CompanyProfileTempDTO.class)) //
        .currentPrice(quoteDTO.getCurrentPrice()) //
        .dayHigh(quoteDTO.getDayHigh()) //
        .dayLow(quoteDTO.getDayLow()) //
        .dayOpen(quoteDTO.getDayOpen()) //
        .prevDayClose(quoteDTO.getPrevDayClose()) //
        .build();
  }

  
  // mapping for database table

  // Symbol
  public StockSymbol map(SymbolDTO symbol) {
    return StockSymbol.builder() //
        .symbol(symbol.getSymbol()) //
        .build();
  }

  // CompanyProfile
  public CompanyProfile map(CompanyProfile2DTO profile) {
    return CompanyProfile.builder() //
        .country(profile.getCountry()) //
        .companyName(profile.getCompanyName()) //
        .logo(profile.getLogo()) //
        .marketCap(profile.getMarketCap()) //
        .currency(profile.getCurrency()) //
        .build();
  }

  // Quote
  public Quote map(QuoteDTO quote) {
    return Quote.builder() //
        .currentPrice(quote.getCurrentPrice()) //
        .dayHigh(quote.getDayHigh()) //
        .dayLow(quote.getDayLow()) //
        .dayOpen(quote.getDayOpen()) //
        .prevDayClose(quote.getPrevDayClose()) //
        .build();
  }

  // graph for candlestick
  public List<Candlestick> map(List<TradeRecord> tradeRecords) {
    List<Candlestick> candlesticks = new LinkedList<>();
    // if no trade records, return empty list
    if (tradeRecords == null || tradeRecords.isEmpty())
      return candlesticks;

    Candlestick currentCandlestick = null;
    
    for (TradeRecord tradeRecord : tradeRecords) {
      if (currentCandlestick == null) {
        currentCandlestick = new Candlestick();
        currentCandlestick.setOpen(tradeRecord.getPrice());
        currentCandlestick.setLow(tradeRecord.getPrice());
        currentCandlestick.setHigh(tradeRecord.getPrice());
        currentCandlestick.setClose(tradeRecord.getPrice());
        currentCandlestick.setLocalDateTime(tradeRecord.getLocalDateTime());
        currentCandlestick.setVolumn(tradeRecord.getQuantity());
      }
      if (isSameMinute(currentCandlestick, tradeRecord)) {
        currentCandlestick.setClose(tradeRecord.getPrice());
        currentCandlestick.setHigh(Math.max(currentCandlestick.getHigh(), tradeRecord.getPrice()));
        currentCandlestick.setLow(Math.min(currentCandlestick.getLow(), tradeRecord.getPrice()));
        currentCandlestick.setVolumn(currentCandlestick.getVolumn() + tradeRecord.getQuantity());
      } else {
        while (!isPlusOneMinute(currentCandlestick, tradeRecord)) {
          candlesticks.add(currentCandlestick);
          Candlestick temp = currentCandlestick;
          currentCandlestick = new Candlestick();
          currentCandlestick.setOpen(temp.getClose());
          currentCandlestick.setLow(temp.getClose());
          currentCandlestick.setHigh(temp.getClose());
          currentCandlestick.setClose(temp.getClose());
          currentCandlestick.setLocalDateTime(temp.getLocalDateTime().plusMinutes(1));
        }
      }
      if (isPlusOneMinute(currentCandlestick, tradeRecord)){
        candlesticks.add(currentCandlestick);
        // 用完就 new
        currentCandlestick = new Candlestick();
        currentCandlestick.setOpen(tradeRecord.getPrice());
        currentCandlestick.setLow(tradeRecord.getPrice());
        currentCandlestick.setHigh(tradeRecord.getPrice());
        currentCandlestick.setClose(tradeRecord.getPrice());
        currentCandlestick.setLocalDateTime(tradeRecord.getLocalDateTime());
        currentCandlestick.setVolumn(tradeRecord.getQuantity());
      }
    }
    // add the last candlestick, if any
    if (currentCandlestick != null) {
      candlesticks.add(currentCandlestick);
    }
    return candlesticks;
  }

  // boolean for graph mapping
  private static boolean isSameMinute(Candlestick candlestick, TradeRecord tradeRecord) {
    if (candlestick == null)
      return false;
    LocalDateTime candlestickTime = candlestick.getLocalDateTime();
    LocalDateTime tradeRecordTime = tradeRecord.getLocalDateTime();
    return candlestickTime.getYear() == tradeRecordTime.getYear() && //
    candlestickTime.getMonth() == tradeRecordTime.getMonth() && //
    candlestickTime.getDayOfMonth() == tradeRecordTime.getDayOfMonth() && //
    candlestickTime.getHour() == tradeRecordTime.getHour() && //
    candlestickTime.getMinute() == tradeRecordTime.getMinute();
  }

  private static boolean isPlusOneMinute(Candlestick candlestick, TradeRecord tradeRecord) {
        if (candlestick == null)
      return false;
    LocalDateTime candlestickTime = candlestick.getLocalDateTime();
    LocalDateTime tradeRecordTime = tradeRecord.getLocalDateTime();
    return candlestickTime.getYear() == tradeRecordTime.getYear() && //
    candlestickTime.getMonth() == tradeRecordTime.getMonth() && //
    candlestickTime.getDayOfMonth() == tradeRecordTime.getDayOfMonth() && //
    candlestickTime.getHour() == tradeRecordTime.getHour() && //
    candlestickTime.getMinute() + 1 == tradeRecordTime.getMinute();
  }

}
