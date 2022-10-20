package com.kh.exercise10.q8;
/*
   1. 상속관계에서 멤버 필드는 상속되지 않는다. (재정의할 수 없다.)
   2. 상속관계에서 인스턴스 멤버 메소드는 상속될 때 재정의할 수 있다.
   3. static 멤버는 클래스, 인터페이스에 고정되어 사용된다.
   4. private, static 멤버 메소드는 상속불가.
 */
class A {
    int m=2;
    static int n=4;

    void method1() {
        System.out.println("A 클래스 instance method");
    }
    static void method2() {
        System.out.println("A 클래스 static method");
    }

    private void method3() {
        System.out.println("A 클래스 private instance method");
    }
}
