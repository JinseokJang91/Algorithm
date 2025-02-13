package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Bfs_1931 {
    static int n;
    static int[][] triangle;
    static int[][] sumTriangle;
    static int maxSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];
        sumTriangle = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // i 번째 줄의 j 인덱스가 max 값이면,
        // 다음 줄에 방문할 수 있는 위치는 무조건 i+1, j 또는 i+1, j+1 이다.

        // 꼭대기는 값 고정
        sumTriangle[0][0] = triangle[0][0];

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < i + 1; j++) {
                sumTriangle[i+1][j] = Math.max(sumTriangle[i][j] + triangle[i+1][j], sumTriangle[i+1][j]);
                sumTriangle[i+1][j+1] = Math.max(sumTriangle[i][j] + triangle[i+1][j+1], sumTriangle[i+1][j+1]);
            }
        }

        // 마지막 줄에서 가장 큰 합 추출
        for(int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, sumTriangle[n-1][i]);
        }

        bw.write(maxSum);

        br.close();
        bw.close();
    }
}
