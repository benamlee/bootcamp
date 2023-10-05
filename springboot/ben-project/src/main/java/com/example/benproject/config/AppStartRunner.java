package com.example.benproject.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.benproject.entity.CompanyProfile;
import com.example.benproject.entity.Quote;
import com.example.benproject.exception.FinnhubException;
import com.example.benproject.model.dto.finnhub.resp.CompanyProfile2DTO;
import com.example.benproject.model.dto.finnhub.resp.QuoteDTO;
import com.example.benproject.model.dto.finnhub.resp.SymbolDTO;
import com.example.benproject.model.mapper.FinnhubMapper;
import com.example.benproject.repository.CompanyProfileRepository;
import com.example.benproject.repository.QuoteRepository;
import com.example.benproject.service.CompanyProfileService;
import com.example.benproject.service.QuoteService;
import com.example.benproject.service.StockSymbolService;

// @Profile
@Component
public class AppStartRunner implements CommandLineRunner {

    @Autowired
    private StockSymbolService stockSymbolService;

    @Autowired
    private FinnhubMapper finnhubMapper;

    @Autowired
    private CompanyProfileService companyProfileService;
    @Autowired
    private CompanyProfileRepository companyProfileRepository;

    @Autowired
    private QuoteService quoteService;
    @Autowired
    private QuoteRepository quoteRepository;



    // database save for these symbols
    public static final List<String> stockInventory =
            List.of("AAPL", "MSFT", "TSLA");

    @Override
    public void run(String... args) throws FinnhubException {

        // before server start:
        // get all symbols (US) from the API
        // save symbols into database

        

        // call api to get all symbols
        List<SymbolDTO> symbolDTOs = stockSymbolService.getAllSymbols() // call api
                .stream() //
                .filter(symbol -> stockInventory.contains(symbol.getSymbol())) // boolean (only the static list of symbol will save)
                .collect(Collectors.toList()); //
        System.out.println(
                "All Symbols are inserted into finnhub_stock_symbol. No of Symbols=" + symbolDTOs.size());

        // save symbols into database
        // also save companyprofile and quote into database
        stockSymbolService.save(symbolDTOs) //
        .stream() //
        .forEach(symbol -> {
            try{
                // companyprofile2 database
                // call api
                CompanyProfile2DTO companyProfile2DTO = companyProfileService.getCompanyProfile(symbol.getSymbol());
                // entity
                CompanyProfile companyProfile = finnhubMapper.map(companyProfile2DTO); // map
                companyProfile.setStockSymbol(symbol); // void setter
                // save company profile
                companyProfileRepository.save(companyProfile); // finish map + set
                System.out.println("completed symbol=" + symbol.getSymbol());

                // quote database
                // call api 
                QuoteDTO quoteDTO = quoteService.getQuote(symbol.getSymbol());
                Quote quote = finnhubMapper.map(quoteDTO);
                quote.setCompanyProfile(companyProfile);
                // save quote
                quoteRepository.save(quote);
                System.out.println("completed symbol=" + symbol.getSymbol());

                // get symbol, skipped

            }catch(FinnhubException e) {
                System.out.println("RestClientException: Symbol" + symbol.getSymbol());
            }
        });
        System.out.println("Stocks in Inventory are inserted.");
        System.out.println("CommandLineRunner Completed.");

        // Scheduler Task start
        SchedulerTaskConfig.start = true;
    }
}
