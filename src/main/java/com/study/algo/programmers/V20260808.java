package com.study.algo.programmers;

public class V20260808 {
    public static void main(String[] args) {
        int n1 = 4;
        long answer1 = solution1(n1);
        System.out.println("answer1 = " + answer1);

        int n2 = 5000;
        int answer2 = solution2(n2);
        System.out.println("answer2 = " + answer2);
    }

    // 멀리 뛰기
    public static long solution1(int n) {
        int answer = 0;
        // 1칸=1
        // 2칸=2
        // 3칸=3
        // 4칸=5
        // 5칸=8
        // 6칸=13
        // => 피노바치 수열(1,1,2,3,5,...)과 유사한 문제

        // n칸 = n-2칸 + n-1칸 (n>2)
        if(n == 1 || n == 2) {
            return n;
        }


        long[] cases = new long[n];
        cases[0] = 1;
        cases[1] = 2;

        for(int i = 2; i < n; i++) {
            cases[i] = (cases[i - 2] + cases[i - 1]) % 1234567;
        }

        return cases[n - 1];
    }

    // 점프와 순간 이동
    public static int solution2(int n) {
        int k = 0;

        while(true) {
            if(n < 1) {
                break;
            }

            if(n % 2 == 0) {
                n /= 2; // 짝수면, 순간이동 거리만큼 되돌아가기
            } else {
                n--; // 홀수면, 짝수로 이동하기 위해 한 칸 이동(배터리 소모)
                k++;
            }
        }

        return k;
    }
}
