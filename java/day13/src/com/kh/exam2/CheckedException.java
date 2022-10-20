package com.kh.exam2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    checked exception : 컴파일 시점에 반드시 예외처리해야하는 예외
 */
public class CheckedException {
    public static void main(String[] args) throws Exception {
        //Checked Exception(일반 예외)

        //1. InterruptedException
        Thread.sleep(1000);


        //2. ClassNotFoundException
        Class cls = Class.forName("java.lang.Object");


        //3. IOException
        InputStreamReader in = new InputStreamReader(System.in);
        in.read();


        //4. FileNotFoundException
        FileInputStream fis = new FileInputStream("text.txt");


        //5. CloneNotSupportedException
        A a1 = new A();
        A a2 = (A) a1.clone();
    }
}
