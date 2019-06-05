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
public class ContinuationRecord {

    private String recordCode;
    private String text;

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ContinuationRecord(String recordCode, String text) {
        this.recordCode = recordCode;
        this.text = text;
    }

    public ContinuationRecord() {
    }

}
