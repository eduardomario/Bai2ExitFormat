package com.axity.bai2.impl;

import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.axity.bai2.to.AccountIdentifierSummaryStatus;
import com.axity.bai2.to.AccountTrailer;
import com.axity.bai2.to.BIA2TOFormat;
import com.axity.bai2.to.ContinuationRecord;
import com.axity.bai2.to.FileHeader;
import com.axity.bai2.to.FileTrailer;
import com.axity.bai2.to.FundsType;
import com.axity.bai2.to.GroupHeader;
import com.axity.bai2.to.GroupTrailer;
import com.axity.bai2.to.TransactionDetail;
import com.axity.bai2.IBai2Format;

public class Bai2FormatImpl implements IBai2Format {

    @Override
    public StringBuilder createBai2Format(BIA2TOFormat data) {
        if (validateBAI2(data)) {
            System.out.println("INFORMACION INCOMPLETA");
            return null;
        } else {
        
            StringBuilder bai2 = new StringBuilder();
            
            createFileHeader(bai2, data.getHeader());
            
            for (int i = 0; i < data.getGroupHeader().size(); i++) {
            
                createGroupHeader(bai2, data.getGroupHeader().get(i));
                
                for (int j = 0; j < data.getGroupHeader().get(i).getAiss().size(); j++) {
                    createAccountSummary(bai2, data.getGroupHeader().get(i).getAiss().get(j), data.getGroupHeader().get(i));
                    
                    for (int l = 0; l < data.getGroupHeader().get(i).getAiss().get(j).getTransactionDetails().size(); l++) {
                        if (data.getGroupHeader().get(i).getAiss().get(j).getTransactionDetails().get(l).getRecordCode() == null
                        || data.getGroupHeader().get(i).getAiss().get(j).getTransactionDetails().get(l).getRecordCode().equalsIgnoreCase("")) {
                        } else {
                            createTransactionDetail(bai2, data.getGroupHeader().get(i).getAiss().get(j).getTransactionDetails().get(l));
                        }
                    }
                    
                    createAccountTrailer(bai2, data.getGroupHeader().get(i).getAiss().get(j).getAccountTrailer());
                
                }
                createGroupTrailer(bai2, data.getGroupHeader().get(i).getGroupTrailer());
            }

            createFileTrailer(bai2, data.getFileTrailer());
            
            System.out.println("BAI2 CREADO");
            return bai2;
        }
    }

    @Override
    public void createFileHeader(StringBuilder bai2, FileHeader fileHeader) {
        bai2.append(fileHeader.getRecordCode());
        bai2.append(",");
        bai2.append(fileHeader.getSenderIdentification());
        bai2.append(",");
        bai2.append(fileHeader.getReceiverIdentification());
        bai2.append(",");
        bai2.append(fileHeader.getFileCreationDate());
        bai2.append(",");
        bai2.append(fileHeader.getFileCreationTime());
        bai2.append(",");
        bai2.append(fileHeader.getFileIdentificationNumber());
        bai2.append(",");
        bai2.append(fileHeader.getPhysicalRecordLength());
        bai2.append(",");
        bai2.append(fileHeader.getBlockSize());
        bai2.append(",");
        bai2.append(fileHeader.getVersionNumber());
        bai2.append("/" + "\n");
    }

    @Override
    public void createGroupHeader(StringBuilder bai2, GroupHeader groupHeader) {
        bai2.append(groupHeader.getRecordCode());
        bai2.append(",");
        bai2.append(groupHeader.getUltimateReceiverIdentification());
        bai2.append(",");
        bai2.append(groupHeader.getOriginatorIdentification());
        bai2.append(",");
        bai2.append(groupHeader.getGroupStatus());
        bai2.append(",");
        bai2.append(groupHeader.getAsOfDate());
        bai2.append(",");
        bai2.append(groupHeader.getAsOfTime());
        bai2.append(",");
        if (groupHeader.getCurrencyCode().equalsIgnoreCase("")) {
            groupHeader.setCurrencyCode("USD");
        }
        bai2.append(groupHeader.getCurrencyCode());
        bai2.append(",");
        bai2.append(groupHeader.getAsOfDateModifier());
        bai2.append("/" + "\n");
    }

