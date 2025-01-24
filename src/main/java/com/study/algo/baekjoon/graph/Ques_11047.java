package com.study.algo.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Ques_11047 {
    static Integer[] coins;
    static int result;

    public static void main(String[] args) throws IOException {
        // N : 동전의 종류 개수
        // K : 최종 금액
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        coins = new Integer[N];

        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 내림차순 정렬
        Arrays.sort(coins, Comparator.reverseOrder());
        //Arrays.sort(coins, Collections.reverseOrder());

        for(int i = 0; i < coins.length; i++) {
            // 0원이 되면 종료
            if(K == 0) {
                break;
            }

            if(K >= coins[i]) {
                int share = K / coins[i]; // 몫
                K = K % coins[i]; // K를 나머지 금액으로 치환

                result += share; // 몫만큼의 경우의수 더하기
            }
        }

        System.out.println(result);

        br.close();
    }
}
