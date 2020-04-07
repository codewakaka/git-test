package com.laoma.mystudy.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author xgh
 * @date ：Created on 2020/4/6
 */
public class LambdaThree {

    @Test
    public  void  test1(){
        //消费新接口
        consume("123131",x-> System.out.println(x+"========"));
        //方法引用 实例：：方法（接口的方法值与参数要与实例方法一致）
        consume("123131",System.out::println);

    }

    public void consume(String str, Consumer<String> consumer){
        consumer.accept(str);
    }

    @Test
    public void test4(){
        //断言式函数
        List<String> list = Arrays.asList("2131","asd","sadada","hhhhhhh","1");
        List<String> list1 =new ArrayList<>();
        for (String s:list) {
            if(predicate(s,x->x.length()>3)){
                list1.add(s);
            }
        }
        list1.forEach(System.out::println);
    }

    public boolean predicate(String str, Predicate<String> predicate){
        return predicate.test(str);

    }

    @Test
    public void Test3(){
        //函数型接口
        String function = function(30, x -> x.toString());
        System.out.println(function);
    }


    public String function(int num, Function<Integer ,String> function){
        return function.apply(num);
    }

    @Test
    public void  test2(){
        //供给型接口
        String[] strings = supllice(10, () -> new String[10]);
        System.out.println(strings.length);
    }

    public String[] supllice(int num, Supplier<String[]> supplier){
       return supplier.get();
    }
}
