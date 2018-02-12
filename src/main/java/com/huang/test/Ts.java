package com.huang.test;

import com.huang.util.TimeUtil;

public class Ts {
    public static void main(String[] args) {
        String date = "2018-02-11";
        String time = TimeUtil.parseLong2String(TimeUtil.parseString2Long(date), "MM/dd/");
        System.out.println(time);
    }
}
