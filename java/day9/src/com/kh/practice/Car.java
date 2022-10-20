package com.kh.practice;

public class Car {
    //색상, 브랜드
    private String color;
    private String maker;

    //생성자 메소드
    public Car(String color) {
        this.color = color;
    }


    //Getter, Setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", maker='" + maker + '\'' +
                '}';
    }
}
