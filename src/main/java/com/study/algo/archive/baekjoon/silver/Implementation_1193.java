package com.study.algo.archive.baekjoon.silver;

import java.io.*;

public class Implementation_1193 {
    private static int N;
    private static int count;
    private static StringBuilder result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 분수 지그재그 순서
        // 1/1 에서 우측 한 칸 이동 (1/2)
        // 좌하향 대각선으로 계속 이동, 분모가 1인 2/1에서 STOP
        // 2/1 에서 아래 한 칸 이동 (3/1)
        // 우상향 대각선으로 계속 이동, 분자가 1인 1/3에서 STOP
        // 1/3 에서 우측 한 칸 이동 (1/4)
        // 좌하향 대각선으로 계속 이동, 분모가 1인 4/1에서 STOP
        // 4/1에서 아래 한 칸 이동 (5/1)
        // ...

        // 전체 순서
        // (1,1) > (1,2) > (2,1) > (3,1) > (2,2) > (1,3) > (1,4) > (2,3) > (3,2) > (4,1) > (5,1) > (4,2)
        // 분자가 1이면 y + 1 ... CASE 1
        // 이동 시 x + 1, y - 1 ... CASE 2
        // 분모가 1이 되면 x + 1 ... CASE 3
        // 이동 시 x - 1, y + 1 ... CASE 4

        // N번째 분수 구하기

        N = Integer.parseInt(br.readLine());

        result = new StringBuilder();
        count = 1;
        int x = 1;
        int y = 1;

        calculate(x, y, 1);

        bw.write(result.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static void calculate(int x, int y, int caseNum) {
        if(N == count) {
            result.append(x).append("/").append(y);
            return;
        }

        switch(caseNum) {
            // CASE 1. 분자가 1이 되는 경우
            case 1 :
                y += 1;
                count++;

                calculate(x, y, 2); // 우측 한 칸 이동 후 좌하향 이동
                break;
            // CASE 2. 좌하향 이동
            case 2 :
                x += 1;
                y -= 1;
                count++;

                if(y == 1) {
                    calculate(x, y, 3); // 분모가 1이 되면 아래 한 칸 이동
                } else {
                    calculate(x, y, 2); // 분모가 1이 아니면 계속 좌하향 이동
                }
                break;
            // CASE 3. 분모가 1이 되는 경우
            case 3 :
                x += 1;
                count++;

                calculate(x, y, 4); // 아래 한 칸 이동 후 우상향 이동
                break;
            // CASE 4. 우상향 이동
            case 4 :
                x -= 1;
                y += 1;
                count++;

                if(x == 1) {
                    calculate(x, y, 1); // 분자가 1이 되면 우측 한 칸 이동
                } else {
                    calculate(x, y, 4); // 분자가 1이 아니면 계속 우상향 이동
                }
                break;
        }
    }
}
