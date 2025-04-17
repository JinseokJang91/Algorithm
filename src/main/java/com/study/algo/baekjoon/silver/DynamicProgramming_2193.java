package com.study.algo.baekjoon.silver;

import java.io.*;

public class DynamicProgramming_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 이친수 : 이진수 중 특별한 성질을 갖는 것
        // 1. 이친수는 0으로 시작하지 않는다.
        // 2. 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.

        // 손으로 직접 계산해보면
        // N = 1 > 1
        // N = 2 > 1
        // N = 3 > 2
        // N = 4 > 3
        // N = 5 > 5
        // N = 6 > 8

        // 점화식 - N자리 이친수 개수 = (N-2)자리 이친수 개수 + (N-1)자리 이친수 개수

        long[] arr = new long[N + 1];

        for(int i = 1; i < N + 1; i++) {
            if(i == 1 || i == 2) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 2] + arr[i - 1];
            }
            //System.out.println("arr[" + i + "] = " + arr[i]);
        }

        bw.write("" + arr[N]);

        bw.flush();
        bw.close();
        br.close();
    }
}
