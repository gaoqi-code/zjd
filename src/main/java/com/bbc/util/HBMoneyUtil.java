package com.bbc.util;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by gonglixun on 2017/2/12.
 */
public class HBMoneyUtil {

    public static BigDecimal getMoney(int montyLevel){
        Random ra =new Random();
        int m1Int = ra.nextInt(montyLevel)+1;
        if(m1Int==9){
            m1Int = 5;
        }
        if(m1Int==8){
            m1Int = 5;
        }
        if(m1Int==7){
            m1Int = 6;
        }
        if(m1Int==6){
            m1Int = 4;
        }
        if(m1Int==16){
            m1Int = 5;
        }
        if(m1Int==18){
            m1Int = 4;
        }
        if(m1Int==19){
            m1Int = 8;
        }

        if(montyLevel>20){
            m1Int = 2;
        }
        BigDecimal m1 = new BigDecimal(m1Int);
        BigDecimal m2 = new BigDecimal(ra.nextInt(99)).divide(new BigDecimal(100));
        return m1.add(m2);
    }

    public static BigDecimal getMoneyBig(int montyLevel){
        Random k =new Random();
        int tempI = k.nextInt(2);
        Random ra =new Random();
        if(tempI==1){
            int m1Int = ra.nextInt(montyLevel*20)+1;
            BigDecimal m1 = new BigDecimal(m1Int);
            BigDecimal m2 = new BigDecimal(ra.nextInt(99)).divide(new BigDecimal(100));
            return m1.add(m2);
        }else{
            int m1Int = ra.nextInt(montyLevel)+1;
            BigDecimal m1 = new BigDecimal(m1Int);
            BigDecimal m2 = new BigDecimal(ra.nextInt(99)).divide(new BigDecimal(100));
            return m1.add(m2);
        }

    }

//    public static void main(String[] args) {
//        BigDecimal m1 = new BigDecimal(0);
//        for (int i = 0;i<15;i++){
//            BigDecimal m2 = getMoneyBig(20);
//            System.out.println(m2);
//            m1 = m1.add(m2);
//        }
//        System.out.println("总金额 = "+m1);
//        for(int i =0 ;i<10;i++){
//            System.out.println("总金额 = "+getMoney(10));
//        }

//    }

    public static String getRamd(){
        Random ra =new Random();
        return ra.nextInt(100)+"HB";
    }

}
