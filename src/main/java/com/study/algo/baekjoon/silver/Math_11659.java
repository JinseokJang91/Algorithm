package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Math_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합 구하기
        // N : 수의 개수
        // M : 합을 구해야 하는 횟수
        // i,j : 구간

        // e.g. 5, 4, 3, 2, 1
        // => 누적 합 : 5, 9, 12, 14, 15
        // 2 ~ 4 구간 합 : 4 + 3 + 2 = 9
        // 1 ~ 4 구간 합 : 14
        // 1 ~ 1 구간 합 : 5

        // [i ~ j 합] = [1 ~ j 합] - [1 ~ i 합] = [j - 1] - [i - 2] (단, i가 1이면 0으로 치환)

        StringBuilder result = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer nums = new StringTokenizer(br.readLine(), " ");
        int[] numArr = new int[N];
        int accumulatedSum = 0;
        for(int i = 0; i < N; i++) {
            accumulatedSum += Integer.parseInt(nums.nextToken());
            numArr[i] = accumulatedSum;
        }

        for(int x = 0; x < M; x++) {
            StringTokenizer sections = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(sections.nextToken());
            int j = Integer.parseInt(sections.nextToken());

            int periodSum = numArr[j - 1] - (i == 1 ? 0 : numArr[i - 2]);

            result.append(periodSum).append("\n");
        }

        bw.write(result.toString());

        br.close();
        bw.close();
    }
}
