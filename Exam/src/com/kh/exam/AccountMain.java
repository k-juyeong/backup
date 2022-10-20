package com.kh.exam;

import java.awt.*;
import java.util.Scanner;

public class AccountMain {
    public static void main(String[] args) {

        Account[] accounts = new Account[5];
        Scanner scanner = new Scanner(System.in);

        boolean stop = false;
        do {
            System.out.println();
            System.out.println("===================================================================");
            System.out.println("[메뉴] 1.신규 2.폐지 3.입금 4.출금 5.계좌조회(개별) 6.계좌조회(전체) 7.종료");
            System.out.println("===================================================================");
            System.out.print("원하는 메뉴 번호를 입력하세요: ");
            int menu = Integer.parseInt(scanner.nextLine());

            switch (menu) {
                case 1: // 신규
                    System.out.print("개설할 계좌의 이름을 입력하세요: ");
                    String name = scanner.nextLine();

                    boolean sameName = false;
                    int flag=0;
                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] == null) {
                            continue;
                        }
                        if (accounts[i].getAccountOwner().equals(name)) {
                            System.out.println("동일한 이름의 계좌가 있습니다.");
                            sameName = true;
                            break;
                        }
                    }
                    if (sameName) {
                        flag = 1;
                    } else {
                        for (int j = 0; j < accounts.length; j++) {
                            if (accounts[j] == null) {
                                accounts[j] = new Account(name);
                                accounts[j].getAccountOwner();
                                accounts[j].getAccountNumber();
                                flag = 2;
                                break;
                            }
                        }
                    }

                    if (flag == 1) {

                    } else if (flag == 2) {
                        System.out.println("계좌를 개설하였습니다.");
                    } else {
                        System.out.println("여유 계좌가 없습니다.");
                    }
                    break;
                case 2: // 폐지
                    System.out.print("폐지하실 계좌의 번호를 입력하세요: ");
                    String accountNumber = scanner.nextLine();

                    int flag2 = 0;
                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] == null) {
                            continue;
                        }
                        if (accounts[i].getAccountNumber2().equals(accountNumber)) {
                            if (accounts[i].getBalance() > 0) {
                                System.out.println("잔액이 있어 폐지할 수 없습니다.");
                                flag2 = 1;
                                break;
                            } else {
                                accounts[i] = null;
                                flag2 = 2;
                            }
                            break;
                        }
                    }
                    if (flag2 == 1) {

                    } else if (flag2 == 2) {
                        System.out.println("계좌를 폐지하였습니다.");
                    } else {
                        System.out.println("입력한 번호의 계좌가 존재하지 않습니다.");
                    }
                    break;
                case 3: // 입금
                    System.out.print("입금하실 계좌의 번호를 입력하세요: ");
                    String accountNumber2 = scanner.nextLine();

                    boolean flag3 = false;
                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] == null) {
                            continue;
                        }
                        if (accounts[i].getAccountNumber2().equals(accountNumber2)) {
                            System.out.print("입금할 금액을 입력하세요: ");
                            int money = Integer.parseInt(scanner.nextLine());
                            accounts[i].deposit(money);
                            flag3 = true;
                            break;
                        }
                    }
                    if (!flag3) {
                        System.out.println("입력한 번호의 계좌가 존재하지 않습니다.");
                    }
                    break;
                case 4: // 출금
                    System.out.print("출금하실 계좌의 번호를 입력하세요: ");
                    String accountNumber3 = scanner.nextLine();

                    boolean flag4 = false;
                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] == null) {
                            continue;
                        }
                        if (accounts[i].getAccountNumber2().equals(accountNumber3)) {
                            System.out.print("출금할 금액을 입력하세요: ");
                            int money = Integer.parseInt(scanner.nextLine());
                            accounts[i].withdraw(money);
                            flag4 = true;
                            break;
                        }
                    }
                    if (!flag4) {
                        System.out.println("입력한 번호의 계좌가 존재하지 않습니다.");
                    }
                    break;
                case 5: // 계좌조회(개별)
                    System.out.print("조회하실 계좌의 번호를 입력하세요: ");
                    String accountNumber4 = scanner.nextLine();

                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] == null) {
                            continue;
                        }
                        if (accounts[i].getAccountNumber2().equals(accountNumber4)) {
                            System.out.println("[조회된 계좌번호의 예금주 이름: " + accounts[i].getAccountOwner() + ", 잔고: " + accounts[i].getBalance()+"]");
                            break;
                        }
                    }
                    break;
                case 6: // 계좌조회(전체)
                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] == null) {
                            continue;
                        } else {
                            System.out.println(accounts[i].toString());
                        }
                    }

                    int countNotNull = 0;
                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] != null) {
                            countNotNull++;
                        }
                    }
                    System.out.println("사용중인 계좌수: " + countNotNull);

                    int countNull = 0;
                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] == null) {
                            countNull++;
                        }
                    }
                    System.out.println("잔여계좌수: " + countNull);
                    break;
                case 7:
                    System.out.println("작업을 종료합니다.");
                    stop = true;
                    break;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
                    break;
            }
        } while (!stop);

    }
}
