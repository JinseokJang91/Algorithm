package com.study.algo.baekjoon.allProblems_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int N = Integer.parseInt(input);
        int result = 1;

        if(N > 0) {
            for(int i = 1; i<= N; i++) {
                result *= i;
            }
        }

        System.out.println(result);
    }
}
