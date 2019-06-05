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
public class GroupHeader {

    private String recordCode;
    private String ultimateReceiverIdentification;
    private String originatorIdentification;
    private String groupStatus;
    private String asOfDate;
    private String asOfTime;
    private String currencyCode;
    private String asOfDateModifier;
    private List<AccountIdentifierSummaryStatus> aiss;
    private GroupTrailer groupTrailer;

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getUltimateReceiverIdentification() {
        return ultimateReceiverIdentification;
    }

    public void setUltimateReceiverIdentification(String ultimateReceiverIdentification) {
        this.ultimateReceiverIdentification = ultimateReceiverIdentification;
    }

    public String getOriginatorIdentification() {
        return originatorIdentification;
    }

    public void setOriginatorIdentification(String originatorIdentification) {
        this.originatorIdentification = originatorIdentification;
    }

    public String getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(String groupStatus) {
        this.groupStatus = groupStatus;
    }

    public String getAsOfDate() {
        return asOfDate;
    }

    public void setAsOfDate(String asOfDate) {
        this.asOfDate = asOfDate;
    }

    public String getAsOfTime() {
        return asOfTime;
    }

    public void setAsOfTime(String asOfTime) {
        this.asOfTime = asOfTime;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getAsOfDateModifier() {
        return asOfDateModifier;
    }

    public void setAsOfDateModifier(String asOfDateModifier) {
        this.asOfDateModifier = asOfDateModifier;
    }

    public List<AccountIdentifierSummaryStatus> getAiss() {
        return aiss;
    }

    public void setAiss(List<AccountIdentifierSummaryStatus> aiss) {
        this.aiss = aiss;
    }

    public GroupTrailer getGroupTrailer() {
        return groupTrailer;
    }

    public void setGroupTrailer(GroupTrailer groupTrailer) {
        this.groupTrailer = groupTrailer;
    }

    public GroupHeader(String recordCode, String ultimateReceiverIdentification, String originatorIdentification, String groupStatus, String asOfDate, String asOfTime, String currencyCode, String asOfDateModifier, List<AccountIdentifierSummaryStatus> aiss, GroupTrailer groupTrailer) {
        this.recordCode = recordCode;
        this.ultimateReceiverIdentification = ultimateReceiverIdentification;
        this.originatorIdentification = originatorIdentification;
        this.groupStatus = groupStatus;
        this.asOfDate = asOfDate;
        this.asOfTime = asOfTime;
        this.currencyCode = currencyCode;
        this.asOfDateModifier = asOfDateModifier;
        this.aiss = aiss;
        this.groupTrailer = groupTrailer;
    }

    public GroupHeader() {
    }

}
