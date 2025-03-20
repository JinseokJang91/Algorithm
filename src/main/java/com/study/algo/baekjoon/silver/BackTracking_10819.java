package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.*;

public class BackTracking_10819 {
    static int N;
    static int[] sortedA;
    static boolean[] visited;
    static List<Integer> A;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N개의 정수로 이루어진 배열 A (3 <= N <= 8)
        // 배열에 들어있는 정수의 순서를 적절히 바꿔서 공식의 최댓값을 만들자
        // |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]| (절대값)(총 N-1번 실행)


        N = Integer.parseInt(br.readLine());
        A = new ArrayList<>();
        sortedA = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < N; i++) {
            visited[i] = true;
            backtracking(A.get(i), 0, 0);
            visited[i] = false;
        }

        bw.write("" + result);

        br.close();
        bw.close();
    }

    private static void backtracking(int oldNum, int sum, int count) {
        System.out.println("sum : " + sum);
        if(count == N - 1) {
            // count 값이 N-1과 동일해지면 최댓값 비교 후 리턴
            if(result < sum) {
                result = sum;
            }

            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;

                int newNum = A.get(i);
                sum += Math.abs(oldNum - newNum); // |A[N-2] - A[N-1]| 값 누적 합
                backtracking(newNum, sum, count + 1);
                sum -= Math.abs(oldNum - newNum);

                visited[i] = false;
            }
        }
    }
}
