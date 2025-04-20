package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.*;

public class BackTracking_10819 {
    static int N;
    static int[] A;
    static int[] ans;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N개의 정수로 이루어진 배열 A (3 <= N <= 8)
        // 배열에 들어있는 정수의 순서를 적절히 바꿔서 공식의 최댓값을 만들자
        // 점화식 : |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]| (절대값)(총 N-1번 실행)

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        ans = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0); // recursive 메소드 사용

        bw.write("" + result);

        br.close();
        bw.close();
    }

    private static void backtracking(int depth) {
        if(depth == N) {
            // ans 배열 : A 배열의 모든 조합
//            for(int i : ans) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
            // ans를 다 채우면 점화식에 따른 계산 결과 도출
            int sum = 0;
            for(int i = 0; i < N - 1; i++) {
                sum += Math.abs(ans[i] - ans[i + 1]);
            }

            // 이전 결과와 비교하여 더 큰 경우 대체
            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                ans[depth] = A[i];
                visited[i] = true;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
