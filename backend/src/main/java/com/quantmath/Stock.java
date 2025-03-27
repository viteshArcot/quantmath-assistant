package com.quantmath;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stock {
    @Id
    private String symbol;
    private Double prediction;

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public Double getPrediction() { return prediction; }
    public void setPrediction(Double prediction) { this.prediction = prediction; }
}