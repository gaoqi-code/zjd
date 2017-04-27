package com.zbjr.ewm;

import java.io.File;
import java.math.BigDecimal;
import java.util.Hashtable;

import com.bbc.util.QRUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType; 
import com.google.zxing.MultiFormatWriter; 
import com.google.zxing.common.BitMatrix; 

public class testQR {
	   
    /**
     * @param args
     * @throws Exception 
     */ 
    public static void main(String[] args) throws Exception { 
//        String text = "http://www.baidu.com";
//        int width = 300;
//        int height = 300;
//        String format = "gif";
//        Hashtable hints = new Hashtable();
//        //������ʹ�ñ���
//        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//        BitMatrix bitMatrix = new MultiFormatWriter().encode(text,BarcodeFormat.QR_CODE, width, height, hints);
//        File outputFile = new File("d:"+File.separator+"new.gif");
//        QRUtil.writeToFile(bitMatrix, format, outputFile);
//        BigDecimal b = new BigDecimal(10.1);
//        int i = b.intValue();
//        System.out.println(i == 10);

        BigDecimal b = new BigDecimal(2);
        BigDecimal bigd = new BigDecimal(3);
        System.out.println(b.add(bigd.divide(new BigDecimal(100))));
    } 
}
