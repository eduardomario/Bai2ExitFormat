/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axity.bai2.to;

import java.util.List;

/**
 *
 * @author sfajardo
 */
public class TransactionDetail {

    private String recordCode;
    private String typeCode;
    private String amount;
    private FundsType fundsType;
    private String bankReferenceNumber;
    private String customerReferenceNumber;
    private String text;
    private List<ContinuationRecord> continuationRecords;

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public FundsType getFundsType() {
        return fundsType;
    }

    public void setFundsType(FundsType fundsType) {
        this.fundsType = fundsType;
    }

    public String getBankReferenceNumber() {
        return bankReferenceNumber;
    }

    public void setBankReferenceNumber(String bankReferenceNumber) {
        this.bankReferenceNumber = bankReferenceNumber;
    }

    public String getCustomerReferenceNumber() {
        return customerReferenceNumber;
    }

    public void setCustomerReferenceNumber(String customerReferenceNumber) {
        this.customerReferenceNumber = customerReferenceNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ContinuationRecord> getContinuationRecords() {
        return continuationRecords;
    }

    public void setContinuationRecords(List<ContinuationRecord> continuationRecords) {
        this.continuationRecords = continuationRecords;
    }

    public TransactionDetail(String recordCode, String typeCode, String amount, FundsType fundsType, String bankReferenceNumber, String customerReferenceNumber, String text, List<ContinuationRecord> continuationRecords) {
        this.recordCode = recordCode;
        this.typeCode = typeCode;
        this.amount = amount;
        this.fundsType = fundsType;
        this.bankReferenceNumber = bankReferenceNumber;
        this.customerReferenceNumber = customerReferenceNumber;
        this.text = text;
        this.continuationRecords = continuationRecords;
    }

    public TransactionDetail() {
    }

}
