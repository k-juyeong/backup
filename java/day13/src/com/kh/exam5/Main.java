package com.kh.exam5;
/*
    unchecked exception
 */
public class Main {
    public static void main(String[] args) {


            method1();


    }

    private static void method1() {
            method2();
    }

    private static void method2() {
        int[] arr = new int[3];
        arr[3] = 10;
    }
}
