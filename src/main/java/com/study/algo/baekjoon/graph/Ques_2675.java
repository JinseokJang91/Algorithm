package com.study.algo.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ques_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        String[][] testCaseArr = new String[T][2];
        for(int i = 0; i < T; i++) {
            String[] testCase = br.readLine().split(" ");
            testCaseArr[i] = testCase;
        }

        List<String> result = new ArrayList<>();

        for(String[] testCase : testCaseArr) {
            int R = Integer.parseInt(testCase[0]);
            String S = testCase[1];
            StringBuilder sb = new StringBuilder();

            for(String str : S.split("")) {
                sb.append(str.repeat(R));
            }

            result.add(sb.toString());
        }

        for(String s : result) {
            System.out.println(s);
        }

        br.close();
    }
}
