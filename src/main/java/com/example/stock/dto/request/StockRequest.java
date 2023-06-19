package com.example.stock.dto.request;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class StockRequest {
    private long id;
    private String stockName;
    private double stockPrice;
}
