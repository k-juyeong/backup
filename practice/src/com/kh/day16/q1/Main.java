package com.kh.day16.q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println(list1);

        Integer[] aArray = list1.toArray(new Integer[3]);
        System.out.println(Arrays.toString(aArray));

        List<Integer> list2 = Arrays.asList(1, 2);
        list2.add(3); //크기 고정이라 추가 불가
        System.out.println(list2);
    }
}
