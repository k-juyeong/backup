package com.kh.exercise14.q7;

public class A {
    void abc(double score) throws ScoreException {
        if (score >= 3.0) {
            System.out.println("장학금 대상자");
        } else {
            throw new ScoreException("학점 미달");
        }
    }
}
