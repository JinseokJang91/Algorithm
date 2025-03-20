package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.*;

public class BackTracking_10819 {
    static int[] sortedA;
    static List<Integer> A;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N개의 정수로 이루어진 배열 A (3 <= N <= 8)
        // 배열에 들어있는 정수의 순서를 적절히 바꿔서 공식의 최댓값을 만들자
        // |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]| (절대값)

        // 예시 : 20 1 15 8 4 10 => 8 20 4 15 1 10 = 12 + 16 + 11 + 14 + 9 = 62

        // 내림차순 정렬 후, 반 잘라서 작은 값부터 먼저 번갈아가면서 위치
        // 20 15 10  8  4  1
        //  8  4  1
        // 20 15 10

        int N = Integer.parseInt(br.readLine());
        A = new ArrayList<>();
        sortedA = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(A, Comparator.reverseOrder());

        int half = N % 2 == 0 ? N / 2 : N / 2 - 1;
        int idx = 0;
        for(int i = 0; i < N; i++) {
            if(i % 2 == 0) {
                sortedA[i] = A.get(half);
                half++;
            } else {
                sortedA[i] = A.get(idx);
                idx++;
            }
        }

        for(int i = 1; i < N; i++) {
            result += Math.abs(sortedA[i-1] - sortedA[i]);
        }

        bw.write("" + result);

        br.close();
        bw.close();
    }
}
