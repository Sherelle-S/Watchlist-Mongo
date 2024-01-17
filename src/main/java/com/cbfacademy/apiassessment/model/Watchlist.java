package com.cbfacademy.apiassessment.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

// model that shows the structure for the watchlist
@Component
@Document(collection = "Watchlist")
public class Watchlist {

    @Id
    private UUID uuid;
    private String stockName;
    private String symbol;
    private String currency;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate datePurchased;
    private Integer wantsVolStock;
    private Integer ownsVolStock;
    private double purchasePrice;
    private double currentPrice;
    private double profit;
    private double pointsChange;
    private double open;
    private double close;
    private double intradayHigh;

    // empty watchlist
    public Watchlist() {
    }

    // generating uuid with this constructor and implementing the logic so that it is generated if uuid is null
    public Watchlist(UUID uuid, String stockName, String symbol, String currency, LocalDate datePurchased, Integer ownsVolStock, Integer wantsVolStock, double purchasePrice, double currentPrice, double profit, double pointsChange, double open, double close, double intradayHigh) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
        this.stockName = stockName;
        this.symbol = symbol;
        this.currency = currency;
        this.datePurchased = datePurchased;
        this.ownsVolStock = ownsVolStock;
        this.wantsVolStock = wantsVolStock;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
        this.profit = profit;
        this.pointsChange = pointsChange;
        this.open = open;
        this.close = close;
        this.intradayHigh = intradayHigh;
    }

        public Watchlist(JSONObject json){
            Object uuidObj = json.get("uuid");
            if (uuidObj instanceof String) {
                this.uuid = UUID.fromString((String) uuidObj);
            } else {
                this.uuid = UUID.randomUUID();
            }
        this.stockName = (String) json.get("stockName");
        this.symbol = (String) json.get("symbol");
        this.currency = (String) json.get("currency");
        String datePurchasedStr = (String) json.get("datePurchased");
        this.datePurchased = LocalDate.parse(datePurchasedStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.ownsVolStock = (Integer) json.get("ownsVolStock");
        this.wantsVolStock = (Integer) json.get("wantsVolStock");
        this.profit = (double) json.get("profit");
        this.pointsChange = (double) json.get("pointsChange");
        this.open = (double) json.get("open");
        this.close = (double) json.get("close");
        this.intradayHigh = (double) json.get("intradayHigh");
    }

    // watchlist constructor for updating watchlist 
        public Watchlist(String currency, LocalDate datePurchased, Integer ownsVolStock, Integer wantsVolStock, double purchasePrice, double currentPrice, double profit, double pointsChange, double open, double close, double intradayHigh) {
        this.currency = currency;
        this.datePurchased = datePurchased;
        this.ownsVolStock = ownsVolStock;
        this.wantsVolStock = wantsVolStock;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
        this.profit = profit;
        this.pointsChange = pointsChange;
        this.open = open;
        this.close = close;
        this.intradayHigh = intradayHigh;
    }

    // getters and setters
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(LocalDate datePurchased) {
        this.datePurchased = datePurchased;
    }

    public Integer getOwnsVolStock() {
        return ownsVolStock;
    }

    public void setOwnsVolStock(Integer has) {
        this.ownsVolStock = has;
        calculateProfit();
    }

    public Integer getWantsVolStock() {
        return wantsVolStock;
    }

    public void setWantsVolStock(Integer wants) {
        this.wantsVolStock = wants;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }
    // sets purchase price and calls calculate profit 
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
        calculateProfit();
    }
    public double getCurrentPrice() {
        return currentPrice;
    }

    // sets current price and calls calculate profit 
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
        calculateProfit();
    }

    public double getProfit() {
        return profit;
    }
    
    public void setProfit(double profit){
        this.profit = (getCurrentPrice() - getPurchasePrice()) * getOwnsVolStock();
    }

    // calculates profit based on user inputs
    private void calculateProfit() {
        this.profit = (this.currentPrice - this.purchasePrice) * this.ownsVolStock;
    }

    public double getPointsChange() {
        return pointsChange;
    }

    // logic for setting points change automatically based on user input
    public void setPointsChange(double pointsChange) {
        this.pointsChange = getClose() - getOpen();
    }

    public double getOpen() {
        return open;
    }

    // sets stockMarket open price and calls calculate points change 
    public void setOpen(double open) {
        this.open = open;
        calculatePointsChange();
    }

    public double getClose() {
        return close;
    }

    // sets stockMarket closing price from user input and calculates points change
    public void setClose(double close) {
        this.close = close;
        calculatePointsChange();
    }

    // calculates points change based on input user values
    private void calculatePointsChange() {
        this.pointsChange = this.close - this.open; 
    }

    public double getIntradayHigh() {
        return intradayHigh;
    }

    public void setIntradayHigh(double intradayHigh) {
        this.intradayHigh = intradayHigh;
    }

    @Override
    public String toString() {
        return "Watchlist [uuid=" + uuid + ", stockName=" + stockName + ", symbol=" + symbol + "currency=" + currency + ", datePurchased=" + datePurchased + ", has=" + ownsVolStock + ", wants=" + wantsVolStock + ", profit=" + profit + ", pointsChange=" + pointsChange + ", open=" + open + ", close=" + close + ", intradayHigh=" + intradayHigh + "]";
    }
}