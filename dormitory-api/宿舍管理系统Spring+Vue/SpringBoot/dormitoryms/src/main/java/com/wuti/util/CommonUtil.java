package com.wuti.util;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author wuti
 */
public class CommonUtil {
    public static String createDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
}
