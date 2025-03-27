package com.quantmath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    @Autowired
    private StockRepository stockRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{symbol}")
    public Stock getStockPrediction(@PathVariable String symbol) {
        String aiUrl = "http://ai-service:8000/predict/" + symbol;
        Double prediction = restTemplate.getForObject(aiUrl, Double.class);

        Stock stock = new Stock();
        stock.setSymbol(symbol);
        stock.setPrediction(prediction);
        return stockRepository.save(stock);
    }
}