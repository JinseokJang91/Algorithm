package com.study.algo.baekjoon.silver;

import java.io.*;

public class DynamicProgramming_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 2xn 직사각형을 1x2, 2x1, 2x2 타일로 채우는 방법의 수를 구하고, 10007로 나눈 나머지를 출력
        // 직접 그려보면,,
        // 2x1 : 1
        // 2x2 : 3
        // 2x3 : 5
        // 2x4 : 11
        // ...

        // 점화식 : n = (n-2) * 2 + (n-1)
        int[] arr = new int[n + 1];

        arr[0] = 1;
        arr[1] = 3;

        for(int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 2] * 2 + arr[i - 1]) % 10007;
        }

        bw.write("" + arr[n - 1]);

        br.close();
        bw.close();
    }
}
