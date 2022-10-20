package com.kh.day16.q2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        list2.add("hello");
        System.out.println(list2);
        list2.remove("hello");
        System.out.println(list2);
    }
}
