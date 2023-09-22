package com.example.demofinnhub.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demofinnhub.entity.Stock123;

@Repository
public interface StockRepository extends JpaRepository<Stock123, Long> {
  // select * from table where company_name = "";
  // List<Stock123> findByCompanyName(String companyName);

  // select * from table where country = "";
  List<Stock123> findByCountry(String country);

  // select * from table where country = "" and marketcap greater than
  // List<Stock123> findByCountryAndMarketCapGreaterThan(String country, double marketCap);

  // update stocks set field = x where field = ?
  // solution: (Put/ Patch) findById() -> set() -> save()

  // Native SQL query
  @Query(
      value = "select s.id, s.country, s.company_name, s.ipo_date, s.logo, s.currency, s.market_cap from finnhub_stocks s where s.id = :id",
      nativeQuery = true)
  List<Stock123> findAllById2(@Param(value = "id") Long id);

  // JPQL (Java Persistence query language)
  @Query(value = "select s from Stock123 s where s.id = :id") // Stock123 is class name have to use Uppercase
  List<Stock123> findAllById3(@Param(value = "id") Long id);

}
