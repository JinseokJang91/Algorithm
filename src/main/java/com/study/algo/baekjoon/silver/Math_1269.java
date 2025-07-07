package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Math_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 대칭 차집합 : 두 집합 A, B가 있을 때 (A-B)와 (B-A)의 합집합
        // A = {1,2,4}, B = {2,3,4,5,6} 이면
        // A-B = {1}, B-A = {3,5,6}
        // 대칭 차집합 원소의 개수는 1 + 3 = 4개

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size_A = Integer.parseInt(st.nextToken());
        int size_B = Integer.parseInt(st.nextToken());

        Integer[] A = new Integer[size_A]; // 집합 A
        Integer[] B = new Integer[size_B]; // 집합 B

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < size_A; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < size_B; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 집합 A, B 내림차순 정렬
        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B, Collections.reverseOrder());

        // 집합 A, B 원소 중 최대값 추출
        int maxElement = Math.max(A[0], B[0]);

        // boolean index 배열 사용
        boolean[] elementsForA = new boolean[maxElement + 1];
        boolean[] elementsForB = new boolean[maxElement + 1];

        for(int i = 0; i < size_A; i++) {
            elementsForA[A[i]] = true;
        }
        for(int i = 0; i < size_B; i++) {
            elementsForB[B[i]] = true;
        }

        // 1. A - B
        int AminusB = 0;
        for(int i = 0; i < size_B; i++) {
            if(!elementsForA[B[i]]) {
                AminusB++;
            }
        }

        // 2. B - A
        int BminusA = 0;
        for(int i = 0; i < size_A; i++) {
            if(!elementsForB[A[i]]) {
                BminusA++;
            }
        }

        bw.write("" + (AminusB + BminusA));
        bw.flush();
        bw.close();
        br.close();
    }
}
