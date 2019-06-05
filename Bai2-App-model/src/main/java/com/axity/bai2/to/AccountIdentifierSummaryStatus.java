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
 * @param <AccountTrailer>
 */
public class AccountIdentifierSummaryStatus {

    private String recordCode;
    private String customerAccountNumber;
    private String currencyCode;
    private String typeCode;
    private String amount;
    private String itemCount;
    private FundsType fundsType;
    private List<ContinuationRecord> continuationRecords;
    private List<TransactionDetail> transactionDetails;
    private AccountTrailer accountTrailer;
    

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    public void setCustomerAccountNumber(String customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
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

    public String getItemCount() {
        return itemCount;
    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }

    public FundsType getFundsType() {
        return fundsType;
    }

    public void setFundsType(FundsType fundsType) {
        this.fundsType = fundsType;
    }

    public List<ContinuationRecord> getContinuationRecords() {
        return continuationRecords;
    }

    public void setContinuationRecords(List<ContinuationRecord> continuationRecords) {
        this.continuationRecords = continuationRecords;
    }

    public List<TransactionDetail> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public AccountTrailer getAccountTrailer() {
        return accountTrailer;
    }

    public void setAccountTrailer(AccountTrailer accountTrailer) {
        this.accountTrailer = accountTrailer;
    }

    public AccountIdentifierSummaryStatus(String recordCode, String customerAccountNumber, String currencyCode, String typeCode, String amount, String itemCount, FundsType fundsType, List<ContinuationRecord> continuationRecords, List<TransactionDetail> transactionDetails, AccountTrailer accountTrailer) {
        this.recordCode = recordCode;
        this.customerAccountNumber = customerAccountNumber;
        this.currencyCode = currencyCode;
        this.typeCode = typeCode;
        this.amount = amount;
        this.itemCount = itemCount;
        this.fundsType = fundsType;
        this.continuationRecords = continuationRecords;
        this.transactionDetails = transactionDetails;
        this.accountTrailer = accountTrailer;
    }

    public AccountIdentifierSummaryStatus() {
    }

}
