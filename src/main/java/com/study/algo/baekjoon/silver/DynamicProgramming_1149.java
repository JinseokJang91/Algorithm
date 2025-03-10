package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class DynamicProgramming_1149 {
    static int[][] expenses;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다.
        // 2. 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
        // 3. N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
        // 4. i(2<=i<=N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
        // => 연속되는 두 개의 집은 색이 서로 달라야 함.
        // => 라인 별 최소값이 아닌 누적 최소값을 구해야 함

        // N : 집의 수
        // 각 Line : 색칠 비용 - 빨강, 초록, 파랑

        // [점화식]
        // 빨강 : expenses[N][0] = expenses[N][0] + Math.min(expenses[N-1][1], expenses[N-1][2])
        // 초록 : expenses[N][1] = expenses[N][1] + Math.min(expenses[N-1][0], expenses[N-1][2])
        // 파랑 : expenses[N][2] = expenses[N][2] + Math.min(expenses[N-1][0], expenses[N-1][1])

        int N = Integer.parseInt(br.readLine());
        expenses = new int[N][3];
        dp = new int[N][3];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            expenses[i][0] = Integer.parseInt(st.nextToken());
            expenses[i][1] = Integer.parseInt(st.nextToken());
            expenses[i][2] = Integer.parseInt(st.nextToken());
        }

        // 세 가지 색상 각각에서 시작했을 때 각각의 누적합을 구하고, 그 중 최소값을 구하면 됨
        for(int i = 1; i < N; i++) {
            // 1. 빨강
            expenses[i][0] += Math.min(expenses[i-1][1], expenses[i-1][2]);
            // 2. 초록
            expenses[i][1] += Math.min(expenses[i-1][0], expenses[i-1][2]);
            // 3. 파랑
            expenses[i][2] += Math.min(expenses[i-1][0], expenses[i-1][1]);
        }

//        System.out.println("expenses[N-1][0] = " + expenses[N-1][0]);
//        System.out.println("expenses[N-1][1] = " + expenses[N-1][1]);
//        System.out.println("expenses[N-1][2] = " + expenses[N-1][2]);

        int result = Math.min(Math.min(expenses[N-1][0], expenses[N-1][1]), expenses[N-1][2]);

        bw.write("" + result);

        br.close();
        bw.close();
    }
}
