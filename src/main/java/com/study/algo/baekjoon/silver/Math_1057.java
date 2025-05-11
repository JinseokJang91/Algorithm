package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Math_1057 {
    private static int N;
    private static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // [토너먼트]
        // 1. N명의 참가자는 1번부터 N번까지 배정받는다.
        // 2. 참가자가 홀수명이면, 마지막 번호 참가자는 다음 라운드로 자동 진출한다.
        // 3. 다음 라운드에서는 다시 참가자의 번호를 1번부터 매긴다. 단, 매기는 순서는 처음 번호 순서를 유지한다.

        // 입력값
        // 1. N : 참가자의 수
        // 2. jimin : 김지민의 번호
        // 3. hansoo : 임한수의 번호

        // 김지민과 임한수가 대결하게 되는 라운드 출력
        // 서로 만날 때까지 경기는 계속 이긴다고 가정
        // 서로 대결할 수 없으면 -1 출력

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansoo = Integer.parseInt(st.nextToken());

        // 다음 라운드 번호
        // : 홀수면, x / 2 + 1
        // : 짝수면, x / 2
        // 두 사람의 번호 차가 1이고, 더 큰 수가 짝수면 대결 라운드

        calculateRound(jimin, hansoo, 1);

        bw.write("" + result);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void calculateRound(int jimin, int hansoo, int round) {
        if(round > N) {
            result = -1;
            return;
        }

        if(Math.abs(jimin - hansoo) == 1 && Math.max(jimin, hansoo) % 2 == 0) {
            result = round;
        } else {
            jimin = jimin % 2 == 0 ? jimin / 2 : jimin / 2 + 1;
            hansoo = hansoo % 2 == 0 ? hansoo / 2 : hansoo / 2 + 1;

            calculateRound(jimin, hansoo, round + 1);
        }
    }
}
