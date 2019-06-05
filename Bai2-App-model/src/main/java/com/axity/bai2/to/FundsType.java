package com.axity.bai2.to;

import java.util.List;

public class FundsType {

    private String fundType;
    private String fundDate;
    private String fundTime;
    private String numberDistributions;
    private List<String> availableDays;
    private List<String> availableAmount;

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getFundDate() {
        return fundDate;
    }

    public void setFundDate(String fundDate) {
        this.fundDate = fundDate;
    }

    public String getFundTime() {
        return fundTime;
    }

    public void setFundTime(String fundTime) {
        this.fundTime = fundTime;
    }

    public String getNumberDistributions() {
        return numberDistributions;
    }

    public void setNumberDistributions(String numberDistributions) {
        this.numberDistributions = numberDistributions;
    }

    public List<String> getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(List<String> availableDays) {
        this.availableDays = availableDays;
    }

    public List<String> getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(List<String> availableAmount) {
        this.availableAmount = availableAmount;
    }

    public FundsType(String fundType, String fundDate, String fundTime, String numberDistributions, List<String> availableDays, List<String> availableAmount) {
        this.fundType = fundType;
        this.fundDate = fundDate;
        this.fundTime = fundTime;
        this.numberDistributions = numberDistributions;
        this.availableDays = availableDays;
        this.availableAmount = availableAmount;
    }

    public FundsType() {
    }

}