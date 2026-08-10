package com.study.algo.programmers;

public class V20260811 {
    public static void main(String[] args) {
        int[] arr1 = {2,6,8,14};
        int answer1 = solution1(arr1);
        System.out.println("answer1 = " + answer1); // 168

        int[] arr2 = {12, 14, 16};
        int answer2 = solution1(arr2);
        System.out.println("answer2 = " + answer2); // 336
    }

    public static int solution1(int[] arr) {
        // ⭐유클리드 호제법
        // : 두 자연수의 최대공약수를 구하기 위한 대표적인 알고리즘
        // a > b일 때, a % b = r
        // r = 0이면 b가 최대공약수
        // r > 0이면 a 대신 b, b 대신 r을 넣어 나머지 구하는 계산 반복(b % r)

        // 최대공약수: GCD, 최소공배수: LCM이라고 할 때,
        // a * b = GCD * LCM

        int lcm = arr[0];
        for(int i = 1; i < arr.length; i++) {
            lcm = getLCM(lcm, arr[i]);
        }

        return lcm;
    }

    private static int getGCM(int a, int b) {
        if(a > b) {
            int r = a % b;
            return r == 0 ? b : getGCM(b, r);
        } else if(b > a) {
            int r = b % a;
            return r == 0 ? a : getGCM(a, r);
        } else {
            return 1;
        }
    }

    private static int getLCM(int a, int b) {
        int gcm = getGCM(a, b);
        return a * b / gcm;
    }
}
