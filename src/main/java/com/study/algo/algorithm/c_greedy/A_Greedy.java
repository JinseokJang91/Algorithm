package com.study.algo.algorithm.c_greedy;

import java.io.*;
import java.util.StringTokenizer;

public class A_Greedy {
    public static void main(String[] args) throws IOException {
        // 백준 11047번 동전 개수의 최솟값 구하기
        // 동전 개수의 최솟값 = 큰 금액의 동전으로 최대한 많이 구성

        // 1. 슈도코드 작성
        // 동전 개수 N, 목표 금액 K 입력 받기
        // N개의 동전 배열 coins[] 세팅하기
        // for(N-1 ~ 0 역순)
        // {
        //   if(목표금액 k보다 동전 가치가 작으면) {
        //     동전수 += 목표 금액 / 동전 가치 // 동전 개수 누적
        //     목표 금액 = 목표 금액 % 동전 가치 // 사용한 동전 금액 뺀 나머지 금액만 남겨놓기
        //   }
        // }

        // 2. 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i = N - 1; i >= 0; i--) {
            if(coins[i] <= K) {
                count += K / coins[i];
                K = K % coins[i];
            }
        }

        bw.write("" + count);

        br.close();
        bw.close();
    }
}
