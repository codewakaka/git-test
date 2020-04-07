package com.laoma.mystudy.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author xgh
 * @date ：Created on 2020/4/3
 * @Desc: 左侧：lambda表达式的参数列表
 * 右侧：lambda表达式中所需执行的功能，lambda体
 */
public class LambdaOne {


    /**
     * 语法格式一：无参数，无返回值
     * （）->System.out.println("hello")
     */
    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        r.run();
        System.out.println("=============");
        Runnable r1 = () -> System.out.println("lambda hello");
        r1.run();
    }

    /**
     * 语法格式二：一个参数，无返回值
     */
    @Test
    public void test2() {
        Consumer consumer = (x) -> System.out.println(x);
        consumer.accept("hello ");
    }

    /**
     * 语法格式三：一个参数（参数括号可以不写），无返回值
     */
    @Test
    public void test3() {
        Consumer consumer = x -> System.out.println(x);
        consumer.accept("hello ");
    }

    /**
     * 语法格式四：有两个参数，并且有多条语句
     */
    @Test
    public void test4(){
        Comparator<Integer> c = (a,b)->{
            System.out.println("11111");
            return Integer.compare(a,b);
        };
    }

    /**
     * 语法格式五：如果只有一条语句，大括号和return都可以不写
     */
    @Test
    public void test5(){
        Comparator<Integer> c = (a,b)-> Integer.compare(a,b);
    }
    /**
     * 语法格式六：lambda表达式参数列表的数据类型，都可以不写
     */
    @Test
    public void test6(){
        Comparator<Integer> c = (Integer a,Integer b)-> Integer.compare(a,b);
    }
}
