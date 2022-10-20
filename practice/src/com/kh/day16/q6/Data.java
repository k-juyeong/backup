package com.kh.day16.q6;

import java.util.Objects;

public class Data {
    int m;
    int n;

    public Data(int m) {
        this.m = m;
    }

    public Data(int m, int n) {
        this.m = m;
        this.n = n;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Data) {
            return this.m == ((Data) o).m && this.n == ((Data) o).n;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(m, n);
    }
}
