package com.kh.exercise12.q3;

public class Main {
    public static void main(String[] args) {

        A a = new A() {
            void abc() {
                System.out.println("반갑습니다.");
            }
        };

        a.abc();

        A b = new A() {
            void abc() {
                System.out.println("반갑습니다.");
            }
        };

        b.abc();

        A c = new B();
        c.abc();
        A d = new B();
        d.abc();

        A e = new A() {
            @Override
            void abc() {
                System.out.println("반갑습니다.");
            }
        };


    }
}
