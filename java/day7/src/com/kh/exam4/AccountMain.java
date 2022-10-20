package com.kh.exam4;

import java.util.Scanner;

public class AccountMain {
    public AccountMain() {
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean stop = false;
        Account[] account = new Account[10];

        do {
            System.out.println();
            System.out.println("ATM 은행");
            System.out.println("[메뉴] 1.계좌 개설 2.입금 3.출금 4.잔액조회 5.종료");
            System.out.print("원하는 메뉴 번호를 입력하세요 : ");
            int num = Integer.parseInt(scanner.nextLine());

            boolean stop2 = false;
            int i=0;
            i++;
            switch (num) {
                case 1:
                    System.out.println();
                    System.out.print("이름을 입력하세요 : ");
                    String name = scanner.nextLine();

                    boolean flag = false;
                    do {
                        int j=0;
                        for (j= 0; j < account.length; j++) {
                            if (account[j] == null) {
                                account[j] = new Account(name);
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            System.out.println("계좌를 만들 수 없습니다.");
                            stop = true;
                        } else {
                            System.out.println("account["+j+"]"+"번 계좌 개설 완료!");
                        }
                    }while (!stop2);
                    break;
                case 2:
                    if (account[i] == null) {
                        System.out.println("계좌를 찾을 수 없습니다 => 계좌를 먼저 개설해주세요");
                        break;
                    }
                    System.out.println();
                    System.out.print("입금하실 금액을 입력하세요 : ");
                    int deposit = Integer.parseInt(scanner.nextLine());
                    account[i].deposit(deposit);
                    break;
                case 3:
                    if (account[i] == null) {
                        System.out.println("계좌를 찾을 수 없습니다 => 계좌를 먼저 개설해주세요");
                        break;
                    }
                    System.out.println();
                    System.out.print("출금하실 금액을 입력하세요 : ");
                    int withdraw = Integer.parseInt(scanner.nextLine());
                    account[i].withdraw(withdraw);
                    break;
                case 4:
                    if (account[i] == null) {
                        System.out.println("계좌를 찾을 수 없습니다 => 계좌를 먼저 개설해주세요");
                        break;
                    }
                    System.out.println();
                    System.out.println(account);
                    break;
                case 5:
                case 6:
                case 7:
                    System.out.println("작업을 종료합니다.");
                    stop = true;
                    break;
                default:
                    System.out.println("없는 메뉴입니다 => 메뉴번호를 다시 입력해주세요");
                    break;
            }
            i++;
        }while (!stop);



    }


}
