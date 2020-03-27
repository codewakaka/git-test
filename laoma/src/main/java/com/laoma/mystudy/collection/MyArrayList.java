package com.laoma.mystudy.collection;

import java.util.*;

public class MyArrayList<E> {
    private int size;

    /**
     *
     */
    transient Object[] elementData;

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8 ;

    protected transient int modCount = 0;
   /**
    * 添加元素时使用 ensureCapacityInternal() 方法来保证容量足够，如果不够时，
    * 需要使用 grow() 方法进行扩容，新容量的大小为 oldCapacity + (oldCapacity >> 1)，也就是旧容量的 1.5 倍。
    * 扩容操作需要调用 Arrays.copyOf() 把原数组整个复制到新数组中，这个操作代价很高，
    * 因此最好在创建 ArrayList 对象时就指定大概的容量大小，减少扩容操作的次数。
    */

   public MyArrayList(){
       this.elementData = new Object[DEFAULT_CAPACITY];
   }

   public void add(E e){
       ensureCapacityInternal(size + 1);
       elementData[size++] = e;
   }
   private void ensureCapacityInternal(int minCapacity){
       //空判断
     if(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
         minCapacity = Math.max(DEFAULT_CAPACITY,minCapacity);
     }
       ensureExplicitCapacity(minCapacity);
   }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        if(minCapacity - elementData.length >0){
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
       int oldCapacity = elementData.length;
       int newCapacity = oldCapacity + (oldCapacity >> 1);
       if(newCapacity - minCapacity  < 0 ) newCapacity =minCapacity;
       if(newCapacity - MAX_ARRAY_SIZE >0 ) newCapacity = hugeCapacity(minCapacity);
       elementData = Arrays.copyOf(elementData,newCapacity);

    }

    private int hugeCapacity(int minCapacity) {
       if(minCapacity <0 )throw new NullPointerException();
       return (minCapacity > MAX_ARRAY_SIZE)?Integer.MAX_VALUE:MAX_ARRAY_SIZE;
    }
    /**
     * 需要调用 System.arraycopy() 将 index+1 后面的元素都复制到 index 位置上
     * */
    public E remove(int index){
       rangeIndex(index);
       modCount++;
       E oldValue = elementData(index);
        int numMover = size -index -1;
        if(numMover > 0  )System.arraycopy(elementData,index+1,elementData,index,numMover);
        elementData[--size] = null;
        return oldValue;
    }

    private void rangeIndex(int index) {
       if(index >size) throw new IndexOutOfBoundsException();
    }

    @SuppressWarnings("unchecked")
    private E elementData(int index) {
        return (E) elementData[index];
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.remove(2);
    }
}
