package com.laoma.mystudy.lambda;


import org.junit.Test;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author xgh
 * @date ：Created on 2020/4/6
 */
public class LambdaFour {

    @Test
    public void Test(){
        //类：静态方法名
        Comparator<Integer> comparator1 =(x,y)->Integer.compare(x,y);
        Comparator<Integer> comparator =Integer::compareTo;
    }

    @Test
    public void Test2(){
        BiPredicate<String,String> b = (a,c)->a.equals(c);
        //类实例方法
        BiPredicate<String,String> b1 = String::equals;
    }

    @Test
    public void Test3(){
        Supplier<Student> supplier = ()->new Student();
        //构造器引入
        Supplier<Student> supplier1 =Student::new;
        Student student = supplier1.get();
        System.out.println(student);

        Function<String,Student> function = Student::new;
        Student apply = function.apply("111");
        System.out.println(apply);
    }

    @Test
    public void Test4(){
        //数组引用
        Function<Integer,String[]> function = (x)->new String[x];
        String[] apply = function.apply(10);
        System.out.println(apply.length);

        Function<Integer,String[]> function1 = String[]::new;
        String[] apply1 = function1.apply(20);
        System.out.println(apply1.length);
    }
}
