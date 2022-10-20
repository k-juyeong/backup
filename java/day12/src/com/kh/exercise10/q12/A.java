package com.kh.exercise10.q12;

class A {
    int data;
    A(int data) {
        this.data=data;
    }

    @Override
    public boolean equals(Object obj) {
        return this.data==((A)obj).data;
    }
}
