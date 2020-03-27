package com.javaweb.study.nio;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyLinkHashMap {
    public static void main(String[] args) {
        LinkedHashMap linkHashMap = new LinkedHashMap(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 3;
            }
        };
        linkHashMap.put("project1", "zhangs");
        linkHashMap.put("project2", "lisi");
        linkHashMap.put("project3", "wangwu");
        linkHashMap.forEach((k, v) ->
                System.out.println("k -----"+k+"----v"+v)
        );
        System.out.println("=======================");
        linkHashMap.get("project2");
        linkHashMap.get("project2");
        linkHashMap.get("project3");
        linkHashMap.get("project1");

        linkHashMap.put("project4", "zhaoliu");
        linkHashMap.forEach((k, v) ->
                System.out.println("k： -----"+k+"----v："+v)
        );
    }
}
