package com.axity.bai2;

import org.junit.Test;

import com.axity.bai2.to.BIA2TOFormat;
import com.axity.bai2.IBai2Format;
import com.axity.bai2.impl.Bai2FormatImpl;

public class Bia2FormatTest {
    
    IBai2Format iBai2Format = new Bai2FormatImpl();
    
    @Test
    public void createBai2Test(){
    
        StringBuilder bai2 = new StringBuilder();
        BIA2TOFormat data = new BIA2TOFormat();
        data = iBai2Format.createTestData();
        bai2 = iBai2Format.createBai2Format(data);
        
        System.out.println(bai2);
    }
}