    @Override
    public void createAccountSummary(StringBuilder bai2, AccountIdentifierSummaryStatus accountSummaryList, GroupHeader groupHeader) {
        bai2.append(accountSummaryList.getRecordCode());
        bai2.append(",");
        bai2.append(accountSummaryList.getCustomerAccountNumber());
        bai2.append(",");
        if (accountSummaryList.getCurrencyCode().equalsIgnoreCase("")) {
            accountSummaryList.setCurrencyCode(groupHeader.getCurrencyCode());
        }
        bai2.append(accountSummaryList.getCurrencyCode());
        bai2.append(",");
        bai2.append(accountSummaryList.getTypeCode());
        bai2.append(",");
        bai2.append(accountSummaryList.getAmount());
        bai2.append(",");
        bai2.append(accountSummaryList.getItemCount());
        bai2.append(",");
        if (accountSummaryList.getFundsType().getFundType() == null || accountSummaryList.getFundsType().getFundType().equalsIgnoreCase("")){
            accountSummaryList.getFundsType().setFundType("Z");
            bai2.append(accountSummaryList.getFundsType().getFundType());
        } else if (accountSummaryList.getFundsType().getFundType().equalsIgnoreCase("S")) {
            bai2.append(accountSummaryList.getFundsType().getFundType());
            bai2.append(",");
            bai2.append("0");
            bai2.append(",");
            bai2.append("1");
            bai2.append(",");
            bai2.append("2");
        } else if (accountSummaryList.getFundsType().getFundType().equalsIgnoreCase("V")) {
            bai2.append(accountSummaryList.getFundsType().getFundType());
            bai2.append(",");
            bai2.append(accountSummaryList.getFundsType().getFundDate());
            bai2.append(",");
            bai2.append(accountSummaryList.getFundsType().getFundTime());
        } else if (accountSummaryList.getFundsType().getFundType().equalsIgnoreCase("D")) {
            bai2.append(accountSummaryList.getFundsType().getFundType());
            bai2.append(",");
            bai2.append(accountSummaryList.getFundsType().getNumberDistributions());
            for (int q = 0; q < Integer.parseInt(accountSummaryList.getFundsType().getNumberDistributions()); q++) {
                bai2.append(",");
                bai2.append(accountSummaryList.getFundsType().getAvailableDays().get(q));
                bai2.append(",");
                bai2.append(accountSummaryList.getFundsType().getAvailableAmount().get(q));
            }
        } else {
            bai2.append(accountSummaryList.getFundsType());
        }
        if (accountSummaryList.getContinuationRecords() != null) {
            for (int i = 0; i < accountSummaryList.getContinuationRecords().size(); i++) {
                if (!(accountSummaryList.getContinuationRecords().get(i).getText() == null && accountSummaryList.getContinuationRecords().get(i).getText() == "")) {
                    bai2.append("/" + "\n");
                    createContinuationRecord(bai2, accountSummaryList.getContinuationRecords().get(i));
                }

            }
        }
        bai2.append("/" + "\n");
    }

