package com.kh.exam2;

import java.util.Scanner;

public class Student {
    // 객체 변수들
    private String name;      // 이름
    private int quizscore;      // 퀴즈 점수
    private int midtermscore;    // 중간시험 점수
    private int finalscore;      // 기말시험 점수
    private double total;

    // 생성자메소드: 학생의 이름을 넘겨 받아 객체를 생성한다
    public Student(String studentName) {
        this.name = studentName;
    }

    // 학생의 이름을 반환한다
    public String getName() {
        return name;
    }

    // 학생의 퀴즈 점수를 반환한다
    public int getQuizScore() {
        return quizscore;
    }

    // 학생의 중간시험 점수를 반환한다
    public int getMidtermScore() {
        return midtermscore;
    }

    // 학생의 기말시험 점수를 반환한다
    public int getFinalScore() {
        return finalscore;
    }

    //   현 Student 객체의 정보에 대한 문자열을 반환한다.
    @Override
    public String toString() {
        String str = "";
        str += "이름: " + name + "\n";
        str += "퀴즈점수: " + quizscore + "\n";
        str += "중간점수: " + midtermscore + "\n";
        str += "기말점수: " + finalscore + "\n";
        return str;
    }

    // 이름을 주어진 값으로 변경한다
    public void setName(String Name) {
        this.name = Name;
    }

    // 퀴즈 점수를 주어진 값으로 변경한다
    public void setQuizScore(int QuizScore) {
        this.quizscore = QuizScore;
    }

    // 중간시험 점수를 주어진 값으로 변경한다
    public void setMidtermScore(int MidtermScore) {
        this.midtermscore = MidtermScore;
    }

    // 기말시험 점수를 주어진 값으로 변경한다
    public void setFinalScore(int FinalScore) {
        this.finalscore = FinalScore;
    }

    // 사용자에게 학생의 퀴즈 점수, 중간시험 점수와 기말시험 점수를 읽어 들인다.
    // 입력 요청시 이름을 사용한다. 예를 들면, ‘길동의 중간시험 점수를 입력하라.’
    public void inputGrades() {
        Scanner scan = new Scanner(System.in);
        System.out.print(this.getName() + " 학생의 퀴즈시험 점수를 입력하세요 : ");
        int num1 = Integer.parseInt(scan.nextLine());

        while (num1 > 100 || num1 < 0) {
            System.out.println("점수범위는 0이상이거나 100이하여야 합니다.");
            System.out.print(this.getName() + " 학생의 퀴즈시험 점수를 입력하세요 : ");
            num1 = Integer.parseInt(scan.nextLine());
        }

        System.out.print(this.getName() + " 학생의 중간시험 점수를 입력하세요 : ");
        int num2 = Integer.parseInt(scan.nextLine());

        while (num2 > 100 || num2 < 0) {
            System.out.println("점수범위는 0이상이거나 100이하여야 합니다.");
            System.out.print(this.getName() + " 학생의 중간시험 점수를 입력하세요 : ");
            num2 = Integer.parseInt(scan.nextLine());
        }

        System.out.print(this.getName() + " 학생의 기말시험 점수를 입력하세요 : ");
        int num3 = Integer.parseInt(scan.nextLine());

        while (num3 > 100 || num3 < 0) {
            System.out.println("점수범위는 0이상이거나 100이하여야 합니다.");
            System.out.print(this.getName() + " 학생의 기말시험 점수를 입력하세요 : ");
            num3 = Integer.parseInt(scan.nextLine());
        }

        this.quizscore = num1;
        this.midtermscore = num2;
        this.finalscore = num3;
    }

    // 학생의 시험 점수들의 총점을 계산하여 반환한다
    public double getTotal() {
        double total = this.quizscore + this.midtermscore + this.finalscore;
        this.total = total;
        return total;
    }


    // 학생의 학점을 반환한다 90이상 'A', 80이상 'B', 70이상 'C', 60이상 'D', 60미만 'F'
    // 여기에 메소드드를 삽입하세요
    public char getGrade() {
        double grade = this.total / 3.0;
        if (grade >= 90 && grade <= 100) {
            char yourGrade = 'A';
            return yourGrade;
        } else if (grade >= 80) {
            char yourGrade = 'B';
            return yourGrade;
        } else if (grade >= 70) {
            char yourGrade = 'C';
            return yourGrade;
        } else if (grade >= 60) {
            char yourGrade = 'D';
            return yourGrade;
        } else {
            char yourGrade = 'F';
            return yourGrade;
        }
    }


}
