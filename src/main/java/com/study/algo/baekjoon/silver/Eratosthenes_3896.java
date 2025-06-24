package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.Arrays;

public class Eratosthenes_3896 {
    private static boolean[] isPrime;
    private static int bigPrime;
    private static int smallPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // 양의 정수 k가 주어졌을 때, k를 포함하는 소수 사이 수열의 길이 구하기
        // k가 10이면 7, 11 사이 길이는 11 - 7 : 4
        // k가 11이면 11이 소수이므로 길이는 0

        // k의 범위는 1보다 크고, 100000번 째 소수(1299709)와 작거나 같음
        isPrime = new boolean[1299709 + 1];
        for(int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for(int i = 2; i < isPrime.length; i++) {
            if(!isPrime[i]) {
                continue;
            }

            for(int j = i * 2; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());

            if(!isPrime[k]) {
                findBigPrime(k);
                findSmallPrime(k);
                result.append(bigPrime - smallPrime).append("\n");
            } else {
                result.append(0).append("\n");
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void findBigPrime(int k) {
        if(isPrime[k + 1]) {
            bigPrime = k + 1;
        } else {
            findBigPrime(k + 1);
        }
    }

    private static void findSmallPrime(int k) {
        if(isPrime[k - 1]) {
            smallPrime = k - 1;
        } else {
            findSmallPrime(k - 1);
        }
    }
}