    @Override
    public void createTransactionDetail(StringBuilder bai2, TransactionDetail transDetailList) {
        bai2.append(transDetailList.getRecordCode());
        bai2.append(",");
        bai2.append(transDetailList.getTypeCode());
        bai2.append(",");
        bai2.append(transDetailList.getAmount());
        bai2.append(",");
        if (transDetailList.getFundsType().getFundType() == null || transDetailList.getFundsType().getFundType().equalsIgnoreCase("")) {
            transDetailList.getFundsType().setFundType("Z");
            bai2.append(transDetailList.getFundsType());
        } else if (transDetailList.getFundsType().getFundType().equalsIgnoreCase("S")) {
            bai2.append(transDetailList.getFundsType().getFundType());
            bai2.append(",");
            bai2.append("0");
            bai2.append(",");
            bai2.append("1");
            bai2.append(",");
            bai2.append("2");
        } else if (transDetailList.getFundsType().getFundType().equalsIgnoreCase("V")) {
            bai2.append(transDetailList.getFundsType().getFundType());
            bai2.append(",");
            bai2.append(transDetailList.getFundsType().getFundDate());
            bai2.append(",");
            bai2.append(transDetailList.getFundsType().getFundTime());
        } else if (transDetailList.getFundsType().getFundType().equalsIgnoreCase("D")) {
            bai2.append(transDetailList.getFundsType().getFundType());
            bai2.append(",");
            bai2.append(transDetailList.getFundsType().getNumberDistributions());
            for (int q = 0; q < Integer.parseInt(transDetailList.getFundsType().getNumberDistributions()); q++) {
                bai2.append(",");
                bai2.append(transDetailList.getFundsType().getAvailableDays().get(q));
                bai2.append(",");
                bai2.append(transDetailList.getFundsType().getAvailableDays().get(q));
            }
        } else {
            bai2.append(transDetailList.getFundsType());
        }
        bai2.append(",");
        if (transDetailList.getBankReferenceNumber() == null) {
            transDetailList.setBankReferenceNumber("");
        }
        bai2.append(transDetailList.getBankReferenceNumber());
        bai2.append(",");
        if (transDetailList.getCustomerReferenceNumber() == null) {
            transDetailList.setCustomerReferenceNumber("");
        }
        bai2.append(transDetailList.getCustomerReferenceNumber());
        bai2.append(",");
        if (transDetailList.getText() == null) {
            transDetailList.setText("");
        }
        bai2.append(transDetailList.getText());

        if (transDetailList.getContinuationRecords() != null) {
            for (int i = 0; i < transDetailList.getContinuationRecords().size(); i++) {
                if (!(transDetailList.getContinuationRecords().get(i).getText() == null && transDetailList.getContinuationRecords().get(i).getText() == "")) {
                    bai2.append("/" + "\n");
                    createContinuationRecord(bai2, transDetailList.getContinuationRecords().get(i));
                }
            }
        }
        bai2.append("/" + "\n");
    }

    @Override
    public void createAccountTrailer(StringBuilder bai2, AccountTrailer accountTrailer) {
        bai2.append(accountTrailer.getRecordCode());
        bai2.append(",");
        bai2.append(accountTrailer.getAccountControlTotal());
        bai2.append(",");
        bai2.append(accountTrailer.getNumberRecords());
        bai2.append("/" + "\n");
    }

    @Override
    public void createGroupTrailer(StringBuilder bai2, GroupTrailer groupTrailer) {
        bai2.append(groupTrailer.getRecordCode());
        bai2.append(",");
        bai2.append(groupTrailer.getGroupControlTotal());
        bai2.append(",");
        bai2.append(groupTrailer.getNumberAccounts());
        bai2.append(",");
        bai2.append(groupTrailer.getNumberRecords());
        bai2.append("/" + "\n");
    }

    @Override
    public void createFileTrailer(StringBuilder bai2, FileTrailer fileTrailer) {
        bai2.append(fileTrailer.getRecordCode());
        bai2.append(",");
        bai2.append(fileTrailer.getFileControlTotal());
        bai2.append(",");
        bai2.append(fileTrailer.getNumberGroups());
        bai2.append(",");
        bai2.append(fileTrailer.getNumberRecords());
        bai2.append("/");
    }

    @Override
    public void createContinuationRecord(StringBuilder bai2, ContinuationRecord continuationRecord) {
        bai2.append(continuationRecord.getRecordCode());
        bai2.append(",");
        bai2.append(continuationRecord.getText());
    }

