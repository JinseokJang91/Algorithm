package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class DynamicProgrammin_1010 {
    private static int[][] dp;
    private static StringBuilder result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 규칙 찾기
        // N = 1, M = 1, 2, 3, 4 일 때 => 1  2  3  4
        // N = 2, M = 2, 3, 4, 5 일 때 => 1  3  6  10
        // N = 3, M = 3, 4, 5, 6 일 때 => 1  4  10 20

        // N = 3, M = 6 일 때 20 => N = 2, M = 2, 3, 4, 5의 누적 합
        // N, M 일 때 => N-1, N-1 ~ (N-1 + (M-N+1)) 까지의 누적 합

        int T = Integer.parseInt(br.readLine());
        result = new StringBuilder();

        StringTokenizer st = null;
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            dp = new int[N + 1][M - N + 2];

            calculateBridges(N, M);

            result.append(dp[N][M - N + 1]).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void calculateBridges(int n, int m) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= (m - n + 1); j++) {
                // 배열 i,j에 각각 N,M으로 추출한 다리 개수 입력
                if(i == 1) {
                    dp[i][j] = j;
                } else {
                    for(int k = 1; k <= j; k++) {
                        dp[i][j] += dp[i - 1][k];
                    }
                }
            }
        }

//        System.out.println("------------------");
//        for(int[] i : dp) {
//            for(int j : i) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("------------------");
    }
}
