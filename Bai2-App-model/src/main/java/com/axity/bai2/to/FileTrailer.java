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
public class FileTrailer {

    private String recordCode;
    private String fileControlTotal;
    private String numberGroups;
    private String numberRecords;

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getFileControlTotal() {
        return fileControlTotal;
    }

    public void setFileControlTotal(String fileControlTotal) {
        this.fileControlTotal = fileControlTotal;
    }

    public String getNumberGroups() {
        return numberGroups;
    }

    public void setNumberGroups(String numberGroups) {
        this.numberGroups = numberGroups;
    }

    public String getNumberRecords() {
        return numberRecords;
    }

    public void setNumberRecords(String numberRecords) {
        this.numberRecords = numberRecords;
    }

    public FileTrailer(String recordCode, String fileControlTotal, String numberGroups, String numberRecords) {
        this.recordCode = recordCode;
        this.fileControlTotal = fileControlTotal;
        this.numberGroups = numberGroups;
        this.numberRecords = numberRecords;
    }

    public FileTrailer() {
    }

}
