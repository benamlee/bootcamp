package com.example.demofinnhub;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
// import static org.mockito.ArgumentMatchers.isNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import com.example.demofinnhub.config.TestDatabaseConfig;
import com.example.demofinnhub.entity.Stock;
import com.example.demofinnhub.repository.StockRepository;


@DataJpaTest // inject Repository related Beans
@Import(TestDatabaseConfig.class)
@TestPropertySource(properties = {"spring.jpa.hibernate.ddl-auto=update"})
@TestMethodOrder(OrderAnnotation.class)
public class StockRepositoryTest {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private TestEntityManager entityManager;

    // @AfterEach
    // void console() {
    // System.out.println(stockRepository.findAll());
    // }

    @Test
    @Order(1)
    void testFindById() {
        Stock entity = new Stock();
        entity.setCountry("CN");
        entity.setCompanyName("Orange Company");
        entity.setMarketCap(98761234.23);
        entityManager.persist(entity); // JPA <-> cache memory <-> database harddisk
        entityManager.flush(); // Database commit; -> harddisk

        // I am testing the "select * from table where id = 15;"
        Stock stock = stockRepository.findById(1L).orElse(null);
        assertThat(stock, hasProperty("country", equalTo("CN")));
        assertThat(stock,
                hasProperty("companyName", equalTo("Orange Company")));

        Stock entity2 = new Stock();
        entity2.setCountry("US");
        entity2.setCompanyName("Apple Company");
        entityManager.persist(entity2);
        entityManager.flush();
        Stock stock2 = stockRepository.findById(2L).orElse(null);
        assertThat(stock2, hasProperty("country", equalTo("US")));
        assertThat(stock2,
                hasProperty("companyName", equalTo("Apple Company")));
    }

    @Test
    @Order(2)
    void testDeleteById() {
        Stock stock = new Stock();
        stock.setCountry("CN");
        stock.setCompanyName("Orange Company");
        stock.setMarketCap(98761234.23);
        // Use entityManager to save and get ID
        Long id = (Long) entityManager.persistAndGetId(stock);
        // Test case: JPA deleteById()
        stockRepository.deleteById(id);
        // Use entityManager to find by id
        Stock afterDeleted = entityManager.find(Stock.class, id);
        assertThat(afterDeleted, CoreMatchers.nullValue());
    }

    @Test
    @Order(3)
    void testSave() {
        Stock stock = new Stock();
        stock.setCountry("CN");
        stock.setCompanyName("Orange Company");
        stock.setMarketCap(98761234.23);
        // before save
        Stock beforeSave = entityManager.find(Stock.class, 4L);
        assertThat(beforeSave, CoreMatchers.nullValue());

        // Use repository to save
        stockRepository.save(stock);
        System.out.println("stock=" + stock);

        // after save
        Stock afterSave = entityManager.find(Stock.class, 4L);
        assertThat(afterSave, hasProperty("id", equalTo(4L)));
    }

    @Test
    @Order(4)
    void testFindAll() {
        Stock stock1 = new Stock();
        stock1.setCountry("UK");
        stock1.setCompanyName("UK Company");
        stock1.setMarketCap(98761234.23);

        Stock stock2 = new Stock();
        stock2.setCountry("SG");
        stock2.setCompanyName("SG Company");
        stock2.setMarketCap(98761234.23);

        // before save
        entityManager.persistAndFlush(stock1);
        entityManager.persistAndFlush(stock2);

        // Use repository to save
        List<Stock> afterSave = stockRepository.findAll();
        // System.out.println("stock=" + stock);

        // after save
        assertThat(afterSave, hasItem(hasProperty("country", equalTo("SG"))));
        assertThat(afterSave, hasItem(hasProperty("country", equalTo("UK"))));
    }


}

