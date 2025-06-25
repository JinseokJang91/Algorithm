package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Eratosthenes_11502 {
    private static boolean[] isPrime;
    private static List<Integer> primeList;
    private static StringBuilder result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        isPrime = new boolean[1001];
        primeList = new ArrayList<>();

        // 소수 index 배열 만들기
        for(int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for(int i = 2; i < isPrime.length; i++) {
            if(!isPrime[i]) {
                continue;
            } else {
                primeList.add(i);
            }

            for(int j = i * 2; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }

        // 테스트 케이스
        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());

            result.append(findPrimes(k)).append("\n");
        }

        bw.write(result.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static String findPrimes(int x) {
        for(int i = 0; i < primeList.size(); i++) {
            if(primeList.get(i) > x) {
                return "0";
            }

            for(int j = i; j < primeList.size(); j++) {
                for(int k = j; k < primeList.size(); k++) {
                    int primeNum1 = primeList.get(i);
                    int primeNum2 = primeList.get(j);
                    int primeNum3 = primeList.get(k);
                    if(primeNum1 + primeNum2 + primeNum3 == x) {
                        return primeNum1 + " " + primeNum2 + " " + primeNum3;
                    }
                }
            }
        }

        return "0";
    }
}