    @Override
    public BIA2TOFormat createTestData() {
        BIA2TOFormat data = new BIA2TOFormat();
        DateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        Date date = new Date();
        DateFormat timeFormat = new SimpleDateFormat("HHmm");
        Date time = new Date();
        int groupHeaderRecord = 0;
        int groupTrailerRecord = 0;
        int accountSummaryRecord = 0;
        int transDetailRecord = 0;
        int accountAmountRecord = 0;
        int accountAmountTotal = 0;
        int transAmountRecord = 0;
        int groupAmountTotal = 0;
        int accountTrailerRecord = 0;
        List<AccountIdentifierSummaryStatus> accountSummaryList = new ArrayList<AccountIdentifierSummaryStatus>();
        List<GroupHeader> groupHeaderList = new ArrayList<GroupHeader>();
        List<GroupTrailer> groupTrailerList = new ArrayList<GroupTrailer>();

        FileHeader fileHeader = new FileHeader("01", "BNY123", "XYZ123", dateFormat.format(date),
                timeFormat.format(time), "5", "", "", "2");

        data.setHeader(fileHeader);        

        for (int j = 0; j < 5; j++) {
            //Se declara y se crea el AccountSumary
            List<TransactionDetail> transDetailList = new ArrayList<TransactionDetail>();
            accountTrailerRecord = 0;
            for (int l = 0; l < 5; l++) {
                //Se declara y se crea el TransactionDetail                    
                List<ContinuationRecord> continuationList = new ArrayList<ContinuationRecord>();
                transAmountRecord = 0;
                if (l < 2) {
                    ContinuationRecord continuationRecord = new ContinuationRecord();
                    continuationList.add(continuationRecord);
                    continuationList.add(continuationRecord);
                    TransactionDetail transDetail = new TransactionDetail();
                    transDetailList.add(transDetail);
                } else {
                    ContinuationRecord continuationRecord = new ContinuationRecord("88", "WELCOME");
                    continuationList.add(continuationRecord);
                    continuationList.add(continuationRecord);
                    FundsType transFundsType = new FundsType("S","020315","2130","",null,null);
                    TransactionDetail transDetail = new TransactionDetail("16", "016", "21000", transFundsType, "ZYX123", "XYZ321", "", continuationList);                    
                    transDetailList.add(transDetail);
                    transDetailRecord++;
                    transDetailRecord++;
                    transDetailRecord++;
                }
            }

            //Se declara y se crea el AccountTrairler
            accountAmountRecord = accountAmountRecord + Integer.parseInt(String.valueOf(500 * (j + 1)));
            FundsType fundsType = new FundsType();
            AccountTrailer accountTrailer = new AccountTrailer("49", String.valueOf(accountAmountRecord + transAmountRecord), String.valueOf(transDetailRecord + 2));

            accountAmountTotal = accountAmountTotal + accountAmountRecord;
            accountTrailerRecord=accountTrailerRecord+(transDetailRecord+2);

            AccountIdentifierSummaryStatus accountSummary = new AccountIdentifierSummaryStatus(
                    "03", String.valueOf(30 * (j + 1)), "", "010", String.valueOf(500 * (j + 1)), "", fundsType, transDetailList.get(j).getContinuationRecords(), transDetailList, accountTrailer
            );
            accountSummaryList.add(accountSummary);
            accountSummaryRecord++;

        }

        //Se declara y se crea el GroupTrailer
        GroupTrailer groupTrailer = new GroupTrailer("98", String.valueOf(accountAmountTotal), String.valueOf(accountSummaryRecord), String.valueOf(accountTrailerRecord + 2));

        GroupHeader groupHeader = new GroupHeader("02", "", "ABC123", "1", dateFormat.format(date), timeFormat.format(time), "", "1",accountSummaryList,groupTrailer);
        groupHeaderRecord++;

        groupHeaderList.add(groupHeader);
        data.setGroupHeader(groupHeaderList);
        
        groupAmountTotal = groupAmountTotal + accountAmountTotal;
        groupTrailerRecord++;

        groupTrailerList.add(groupTrailer);
        //data.setGroupTrailer(groupTrailerList);

        //Se declara y se crea el FileTrailer
        FileTrailer fileTrailer = new FileTrailer("99", String.valueOf(groupAmountTotal), String.valueOf(groupHeaderRecord),
                String.valueOf(groupTrailerRecord + 2));

        data.setFileTrailer(fileTrailer);
        System.out.println("BAI2FORMAT CREADO");
        return data;
    }

