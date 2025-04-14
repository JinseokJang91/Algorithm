package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Math_3135 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // A => B 로 갈 때 눌러야 하는 버튼 수의 최소값
        // N 개의 즐겨찾기 기능 (지정된 주파수로 이동)

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        int[] favorite = new int[N];

        for(int i = 0; i < N; i++) {
            favorite[i] = Integer.parseInt(br.readLine());
        }

        int minCnt = Math.abs(A - B);
        for(int i = 0; i < N; i++) {
            minCnt = Math.min(minCnt, Math.abs(B - favorite[i]) + 1);
        }

        bw.write("" + minCnt);
        bw.flush();
        bw.close();
        br.close();
    }
}
