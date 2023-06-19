package com.example.stock.serviceImpl;

import com.example.stock.data.mode.Stock;
import com.example.stock.data.repository.StockRepository;
import com.example.stock.dto.request.ChangeStockDetails;
import com.example.stock.dto.request.StockRequest;
import com.example.stock.dto.response.StockResponse;
import com.example.stock.exception.FindingStockException;
import com.example.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;


    public StockResponse createStock(StockRequest stockRequest){
        Stock stock = mapToStockEntity(stockRequest);
    stockRepository.save(stock);
    return mapToResponse(stock);
    }



    @Override
    public long countNumberOfStock() {
        return stockRepository.count();
    }

    @Override
    public void deleteAllStock() {
        stockRepository.deleteAll();
    }

    @Override
    public Stock findById(long id)  {
        return stockRepository.findById(id).orElseThrow(()-> new FindingStockException("Stock with the id " +id + " not found"));
    }

    @Override
    public StockResponse changeStockName(long id, String newStuckName) {
        Stock stock = stockRepository.findById(id).orElseThrow(()-> new FindingStockException("Stock with the id " +id + " not found")) ;
        stock.setStockName(newStuckName);
        stock.setLastUpdated(LocalDateTime.now());
        stockRepository.save(stock);
        return mapToResponse(stock);
    }

    @Override
    public StockResponse changeStockPrice(long id, double newPrice) {
        Stock stock = stockRepository.findById(id).orElseThrow(()-> new FindingStockException("Could not find stock with id " + id));
        stock.setStockPrice(newPrice);
        stock.setLastUpdated(LocalDateTime.now());
        stockRepository.save(stock);
        return mapToResponse(stock);
    }

    @Override
    public StockResponse changeStockDetails( ChangeStockDetails changeStockDetails) {
        Stock stock = stockRepository.findById(changeStockDetails.getStockId()).orElseThrow(()-> new FindingStockException("Could not find stock with id " + changeStockDetails.getStockId()));
       stock.setStockName(changeStockDetails.getStockName());
       stock.setStockPrice(changeStockDetails.getStockPrice());
       stock.setLastUpdated(LocalDateTime.now());
       stockRepository.save(stock);
        return mapToResponse(stock);
    }

    @Override
    public void deleteStockById(long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(()-> new FindingStockException("Could not find Stock with the Id " + id));
        stockRepository.delete(stock);
    }

    @Override
    public List<StockResponse> getAllStock() {
        List<Stock> listOfStock = stockRepository.findAll();
        List<StockResponse> responseList = new ArrayList<>();
        for (Stock aStock : listOfStock) {
            responseList.add(mapToResponse(aStock));
        }
        return responseList;
    }


    public Stock mapToStockEntity(StockRequest stockRequest){
   return Stock.builder()
   .stockName(stockRequest.getStockName())
    .stockPrice(stockRequest.getStockPrice())
    .createTime(LocalDateTime.now())
    .lastUpdated(LocalDateTime.now()).build();
    }
    public StockResponse mapToResponse(Stock stock) {
        return StockResponse.builder().price(stock.getStockPrice())
                .name(stock.getStockName())
                .createTime(stock.getCreateTime())
                .lastUpdated(stock.getLastUpdated())
                .build();
    }
}
