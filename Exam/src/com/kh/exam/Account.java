package com.kh.exam;

import java.util.Scanner;

public class Account {

    private String accountOwner;
    private int balance;
    private int accountNumber;
    private final int MINBALANCE = 0;
    private final int MAXBALANCE = 100_000;
    private final int ACCOUNTNUMBER_SIZE = 3;

    private static int count;


    // 생성자 메소드
    public Account(String name) {
        this.accountOwner = name;
        accountNumber = ++count;
    }

    //Getter, Setter

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountNumber2() {
        String tmp = accountNumber + "";
        int length = ACCOUNTNUMBER_SIZE - tmp.length();
        for (int i = 0; i < length; i++) {
            tmp = "0" + tmp;
        }
        return tmp;
    }


    // 입금
    public void deposit(int money) {
        if (money <= 40_000 && money > 0) {
            if ((balance + money) > MAXBALANCE) {
                System.out.println("예치금액은 10만원 이하입니다.");
            } else {
                System.out.println("입금되었습니다.");
                this.balance += money;
            }
        } else {
            System.out.println("1회 입금한도는 4만원입니다");
        }
    }

    // 출금
    public void withdraw(int money) {
        if (money <= 40_000 && money > 0) {
            if ((balance - money) < MINBALANCE) {
                System.out.println("출금하실 금액이 부족합니다.");
            }else {
                System.out.println("출금되었습니다.");
                this.balance -= money;
            }
        } else {
            System.out.println("1회 출금한도는 4만원입니다");
        }
    }

    // 조회
    @Override
    public String toString() {
        return "Account{" +
                "계좌 번호='" + getAccountNumber2() + '\'' +
                ", 예금주 이름='" + accountOwner + '\'' +
                ", 잔고=" + balance +
                '}';
    }
}
