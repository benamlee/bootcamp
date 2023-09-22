package com.example.demofinnhub;

import java.time.LocalDate;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import com.example.demofinnhub.entity.Stock123;
import com.example.demofinnhub.exception.STKException;
import com.example.demofinnhub.model.CompanyProfile;
import com.example.demofinnhub.model.Stock;
import com.example.demofinnhub.repository.StockRepository;
import com.example.demofinnhub.service.FinService;

// @DataJpaTest
@SpringBootTest
public class FinServiceTest { // this class is to test methods

        @MockBean // service will autowired repository
        private StockRepository stockRepository;
      
        @MockBean
        private RestTemplate restTemplate;
       
        @Autowired
        private FinService finService;

@Autowired
private String finnhubToken;

        // Hamcrest, hasItem() -> test Array
        @Test
        void testFindAll() {
                Stock123 stock1 =
                                Stock123.builder().id(1L).country("US").build();
                Stock123 stock2 =
                                Stock123.builder().id(2L).country("CN").build();
                Mockito.when(stockRepository.findAll())
                                .thenReturn(List.of(stock1, stock2)); // mock走不相關的method，去test

                List<Stock123> stocks = finService.findAll(); // call stockRepository.findAll()
                assertThat(stocks,
                                hasItem(hasProperty("country", equalTo("CN"))));
                assertThat(stocks,
                                hasItem(hasProperty("country", equalTo("US"))));
                assertThat(stocks, not(hasItem(
                                hasProperty("country", equalTo("HK")))));
        }

        @Test // Test-driven development (TDD)
        void testRestTemplate() throws STKException {
                // ...
                String expectedUrl =
                                "HTTPS://finnhub.io/api/v1/stock/profile2?symbol=AAPL&token=".concat(finnhubToken);
                CompanyProfile mockedCompanyProfile = CompanyProfile.builder() //
                                .country("TT") //
                                .ipo(LocalDate.of(1988, 8, 8)) //
                                .build();
                Mockito.when(restTemplate.getForObject(expectedUrl,
                                CompanyProfile.class))
                                .thenReturn(mockedCompanyProfile);

                CompanyProfile profile = finService.findProfile("AAPL"); // call stockRepository.findAll()
                assertThat(profile, hasProperty("country", equalTo("TT"))); // has used this mockedcompanyprofile

        }

}
