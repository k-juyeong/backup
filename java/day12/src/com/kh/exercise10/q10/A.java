package com.kh.exercise10.q10;
/*
    this(), super() 같이 올 수 없다.
 */
public class A {
    A() {
        System.out.println("A 생성자1");
    }
    A(int a) {
        this();
        System.out.println("A 생성자2");
    }
}
