package com.study.algo.programmers;

public class V20260729 {
    public static void main(String[] args) {
        int n1 = 98765;
        int answer = solution(n1);
        System.out.println("answer = " + answer);
    }

    // 피보나치 수
    public static int solution(int n) {
        long[] fiboArr = new long[n + 1];
        fiboArr[0] = 0;
        fiboArr[1] = 1;

        for(int i = 2; i < fiboArr.length; i++) {
            fiboArr[i] = (fiboArr[i - 2] + fiboArr[i - 1]) % 1234567;
        }

        return (int)fiboArr[n];
    }
}
