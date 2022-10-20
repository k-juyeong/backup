package com.kh.day16.q6;

public class Test {
    public static void main(String[] args) {
//        int x = 10;
//        int y = 20;

//        int sum = sum(x, y);
//        int sum2 = sum(10, 20, 30);

        int[] y = new int[2];
        System.out.println("y="+y);

    }

    private static int sum(int... num) {
        int result=0;
        for (int i = 0; i < num.length; i++) {
            result += num[i];
        }
        return result;
    }

}
