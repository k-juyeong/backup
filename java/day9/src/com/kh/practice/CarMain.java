package com.kh.practice;

import java.util.Scanner;
import java.util.ServiceConfigurationError;

public class CarMain {
    public static void main(String[] args) {
        Car[] cars = new Car[5];
        Scanner scanner = new Scanner(System.in);


        boolean stop = false;
        do {
            System.out.println("메뉴] 1.입고 2.출고 3.현황 4.종료");
            System.out.print("입력할 번호 : ");
            int num = Integer.parseInt(scanner.nextLine());

            switch (num) {
                case 1: //입고
                    System.out.println("입고할 색상 입력: ");
                    String color=scanner.nextLine();
                    boolean flag = false;
                    for (int i = 0; i < cars.length; i++) {
                        if (cars[i] == null) {
                            cars[i] = new Car(color);
                            cars[i].getColor();
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("여유 차량이 없음");
                        stop=true;
                    } else {
                        System.out.println("입고 완료");
                    }
                    break;
                case 2: //출고
                    System.out.println("출고할 색상 입력: ");
                    String color2=scanner.nextLine();
                    boolean flag2 = false;
                    for (int i = 0; i < cars.length; i++) {
                        if (cars[i] == null) {
                            continue;
                        }
                        if (cars[i].getColor().equals(color2)) {
                            cars[i] = null;
                            flag2 = true;
                            break;
                        }
                    }
                    if (!flag2) {
                        System.out.println("잘못 입력하셨습니다.");
                        continue;
                    } else {
                        System.out.println("출고 완료");
                    }
                    break;
                case 3: //현황
                    for (Car car : cars) {
                        if(car ==null) continue;
                        System.out.println(car.getColor());
                    }
                    break;
                case 4: //종료
                    System.out.println("작업을 종료합니다");
                    stop = true;
                    break;
                default:
                    System.out.println("번호 입력 오류");
                    break;
            }
        } while (!stop);
    }
}
