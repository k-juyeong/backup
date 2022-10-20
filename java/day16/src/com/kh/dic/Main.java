package com.kh.dic;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();

        map.put("student", "학생");
        map.put("teacher", "교사");
        map.put("classroom", "교실");
        map.put("smart", "현명한");
        map.put("lunch", "점심");

        String inputWord = "st";

        char firstLetter = inputWord.charAt(0);
        System.out.println(firstLetter);
        char firstLetter2 = (char)(inputWord.charAt(0) + 1);
        System.out.println(firstLetter2);
        String nextLetter = "" + firstLetter2;
        NavigableMap<String, String> subMap = map.subMap(inputWord, true, nextLetter, false);
        System.out.println(subMap);


        int x=10;
        System.out.println(x+"");
        System.out.println(String.valueOf(x));

        //기본타입 => 문자열 String.valueOf(기본타입)
        //문자열 => 기본타입

    }
}
