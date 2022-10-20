package com.kh.exam5;
/*
    checked exception
 */
public class Main2 {
    public static void main(String[] args) {


        try {
            method1();
        } catch (Exception e) {
            throw new RuntimeException(e);

        }


    }

    private static void method1() throws InterruptedException {
        method2();
    }

    private static void method2() throws InterruptedException{

            Thread.sleep(1000);

    }
}
