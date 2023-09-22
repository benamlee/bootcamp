package com.example.demofinnhub;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.mockito.ArgumentMatchers.isNotNull;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import com.example.demofinnhub.entity.Stock123;
import com.example.demofinnhub.model.Stock;
import com.example.demofinnhub.repository.StockRepository;

@DataJpaTest // inject Repository related Beans
@Import(TestDatabaseConfig.class)
@TestPropertySource(properties = {"spring.jpa.hibernate.ddl-auto=update"})
public class StockRepositoryTest {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @Order(1)
    void testFindById() {
        Stock123 entity = new Stock123();
        // entity.setId(15L);
        entity.setCountry("CN");
        entity.setCompanyName("Orange Company");
        entity.setMarketCap(98761234.23);
        entityManager.persist(entity); // JPA <-> cache memory <-> database harddisk
        entityManager.flush(); // Database commit; -> harddisk

        // I am testing the "select * from table where id = 15;"
        Stock123 stock = stockRepository.findById(1L).orElse(null);
        assertThat(stock, hasProperty("country", equalTo("CN")));
        assertThat(stock,
                hasProperty("companyName", equalTo("Orange Company")));

        Stock123 entity2 = new Stock123();
        entity2.setCountry("US");
        entity2.setCompanyName("Apple Company");
        entityManager.persist(entity2);
        entityManager.flush();
        Stock123 stock2 = stockRepository.findById(2L).orElse(null);
        assertThat(stock2, hasProperty("country", equalTo("US")));
        assertThat(stock2,
                hasProperty("companyName", equalTo("Apple Company")));

    }

    @Test
    @Order(2)
    void testDeleteById() {
        Stock123 stock = new Stock123();
        stock.setCountry("CN");
        stock.setCompanyName("Orange Company");
        stock.setMarketCap(98761234.23);
        // Use entityManager to save and get ID
        Long id = (Long) entityManager.persistAndGetId(stock);
        // Test case: JPA deleteById()
        stockRepository.deleteById(id);
        // Use entityManager to find by id
        Stock123 afterDeleted = entityManager.find(Stock123.class, id);
        assertThat(afterDeleted, CoreMatchers.nullValue());
    }

    @Test
    @Order(3)
    void testSave() {
        Stock123 stock = new Stock123();
        stock.setCountry("CN");
        stock.setCompanyName("Orange Company");
        stock.setMarketCap(98761234.23);
        // before save
        Stock123 beforeSave = entityManager.find(Stock123.class, 4L);
        assertThat(beforeSave, CoreMatchers.nullValue());

        // Use repository to save
        stockRepository.save(stock);
        System.out.println("stock=" + stock);

        // after save
        Stock123 afterSave = entityManager.find(Stock123.class, 4L);
        assertThat(afterSave, hasProperty("id", equalTo(4L)));
    }

    @Test
    @Order(4)
    void testFindAll() {
        Stock123 stock1 = new Stock123();
        stock1.setCountry("UK");
        stock1.setCompanyName("UK Company");
        stock1.setMarketCap(98761234.23);

        Stock123 stock2 = new Stock123();
        stock2.setCountry("SG");
        stock2.setCompanyName("SG Company");
        stock2.setMarketCap(98761234.23);

        // before save
        entityManager.persistAndFlush(stock1);
        entityManager.persistAndFlush(stock2);

        // Use repository to save
        List<Stock123> afterSave = stockRepository.findAll();
        // System.out.println("stock=" + stock);

        // after save
        assertThat(afterSave, hasItem(hasProperty("country", equalTo("SG"))));
        assertThat(afterSave, hasItem(hasProperty("country", equalTo("UK"))));
    }
}
