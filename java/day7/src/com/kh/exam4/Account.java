package com.kh.exam4;

public class Account {

    private final int MAXDEPOSITMONEY = 100_000; //1회 입금한도
    private final int MINBALANCE = -1_000_000;    //마이너스 잔액한도

    private String accountOwner;
    private long balance;

    public Account(String name) {
        this.accountOwner = name;
    }

    //예금
    public void deposit(int depositMoney) {
        if (depositMoney <= MAXDEPOSITMONEY && depositMoney > 0) {
            this.balance += depositMoney;
        } else {
            System.out.println("1회 입금한도는 " + MAXDEPOSITMONEY + " 이하입니다.");
        }
    }

    //출금
    public void withdraw(int withdrawMoney) {
        if ((this.balance - withdrawMoney) >= MINBALANCE && withdrawMoney > 0) {
            this.balance -= withdrawMoney;
        } else {
            System.out.println("잔액 한도는 " + MINBALANCE + " 입니다.");
        }
    }

    //getter, setter
    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                this.accountOwner + " 님의 잔액 : "
                + this.balance +
                '}';
    }
}
