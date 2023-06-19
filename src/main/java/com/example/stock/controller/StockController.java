package com.example.stock.controller;

import com.example.stock.dto.request.ChangeStockDetails;
import com.example.stock.dto.request.StockRequest;
import com.example.stock.dto.response.StockResponse;
import com.example.stock.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/stocks")
public class StockController {
    private final StockService stockService;
    @PostMapping("/createNewStock")
    public ResponseEntity<?> createNewStock(@RequestBody StockRequest request){
        return new ResponseEntity<>(stockService.createStock(request), HttpStatus.CREATED);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> findStockById(@PathVariable long id){
        return new ResponseEntity<>(stockService.findById(id), HttpStatus.FOUND);
    }
    @PutMapping("changeStockName")
    public ResponseEntity<?> changeStock(@RequestParam long id,@RequestParam String newName){
        return new ResponseEntity<>(stockService.changeStockName(id,newName),HttpStatus.ACCEPTED);
    }
    @PutMapping("changeStockPrice")
    public ResponseEntity<?> changeStockPrice(@RequestParam long id, @RequestParam double newPrice){
        return new ResponseEntity<>(stockService.changeStockPrice(id, newPrice),HttpStatus.ACCEPTED);
    }
    @PutMapping("changeStockDetails")
    public ResponseEntity<?> changeStockDetails(@RequestBody ChangeStockDetails changeStockDetails){
        return new ResponseEntity<>(stockService.changeStockDetails(changeStockDetails),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("deleteStockById")
    public void deleteStockById(@RequestParam long id){
        stockService.deleteStockById(id);
    }

    @GetMapping("/getAllStock")
    public ResponseEntity<List<StockResponse>> getAllStock(){
        return new ResponseEntity<>(stockService.getAllStock(),HttpStatus.FOUND);
    }
    @GetMapping("getTheNumber")
    public ResponseEntity<?> getTheNumberOfStock(){
        return new ResponseEntity<>(stockService.countNumberOfStock(),HttpStatus.OK);
    }
}
