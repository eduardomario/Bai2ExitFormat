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
public class FileHeader {

    private String recordCode;
    private String senderIdentification;
    private String receiverIdentification;
    private String fileCreationDate;
    private String fileCreationTime;
    private String fileIdentificationNumber;
    private String physicalRecordLength;
    private String blockSize;
    private String versionNumber;

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getSenderIdentification() {
        return senderIdentification;
    }

    public void setSenderIdentification(String senderIdentification) {
        this.senderIdentification = senderIdentification;
    }

    public String getReceiverIdentification() {
        return receiverIdentification;
    }

    public void setReceiverIdentification(String receiverIdentification) {
        this.receiverIdentification = receiverIdentification;
    }

    public String getFileCreationDate() {
        return fileCreationDate;
    }

    public void setFileCreationDate(String fileCreationDate) {
        this.fileCreationDate = fileCreationDate;
    }

    public String getFileCreationTime() {
        return fileCreationTime;
    }

    public void setFileCreationTime(String fileCreationTime) {
        this.fileCreationTime = fileCreationTime;
    }

    public String getFileIdentificationNumber() {
        return fileIdentificationNumber;
    }

    public void setFileIdentificationNumber(String fileIdentificationNumber) {
        this.fileIdentificationNumber = fileIdentificationNumber;
    }

    public String getPhysicalRecordLength() {
        return physicalRecordLength;
    }

    public void setPhysicalRecordLength(String physicalRecordLength) {
        this.physicalRecordLength = physicalRecordLength;
    }

    public String getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(String blockSize) {
        this.blockSize = blockSize;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public FileHeader(String recordCode, String senderIdentification, String receiverIdentification, String fileCreationDate, String fileCreationTime, String fileIdentificationNumber, String physicalRecordLength, String blockSize, String versionNumber) {
        this.recordCode = recordCode;
        this.senderIdentification = senderIdentification;
        this.receiverIdentification = receiverIdentification;
        this.fileCreationDate = fileCreationDate;
        this.fileCreationTime = fileCreationTime;
        this.fileIdentificationNumber = fileIdentificationNumber;
        this.physicalRecordLength = physicalRecordLength;
        this.blockSize = blockSize;
        this.versionNumber = versionNumber;
    }

    public FileHeader() {
    }

}
