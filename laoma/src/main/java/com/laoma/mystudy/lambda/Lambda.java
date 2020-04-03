package com.laoma.mystudy.lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xgh
 * @date ：Created on 2020/4/3
 */
public class Lambda {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 12, 9999.99),
            new Employee("李四", 42, 4444.99),
            new Employee("王五", 22, 3333.99),
            new Employee("赵六", 32, 6666.99),
            new Employee("田七", 52, 5555.99),
            new Employee("吴八", 11, 4444.99)
    );
    public List<Employee> filterEmployee(List<Employee> list,MyExploer<Employee> my){
        List<Employee> employees = new ArrayList<>();
        for (Employee em:list) {
            if(my.chooser(em)){
                employees.add(em);
            }
        }
        return employees;
    }

    @Test
    public void Test2(){
        List<Employee> list =filterEmployee(employees,(e)-> e.getAge()>30);
        list.forEach(System.out::println);
     /*   Comparator<Integer> comparator = (x,y)-> Integer.compare(x,y);
        TreeSet treeSet = new TreeSet(comparator);*/
    }


    @Test
    public void Tests1() {
        List<Employee> collect = employees.stream()
                                          .filter((a) -> a.getAge() > 32)
                                          .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
