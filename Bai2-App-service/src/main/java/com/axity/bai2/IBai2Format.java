package com.axity.bai2;

import com.axity.bai2.to.AccountIdentifierSummaryStatus;
import com.axity.bai2.to.AccountTrailer;
import com.axity.bai2.to.BIA2TOFormat;
import com.axity.bai2.to.ContinuationRecord;
import com.axity.bai2.to.FileHeader;
import com.axity.bai2.to.FileTrailer;
import com.axity.bai2.to.GroupHeader;
import com.axity.bai2.to.GroupTrailer;
import com.axity.bai2.to.TransactionDetail;

public interface IBai2Format {
        
    public StringBuilder createBai2Format(BIA2TOFormat data);
    public void createFileHeader(StringBuilder bai2,FileHeader fileHeader);
    public void createGroupHeader(StringBuilder bai2,GroupHeader groupHeader);
    public void createAccountSummary(StringBuilder bai2,AccountIdentifierSummaryStatus accountSummary,GroupHeader groupHeader);    
    public void createTransactionDetail(StringBuilder bai2,TransactionDetail transDetailList);    
    public void createAccountTrailer(StringBuilder bai2,AccountTrailer accountTrailer);
    public void createGroupTrailer(StringBuilder bai2,GroupTrailer groupTrailer);
    public void createFileTrailer(StringBuilder bai2,FileTrailer fileTrailer);
    public void createContinuationRecord(StringBuilder bai2,ContinuationRecord continuationRecord);
    public BIA2TOFormat createTestData();
    public void writeBAI2FormatToFile(StringBuilder bai2);
}