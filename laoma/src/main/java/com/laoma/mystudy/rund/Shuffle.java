package com.laoma.mystudy.rund;

import java.util.Arrays;
import java.util.Random;

public class Shuffle {

    private static void swap(int[] arr ,int i ,int j){
        int temp = arr[i] ;
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void shuffle(int[] arr){
        Random r = new Random();
        for (int i = arr.length ; i > 1 ; i--) {
            swap(arr,i-1,r.nextInt(i));
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[13];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));
        shuffle(arr);
        System.out.println(Arrays.toString(arr));
    }
}
