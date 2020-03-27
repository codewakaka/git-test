package com.laoma.mystudy.localThread;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalDateformat {
    static ThreadLocal<DateFormat> dft  =  new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        }
    };
    public static String date2String(Date date){
        return dft.get().format(date);
    }

    public static Date String2Date(String s) throws ParseException {
        return dft.get().parse(s);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(date2String(new Date()));
        System.out.println(String2Date("2019年11月10日 14:23:43").toString());
    }
}
