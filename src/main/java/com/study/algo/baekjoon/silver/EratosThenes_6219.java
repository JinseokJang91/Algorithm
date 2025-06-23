package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EratosThenes_6219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // A..B 내에서 숫자 D를 포함하는 소수의 개수 구하기
        // e.g. 10..15에서 3포함 소수는 13 - 1개
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[B + 1];

        // default true 처리
        for(int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        // 소수 만들기
        for(int i = 2; i < isPrime.length; i++) {
            if(!isPrime[i]) {
                continue;
            }

            // 소수의 배수는 소수가 아니므로 false 처리
            for(int j = i * 2; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }

        // A와 B 사이에 존재하는 소수 목록 추출
        List<String> primeNumberList = new ArrayList<>();
        for(int i = A; i <= B; i++) {
            if(isPrime[i]) {
                primeNumberList.add(String.valueOf(i));
            }
        }

        // D를 포함하는 소수 카운트
        int count = 0;
        for(String primeNum : primeNumberList) {
            if(primeNum.contains(String.valueOf(D))) {
                count++;
            }
        }

        bw.write("" + count);
        bw.flush();
        bw.close();
        br.close();
    }
}
