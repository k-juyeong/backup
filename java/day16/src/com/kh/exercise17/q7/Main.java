package com.kh.exercise17.q7;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        MyData md1 = new MyData("자바 프로그램");
        MyData md2 = new MyData("반가워");
        MyData md3 = new MyData("감사합니다");
        TreeSet<MyData> treeSet = new TreeSet<>();
        treeSet.add(md1);
        treeSet.add(md2);
        treeSet.add(md3);
        System.out.println(treeSet);

//        DescendingByDic descendingByDic = new DescendingByDic();
        TreeSet<MyData> treeSet2 = new TreeSet<>(new DescendingByDic());
        treeSet2.add(md1);
        treeSet2.add(md2);
        treeSet2.add(md3);
        System.out.println(treeSet2);

        Comparator op1 = new Comparator<MyData>() {
            @Override
            public int compare(MyData o1, MyData o2) {
                return o1.str.compareTo(o2.str) * -1;
            }
        };
        TreeSet<MyData> treeSet3 = new TreeSet<>(op1);
        treeSet3.add(md1);
        treeSet3.add(md2);
        treeSet3.add(md3);
        System.out.println(treeSet3);


        //1) 문자열 길이 오름차순(이름 있는 구현클래스-AscendingByLengthOfString)
        TreeSet<MyData> treeSet4 = new TreeSet<>(new AscendingByLengthOfString());
        treeSet4.add(md1);
        treeSet4.add(md2);
        treeSet4.add(md3);
        System.out.println(treeSet4);

        //2) 문자열 길이 오름차순(익명 구현클래스)
        Comparator op2 = new Comparator<MyData>() {
            @Override
            public int compare(MyData o1, MyData o2) {
                int result = 0;
                if (o1.str.length() > o2.str.length()) {
                    result = 1;
                } else if (o1.str.length() < o2.str.length()) {
                    result = -1;
                }
                return result;
            }
        };
        TreeSet<MyData> treeSet5 = new TreeSet<>(op2);
        treeSet5.add(md1);
        treeSet5.add(md2);
        treeSet5.add(md3);
        System.out.println(treeSet5);

        //3) 문자열 길이 내림차순(이름 있는 구현클래스-DescendingByLengthOfString)
        TreeSet<MyData> treeSet6 = new TreeSet<>(new DescendingByLengthOfString());
        treeSet6.add(md1);
        treeSet6.add(md2);
        treeSet6.add(md3);
        System.out.println(treeSet6);

        //4) 문자열 길이 내림차순(익명 구현클래스)
        Comparator op3 = new Comparator<MyData>() {
            @Override
            public int compare(MyData o1, MyData o2) {
                int result = 0;
                if (o1.str.length() > o2.str.length()) {
                    result = 1;
                } else if (o1.str.length() < o2.str.length()) {
                    result = -1;
                }
                return result * -1;
            }
        };
        TreeSet<MyData> treeSet7 = new TreeSet<>(op3);
        treeSet7.add(md1);
        treeSet7.add(md2);
        treeSet7.add(md3);
        System.out.println(treeSet7);
    }
}
