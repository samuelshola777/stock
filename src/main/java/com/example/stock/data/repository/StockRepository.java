package com.example.stock.data.repository;

import com.example.stock.data.mode.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {

}
