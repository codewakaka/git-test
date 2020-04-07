package com.laoma.mystudy.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xgh
 * @date ：Created on 2020/4/6
 */
public class LambdaTwo {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 12, 9999.99),
            new Employee("李四", 42, 4444.99),
            new Employee("张一", 12, 3333.99),
            new Employee("赵六", 32, 6666.99),
            new Employee("田七", 52, 5555.99),
            new Employee("吴八", 11, 4444.99)
    );

    //对对象进行排序，先排age再排名字

    @Test
    public void test1() {
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        employees.forEach(System.out::println);
    }


    //字母大小写转换
    @Test
    public void test2() {
        toUp("abcdefg", s -> s.toUpperCase());
        toUp("\t\t\t\tabcdefg", s -> s.trim());
    }


    public String toUp(String str, MyFunction myFunction) {
        System.out.println(myFunction.getValue(str));
        return myFunction.getValue(str);
    }


    @Test
    public void Test3() {
        sum(100L, 200L, (t1, t2) -> t1 + t2);
        sum(100L, 200L, (t1, t2) -> t1 * t2);
    }

    public Long sum(long l1, long l2, MyFuntion2<Long, Long> myFuntion2) {
        System.out.println(myFuntion2.getValue(l1, l2));
        return myFuntion2.getValue(l1, l2);
    }


}
