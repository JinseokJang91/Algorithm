package com.study.algo.baekjoon.silver;

import java.io.*;

public class Math_1094 {
    static int X;
    static int count;
    static int stick;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 64cm 막대 => Xcm 막대
        // 1. 막대의 길이를 모두 더한다. 합이 X보다 크면 아래 과정 반복한다.
        //   1. 가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
        //   2. 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버린다.
        // 2. 남아있는 모든 막대를 풀로 붙여서 Xcm를 만든다.

        X = Integer.parseInt(br.readLine());

        stick = 64;

        while(X > 0) {
            if(stick > X) {
                // 막대가 X보다 크면 절반으로 자르기
                stick /= 2;
            } else {
                // 막대가 X보다 작거나 같으면 X를 막대 길이로 나눈 몫만큼 count 더하기
                count += X / stick;
                // count 구한 후 막대 길이만큼 X에서 뺀 후 다음 작업
                X -= stick;
            }
        }

        bw.write("" +count);

        br.close();
        bw.flush();
        bw.close();
    }
}
