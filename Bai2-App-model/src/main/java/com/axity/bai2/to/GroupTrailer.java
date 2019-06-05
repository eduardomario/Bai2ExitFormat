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
public class GroupTrailer {

    private String recordCode;
    private String groupControlTotal;
    private String numberAccounts;
    private String numberRecords;

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getGroupControlTotal() {
        return groupControlTotal;
    }

    public void setGroupControlTotal(String groupControlTotal) {
        this.groupControlTotal = groupControlTotal;
    }

    public String getNumberAccounts() {
        return numberAccounts;
    }

    public void setNumberAccounts(String numberAccounts) {
        this.numberAccounts = numberAccounts;
    }

    public String getNumberRecords() {
        return numberRecords;
    }

    public void setNumberRecords(String numberRecords) {
        this.numberRecords = numberRecords;
    }

    public GroupTrailer(String recordCode, String groupControlTotal, String numberAccounts, String numberRecords) {
        this.recordCode = recordCode;
        this.groupControlTotal = groupControlTotal;
        this.numberAccounts = numberAccounts;
        this.numberRecords = numberRecords;
    }

    public GroupTrailer() {
    }

}
