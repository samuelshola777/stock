package com.example.stock.dto.request;

import lombok.Data;

@Data
public class ChangeStockDetails {
    private long stockId;
    private String stockName;
    private double stockPrice;

}
