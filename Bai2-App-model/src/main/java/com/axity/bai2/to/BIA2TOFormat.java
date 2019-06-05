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
public class BIA2TOFormat {

    private FileHeader header;
    private List<GroupHeader> groupHeader;
    private FileTrailer fileTrailer;

    public FileHeader getHeader() {
        return header;
    }

    public void setHeader(FileHeader header) {
        this.header = header;
    }

    public List<GroupHeader> getGroupHeader() {
        return groupHeader;
    }

    public void setGroupHeader(List<GroupHeader> groupHeader) {
        this.groupHeader = groupHeader;
    }

    public FileTrailer getFileTrailer() {
        return fileTrailer;
    }

    public void setFileTrailer(FileTrailer fileTrailer) {
        this.fileTrailer = fileTrailer;
    }

    public BIA2TOFormat(FileHeader header, List<GroupHeader> groupHeader, FileTrailer fileTrailer) {
        this.header = header;
        this.groupHeader = groupHeader;
        this.fileTrailer = fileTrailer;
    }

    public BIA2TOFormat() {
    }

}
