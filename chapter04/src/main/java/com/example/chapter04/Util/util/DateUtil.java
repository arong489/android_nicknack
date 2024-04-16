package com.example.chapter04.Util.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    public static String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }
}
