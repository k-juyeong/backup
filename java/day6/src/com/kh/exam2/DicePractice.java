package com.kh.exam2;

public class DicePractice {

    String color;
    String size;
    String maker;


    int result;
    int result2;

    String result3;
    public DicePractice(String color, String size, String maker) {
        this.color = color;
        this.size = size;
        this.maker = maker;
    }

    public void throwDice() {
        this.result = (int) Math.floor(Math.random() * 6) + 1;
        System.out.println(result);
    }

    public int total(int x, int y) {
        this.result2 = x + y;
        return result2;
    }

    public String isOverTen(int x, int y) {
        int total = x + y;
        if (total >= 10) {
            this.result3 = "당첨";
        } else {
            this.result3 = "꽝";
        }

        return result3;
    }
}