    @Override
    public void writeBAI2FormatToFile(StringBuilder bai2) {

        try {

            FileWriter writer = new FileWriter("output");
            writer.write(bai2.toString());
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Boolean validateBAI2(BIA2TOFormat data){
        Boolean validate = false;
        //Valida si los objetos en general son Nulos
        if(data.getHeader()==null||
        data.getGroupHeader()==null||
        data.getFileTrailer()==null){
            validate = true;
        }//Valida si los datos dentro del FileHeader y del FileTrailer son Nulos o Vacios
        else if(data.getHeader().getSenderIdentification()==null||
                data.getHeader().getSenderIdentification().equalsIgnoreCase("")||
                data.getHeader().getReceiverIdentification()==null||
                data.getHeader().getReceiverIdentification().equalsIgnoreCase("")||
                data.getHeader().getFileCreationDate()==null||
                data.getHeader().getFileCreationDate().equalsIgnoreCase("")||
                data.getHeader().getFileCreationTime()==null||
                data.getHeader().getFileCreationTime().equalsIgnoreCase("")||
                data.getHeader().getFileIdentificationNumber()==null||
                data.getHeader().getFileIdentificationNumber().equalsIgnoreCase("")||
                data.getHeader().getVersionNumber()==null||
                data.getHeader().getVersionNumber().equalsIgnoreCase("")||
                data.getFileTrailer().getFileControlTotal()==null||
                data.getFileTrailer().getFileControlTotal().equalsIgnoreCase("")||
                data.getFileTrailer().getNumberGroups()==null||
                data.getFileTrailer().getNumberGroups().equalsIgnoreCase("")||
                data.getFileTrailer().getNumberRecords()==null||
                data.getFileTrailer().getNumberRecords().equalsIgnoreCase("")){
                    validate = true;
        }
        //Valida si los datos dentro del GroupHeader y del GroupTrailer son Nulos o Vacios
        for(int i=0;i<data.getGroupHeader().size();i++){
            if(data.getGroupHeader().get(i).getOriginatorIdentification()==null||
                data.getGroupHeader().get(i).getOriginatorIdentification().equalsIgnoreCase("")||
                data.getGroupHeader().get(i).getGroupStatus()==null||
                data.getGroupHeader().get(i).getGroupStatus().equalsIgnoreCase("")||
                data.getGroupHeader().get(i).getAsOfDate()==null||
                data.getGroupHeader().get(i).getAsOfDate().equalsIgnoreCase("")||
                data.getGroupHeader().get(i).getGroupTrailer().getGroupControlTotal()==null||
                data.getGroupHeader().get(i).getGroupTrailer().getGroupControlTotal().equalsIgnoreCase("")||
                data.getGroupHeader().get(i).getGroupTrailer().getNumberAccounts()==null||
                data.getGroupHeader().get(i).getGroupTrailer().getNumberAccounts().equalsIgnoreCase("")||
                data.getGroupHeader().get(i).getGroupTrailer().getNumberRecords()==null||
                data.getGroupHeader().get(i).getGroupTrailer().getNumberRecords().equalsIgnoreCase("")){
                    validate = true;
            }
            //Valida si los datos dentro del AccountIdentifier y del AccountTrailer son Nulos o Vacios
            for(int q=0;q<data.getGroupHeader().get(i).getAiss().size();q++){
                if(data.getGroupHeader().get(i).getAiss().get(q).getCustomerAccountNumber()==null||
                    data.getGroupHeader().get(i).getAiss().get(q).getCustomerAccountNumber().equalsIgnoreCase("")||
                    data.getGroupHeader().get(i).getAiss().get(q).getAccountTrailer().getAccountControlTotal()==null||
                    data.getGroupHeader().get(i).getAiss().get(q).getAccountTrailer().getAccountControlTotal().equalsIgnoreCase("")||
                    data.getGroupHeader().get(i).getAiss().get(q).getAccountTrailer().getNumberRecords()==null||
                    data.getGroupHeader().get(i).getAiss().get(q).getAccountTrailer().getNumberRecords().equalsIgnoreCase("")){
                        validate = true;
                }
                //Valida si exicten Transacciones dentro del AccountIdentifier
                if(data.getGroupHeader().get(i).getAiss().get(q).getTransactionDetails()!=null){    
                    //Si exicten Transacciones, valida si son Nulos o Vacios
                    for(int j=0;j<data.getGroupHeader().get(i).getAiss().get(q).getTransactionDetails().size();j++){
                        if(data.getGroupHeader().get(i).getAiss().get(q).getTransactionDetails().get(j).getRecordCode()!=null){
                            if(data.getGroupHeader().get(i).getAiss().get(q).getTransactionDetails().get(j).getTypeCode()==null||
                            data.getGroupHeader().get(i).getAiss().get(q).getTransactionDetails().get(j).getTypeCode().equalsIgnoreCase("")){
                                validate = true;
                            }
                        }
            
                    }
                }
            }
        }        
        //Si los datos no estan completos, "validate" sera 'true', en caso contrario, sera 'false'
        return validate;
    }
}
