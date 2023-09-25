package com.example.demofinnhub.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.example.demofinnhub.entity.Stock;
import com.example.demofinnhub.entity.StockPrice;
import com.example.demofinnhub.exception.FinnhubException;
import com.example.demofinnhub.model.CompanyProfile;
import com.example.demofinnhub.model.Quote;
import com.example.demofinnhub.model.Symbol;
import com.example.demofinnhub.model.mapper.FinnhubMapper;
import com.example.demofinnhub.repository.StockPriceRepository;
import com.example.demofinnhub.repository.StockRepository;
import com.example.demofinnhub.service.CompanyService;
import com.example.demofinnhub.service.StockPriceService;
import com.example.demofinnhub.service.StockSymbolService;

@Profile("!test")
@Component
public class AppStartRunner implements CommandLineRunner {

  public static final List<String> stockInventory =
      List.of("AAPL", "MSFT", "TSLA");

  @Autowired
  private StockSymbolService stockSymbolService;

  @Autowired
  private StockPriceService stockPriceService;

  @Autowired
  private CompanyService companyService;

  @Autowired
  private StockRepository stockRepository;

  @Autowired
  private StockPriceRepository stockPriceRepository;

  @Autowired
  private FinnhubMapper finnhubMapper;

  @Override
  public void run(String... args) throws FinnhubException {
    // Before Server Start:
    // 0. Get all symbols (US) from the API
    // https://finnhub.io/api/v1/stock/symbol?exchange=US&token=ck5rdg9r01qls0umc6mgck5rdg9r01qls0umc6n0
    // 1. Get All Company Profile2 and insert into database
    // 2. Get Stock price and insert into database

    // stockPriceRepository.deleteAll(); // before all clear data
    // companyService.deleteAll();
    // stockSymbolService.deleteAll();

    // Call API to get all symbols
    List<Symbol> symbols = stockSymbolService.getAllSymbols().stream()
        .filter(symbol -> stockInventory.contains(symbol))
        .collect(Collectors.toList());
    System.out.println("All Symbols are inserted.");
    // 1. Save all symbols
    stockSymbolService.save(symbols).stream() //
        // .limit(10L) // limit 10 stocks
        .forEach(symbol -> {
          try {
            // 2. Get Compnay Profile 2 and insert into database
            CompanyProfile companyProfile =
                companyService.getCompanyProfile(symbol.getSymbol());
            Stock stock = finnhubMapper.map(companyProfile);
            stock.setStockSymbol(symbol);
            Stock storedStock = stockRepository.save(stock);
            System.out.println("completed symbol=" + symbol.getSymbol());

            // 3. Get Stock price and insert into database
            Quote quote = stockPriceService.getQuote(symbol.getSymbol());
            StockPrice stockPrice = finnhubMapper.map(quote);
            stockPrice.setStock(storedStock);
            stockPriceRepository.save(stockPrice);
            System.out.println("completed symbol=" + symbol.getSymbol());
          } catch (FinnhubException e) {
            System.out
                .println("RestClientException: Symbol" + symbol.getSymbol());
          }
        });
    System.out.println("Stocks in inventory are inserted.");
    System.out.println("CommandLineRunner Completed");
    SchedulerTaskConfig.start = true;

  }

}
