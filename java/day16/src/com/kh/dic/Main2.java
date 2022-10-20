package com.kh.dic;

import java.util.TreeMap;

public class Main2 {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("student", "학생");


        String str = map.put("student", "학생2");
        if (str == null) {
            System.out.println("null");
        } else {
            System.out.println(str);
        }

        String str2 = null;
        System.out.println("bb" + str2 + "aaa");
    }
}
