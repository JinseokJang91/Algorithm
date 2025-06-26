package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Eratosthenes_15965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // K번째 소수 구하기 (1 <= k <= 500,000)
        int k = Integer.parseInt(br.readLine());

        // 소수 판별 및 List 세팅
        boolean[] isPrime = new boolean[7370000]; // 7,370,000으로 설정 시 소수 개수 500,082개 나옴
        for(int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        
        List<Integer> primeList = new ArrayList<>();
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

        // k번째 소수 출력
        bw.write("" + primeList.get(k - 1));

        bw.flush();
        bw.close();
        br.close();
    }
}
