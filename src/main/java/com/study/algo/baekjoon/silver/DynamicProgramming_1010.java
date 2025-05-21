package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class DynamicProgramming_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // 조합 문제 : nCr 조합 공식 사용 (n개중 r개를 뽑는 경우의 수)

        int[][] dp = new int[30][30];

        for(int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for(int i = 2; i < 30; i++) {
            for(int j = 1; j < 30; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            result.append(dp[M][N]).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
