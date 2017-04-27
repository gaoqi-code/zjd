package com.bbc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by gonglixun on 2017/2/9.
 */
public class DateUtils {

    public static String getFormatDate(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);;
        return sdf.format(date);
    }

    public static Date getDate(int i){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE,i);
        return c.getTime();
    }


    public static void main(String[] args) {
        System.out.println(getFormatDate(new Date(), "yyMMddHHmmss"));
    }
}
