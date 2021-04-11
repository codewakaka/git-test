package com.jvm.others;

public class Test<T> implements Compare<T> {

    @Override
    public int compar(T o) {
        return 0;
    }
}
