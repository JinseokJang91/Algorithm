package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class DynamicProgramming_1535 {
    private static int N;
    private static final int M = 99; // 체력 최대치
    private static int[] lost;
    private static int[] get;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫째줄 : 사람의 수
        // 둘째줄 : 각 사람에게 인사할 때 잃는 체력
        // 셋째줄 : 각 사람에게 인사할 때 얻는 기쁨

        // N번째 사람에게 인사한 경우
        // => 최대 체력 99 - N번째 사람으로 잃는 체력
        // => N번째 사람으로 얻는 기쁨

        N = Integer.parseInt(br.readLine());
        lost = new int[N + 1];
        get = new int[N + 1];
        dp = new int[N + 1][M + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            lost[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            get[i] = Integer.parseInt(st.nextToken());
        }

        calculateJoy();

        bw.write("" + dp[N][M]);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void calculateJoy() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(lost[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - lost[i]] + get[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

//        for(int[] arr : dp) {
//            for(int i : arr) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
    }
}
