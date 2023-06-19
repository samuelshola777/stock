package com.example.stock.service;

import com.example.stock.data.mode.Stock;
import com.example.stock.dto.request.ChangeStockDetails;
import com.example.stock.dto.request.StockRequest;
import com.example.stock.dto.response.StockResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

public class StockServiceTest {
@Autowired
private StockService stockService;

    StockRequest stockRequest;
    StockRequest stockRequest1;
    StockRequest stockRequest2;

    ChangeStockDetails changeStockDetails;
    @BeforeEach
    void setUp() {

        changeStockDetails = new ChangeStockDetails();
        changeStockDetails.setStockId(2);
        changeStockDetails.setStockName("pepsi");
        changeStockDetails.setStockPrice(1500.0);


        stockRequest = new StockRequest();
        stockRequest.setStockName("iphone7");
        stockRequest.setStockPrice(7000.0);

        stockRequest1 = new StockRequest();
        stockRequest1.setStockName("iphone8");
        stockRequest1.setStockPrice(8000.0);

        stockRequest2  = new StockRequest();
        stockRequest2.setStockName("iphone9");
        stockRequest2.setStockPrice(9000.0);
    }

    @AfterEach
    void tearDown() {
    }

@Disabled
    @Test
    void testThatWaCreateStockRequest(){

        assertNotNull(stockService.createStock(stockRequest1));
        assertNotNull(stockService.createStock(stockRequest2));
        assertNotNull(stockService.createStock(stockRequest));
assertEquals(3, stockService.countNumberOfStock());
    }
@Test
void testThatWeCanFindById(){
    assertEquals(2, stockService.findById(2).getId());
    }
@Disabled
@Test
    void testThaWeCanDeleteAllStock(){
        stockService.deleteAllStock();
    assertEquals(0, stockService.countNumberOfStock());
  }
  @Test
    void testThatWeCanChangeStuckName(){
        assertEquals("techno-Spark7", stockService.changeStockName(3,"techno-Spark7").getName());
  }
  @Test
    void testThaTWeCanChangeStuckPrice(){
        assertEquals(15000.0, stockService.changeStockPrice(2,15000.0).getPrice());
  }
  @Test
    void testThatWeCanChangeBothPriceAndName(){
    assertEquals(1500.0, stockService.changeStockDetails( changeStockDetails ).getPrice());
    assertEquals("pepsi", stockService.changeStockDetails( changeStockDetails ).getName());
  }

  @Test
    void testThatWeCanDeleteStock(){
        stockService.deleteStockById(1);
assertEquals(1, stockService.countNumberOfStock());
  }
  @Test
    void testThatWeCanGetAllStock(){
      List<StockResponse> stockList = stockService.getAllStock();
        assertNotNull(stockList);
  }

}