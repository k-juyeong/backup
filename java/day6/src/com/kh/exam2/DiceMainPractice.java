package com.kh.exam2;

public class DiceMainPractice {
    public static void main(String[] args) {
        DicePractice d1 = new DicePractice("blue", "small", "Korea");
        System.out.print("첫번째 숫자: ");
        d1.throwDice();

        DicePractice d2 = new DicePractice("red", "big", "China");
        System.out.print("두번째 숫자: ");
        d2.throwDice();

//        DicePractice[] arr = new DicePractice[2];
//        arr[0] = d1;
//        arr[1] = d2;

        DicePractice d3 = new DicePractice("blue", "big", "Korea");

        int sum = d3.total(d1.result, d2.result);
        System.out.println("두 숫자 합: " + sum);


        d3.isOverTen(d1.result, d2.result);
        System.out.println(d3.result3);
//        if (sum >= 10) {
//            System.out.println("당첨");
//        } else {
//            System.out.println("꽝");
//        }

    }
}
