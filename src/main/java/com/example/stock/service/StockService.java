package com.example.stock.service;


import com.example.stock.data.mode.Stock;
import com.example.stock.dto.request.ChangeStockDetails;
import com.example.stock.dto.request.StockRequest;
import com.example.stock.dto.response.StockResponse;
import com.example.stock.exception.FindingStockException;
import org.springframework.data.domain.Page;

import javax.net.ssl.SSLSession;
import java.util.List;

public interface StockService {
    StockResponse createStock(StockRequest stockRequest);

    long countNumberOfStock();

    void deleteAllStock();

    Stock findById(long id) throws FindingStockException;

    StockResponse changeStockName(long id, String newStockName);

   StockResponse changeStockPrice(long id, double newPrice);

  StockResponse changeStockDetails(ChangeStockDetails changeStockDetails);

    void deleteStockById(long id);

   List<StockResponse> getAllStock();
}
