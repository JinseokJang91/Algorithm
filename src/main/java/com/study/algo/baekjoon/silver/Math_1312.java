package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Math_1312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // A / B 결과, 소수점 아래 N번째 수 출력하기
        // e.g. 25 / 7 = 3.5714285714285716


        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int answer = A % B;
        for(int i = 0; i < N - 1; i++) {
            answer *= 10;
            answer %= B;
        }

        answer *= 10;
        answer /= B;

        bw.write("" + answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
