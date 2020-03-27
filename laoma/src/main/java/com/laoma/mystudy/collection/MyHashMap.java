package com.laoma.mystudy.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class MyHashMap<K,V> {
    /**
     *  1<< 4  aba = 16
     * */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4 ;

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final  float DEFAULT_LOAD_FACTOR = 0.75f;

    transient Node<K, V> table;

    transient int size;

    int threshold;

    transient int modCount;

    final float loadFactor;

    public MyHashMap(float loadFactor) {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    final float loadFactor() { return loadFactor; }

    public V put(K key,V value){
        return putVal(hash(key),key,value,false,true);
    }


    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <3000000 ; i++) {
                    hashMap.put(i+"-",i);
                }
            }
        });
        thread1.start();
        Thread thread2 =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("================"+hashMap.size());
            }
        });
        thread2.start();

        try {
           thread1.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(hashMap.size());

    }
    

    private V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K,V>  tab;
        Node<K,V> p;
        int n,i;
        if((tab = table) == null || (n = tab.length) == 0){
            
        }
        return null;
    }

    private static int hash(Object key){
        int h;
        return (key == null)? 0:(h = key.hashCode())^(h>>> 16);
    }

}
class Node<K,V> implements Map.Entry<K,V>{
    final  int hash;
    final K key;
    int length;
    V value;
    Node<K,V> next;

    Node(int hash, K key,V value,Node<K,V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public final K getKey() {
        return key;
    }

    @Override
    public final V getValue() {
        return value;
    }
    public final String toString(){
        return key +"="+value;
    }
    public final int hashCode(){
        return Objects.hashCode(key)^Objects.hashCode(value);
    }
    @Override
    public final V setValue(V newValue) {
        V oleValue = value;
        value = newValue;
        return oleValue;
    }
    public final boolean equals(Object o){
        if(o == this)return  true;
        if(o instanceof Map.Entry){
            Map.Entry<?,?> e = (Map.Entry<?, ?>) o;
            if(Objects.equals(key,e.getKey()) && Objects.equals(value,e.getValue())){
                return true;
            }
        }
        return false;
    }
}
