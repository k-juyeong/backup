package com.kh.exam3;

import java.awt.*;
import java.util.Scanner;

public class AccountMain {
    public AccountMain() {
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean stop = false;
        Account account = null;

        do {
            System.out.println();
            System.out.println("ATM 은행");
            System.out.println("[메뉴] 1.계좌 개설 2.입금 3.출금 4.잔액조회 5.종료");
            System.out.print("원하는 메뉴 번호를 입력하세요 : ");
            int num = Integer.parseInt(scanner.nextLine());

            switch (num) {
                case 1:
                    System.out.println();
                    System.out.print("이름을 입력하세요 : ");
                    String name = scanner.nextLine();
                    account = new Account(name);
                    break;
                case 2:
                    if (account == null) {
                        System.out.println("계좌를 찾을 수 없습니다 => 계좌를 먼저 개설해주세요");
                        break;
                    }
                    System.out.println();
                    System.out.print("입금하실 금액을 입력하세요 : ");
                    int deposit = Integer.parseInt(scanner.nextLine());
                    account.deposit(deposit);
                    break;
                case 3:
                    if (account == null) {
                        System.out.println("계좌를 찾을 수 없습니다 => 계좌를 먼저 개설해주세요");
                        break;
                    }
                    System.out.println();
                    System.out.print("출금하실 금액을 입력하세요 : ");
                    int withdraw = Integer.parseInt(scanner.nextLine());
                    account.withdraw(withdraw);
                    break;
                case 4:
                    if (account == null) {
                        System.out.println("계좌를 찾을 수 없습니다 => 계좌를 먼저 개설해주세요");
                        break;
                    }
                    System.out.println();
                    System.out.println(account);
                    break;
                case 5:
                    System.out.println("작업을 종료합니다.");
                    stop = true;
                    break;
                default:
                    System.out.println("없는 메뉴입니다 => 메뉴번호를 다시 입력해주세요");
                    break;
            }
        }while (!stop);



    }


}
