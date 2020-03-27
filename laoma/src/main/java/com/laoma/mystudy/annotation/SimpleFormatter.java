package com.laoma.mystudy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SimpleFormatter {

    public static String format(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            StringBuilder sb = new StringBuilder();
            for (Field f : cls.getDeclaredFields()) {
                if (!f.isAccessible()) {
                    f.setAccessible(true);
                }
                Label label = f.getAnnotation(Label.class);
                String name = label != null ? label.value() : f.getName();
                Object value = f.get(obj);
                if (value != null && f.getType() == Date.class) {
                    value = fomatDate(f, value);
                }
                sb.append(name+": "+value +"\n" );

            }
            return sb.toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static Object fomatDate(Field f, Object value) {
        Format format = f.getAnnotation(Format.class);
        if (format != null) {
            SimpleDateFormat simpleFormatter = new SimpleDateFormat(format.pattern());
            simpleFormatter.setTimeZone(TimeZone.getTimeZone(format.timezone()));
            return simpleFormatter.format(value);
        }
        return value;
    }

    public static void main(String[] args) {
        Student student = new Student("张三",new Date(),87d);
        System.out.println(format(student));
    }
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Label {
    String value() default "";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Format {
    String pattern() default "yyyy-MM-dd HH:mm:ss";

    String timezone() default "GMT+8";
}

class Student {
    @Label("姓名")
    String name;
    @Label("出生日期")
    @Format(pattern = "yyyy/MM/dd")
    Date porn;
    @Label("分数")
    double score;

    public Student(String name, Date porn, double score) {
        this.name = name;
        this.porn = porn;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPorn() {
        return porn;
    }

    public void setPorn(Date porn) {
        this.porn = porn;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}