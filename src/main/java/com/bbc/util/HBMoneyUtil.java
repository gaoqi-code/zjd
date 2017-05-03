package com.bbc.util;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by gonglixun on 2017/2/12.
 */
public class HBMoneyUtil {

    public static BigDecimal getMoney(int montyLevel){
        Random ra =new Random();
        int m1Int = 0;
        if(montyLevel==10){
            m1Int = ra.nextInt(montyLevel-5)+1;
        }else if(montyLevel==20){
            m1Int = ra.nextInt(montyLevel-12)+1;
            if(m1Int<3){
                m1Int = 3;
            }
        }else if(montyLevel==50){
            m1Int = ra.nextInt(montyLevel-30)+1;
            if(m1Int==10||m1Int==12||m1Int==14){
                m1Int=30;
            }else if(m1Int==3){
                m1Int=10;
            }else if(m1Int<3){
                m1Int=10;
            }
        }else if(montyLevel==100){
            m1Int = ra.nextInt(montyLevel-82)+1;
            if (m1Int==10){
                m1Int = 101;
            }else if(m1Int==12){
                m1Int = 50;
            }else if(m1Int<3){
                m1Int = 3;
            }
        }
        if(montyLevel>100){
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
