package com.study.algo.baekjoon.silver;

import java.io.*;

public class DynamicProgramming_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        // 테스트 케이스 개수 T
        // 정수 n을 1,2,3의 합으로 나타내는 방법의 수 출력 (n은 양수이며 11보다 작음)
        // 4
        // 1+1+1+1 / 1+1+2 / 1+2+1 / 2+1+1 / 2+2 / 1+3 / 3+1

        // 1, 2, 3, 4, 5, 6 각각 방법의 수는 1, 2, 4, 7, 13, 24
        // 점화식 : n의 방법의 수 = n-3, n-2, n-1 방법의 수의 합

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] cases = new int[11];

            cases[1] = 1;
            cases[2] = 2;
            cases[3] = 4;

            for(int j = 4; j <= n; j++) {
                cases[j] = cases[j-3] + cases[j-2] + cases[j-1];
            }

            result.append(cases[n]).append("\n");
        }

        bw.write(result.toString());

        br.close();
        bw.close();
    }
}
