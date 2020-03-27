package com.test;

import java.util.ArrayList;

/**
 * @author xgh
 * @date ：Created on 2020/3/23
 */
public class TWO {


    /**2.	给定一个字符串数组a，求该数组的非空子集，分别打印出来各子集

     举例数组为["a","b","c"]

     他的子集是["a"],["b"],["c"] ,["a","b"],["a","c"],["b","c"],["a","b","c"].

     注意事项：您可以假定该字符串只包含小写字母。*/

    public static void main(String[] args) {
        String[] a = new String[]{"a","b","c"};
        for (int i = 0; i <a.length ; i++) {
            for (int j = a.length-1; j < 0; j--) {

            }
        }
        ArrayList<Integer>  b = new ArrayList();
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(4);
        for (int i = 0; i <b.size() ; i++) {
            if(i ==1){

                b.remove(i);
            }
        }
    }
}
