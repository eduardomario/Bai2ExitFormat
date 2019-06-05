/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axity.bai2.to;

/**
 *
 * @author sfajardo
 */
public class AccountTrailer {
    
    private String recordCode;
    private String accountControlTotal;
    private String numberRecords;

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getAccountControlTotal() {
        return accountControlTotal;
    }

    public void setAccountControlTotal(String accountControlTotal) {
        this.accountControlTotal = accountControlTotal;
    }

    public String getNumberRecords() {
        return numberRecords;
    }

    public void setNumberRecords(String numberRecords) {
        this.numberRecords = numberRecords;
    }

    public AccountTrailer(String recordCode, String accountControlTotal, String numberRecords) {
        this.recordCode = recordCode;
        this.accountControlTotal = accountControlTotal;
        this.numberRecords = numberRecords;
    }

    public AccountTrailer() {
    }
}
