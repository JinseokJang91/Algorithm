package com.study.algo.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ques_8958 {
    public static void main(String[] args) throws IOException {
        // OX퀴즈 결과
        // O가 연속이면 1점씩 상승

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[][] testCaseArr = new String[T][];

        for(int i = 0; i < T; i ++) {
            String[] testCase = br.readLine().split("");
            testCaseArr[i] = testCase;
        }

        List<Integer> result = new ArrayList<>();
        for(String[] testCase : testCaseArr) {
            int score = 0;
            int add = 0;
            for(String s : testCase) {
                if("O".equals(s)) {
                    score += ++add;
                } else if("X".equals(s)) {
                    add = 0;
                }
            }
            result.add(score);
        }

        for(int i : result) {
            System.out.println(i);
        }

        br.close();
    }
}
