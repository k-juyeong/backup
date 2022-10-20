package com.kh.day16.q5;

public class Data {
    int m;

    public Data(int m) {
        this.m = m;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Data) {
            return this.m == ((Data) obj).m;
        } else {
            return false;
        }
    }
}
