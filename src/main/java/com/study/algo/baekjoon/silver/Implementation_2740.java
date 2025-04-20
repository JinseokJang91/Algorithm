package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Implementation_2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 행렬 A : N x M
        // 행렬 B : M x K
        // 행렬 A와 행렬 B의 곱 구하기

        // 행렬의 곱
        // | a b | x | e f | = | (a*e + b*g) (a*f + b*h) |
        // | c d |   | g h |   | (c*e + d*g) (c*f + d*h) |

        // 곱 결과 행렬의 크기 : N x K

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        st.nextToken();

        int K = Integer.parseInt(st.nextToken());
        int[][] B = new int[M][K];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 반복문
        int[][] result = new int[N][K];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                int cal = 0;
                for(int k = 0; k < M; k++) {
                    cal += A[i][k] * B[k][j];
                }
                result[i][j] = cal;
            }
        }

        for(int[] arr : result) {
            for(int i : arr) {
                bw.write(i + " ");
            }
            bw.write("\n");
        }
        
        // 2. 스트라센 시도해보기
        // 3. 개선된 스트라센 시도해보기

        bw.flush();
        bw.close();
        br.close();
    }
}
