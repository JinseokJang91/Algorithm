package com.study.algo.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_2480 {
    public static void main(String[] args) throws IOException {
        // 같은 눈(x) 3개 : 10,000원 + (x * 1,000원)
        // 같은 눈(x) 2개 : 1,000원 + (x * 100원)
        // 모두 다른 눈 : 가장 큰 눈 * 100원

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int[] inputs = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(inputs);

        int result = 0;

        if(inputs[2] == inputs[1]) {
            if(inputs[2] == inputs[0]) {
                result = 10000 + inputs[2] * 1000;
            } else {
                result = 1000 + inputs[2] * 100;
            }
        } else {
            if(inputs[1] == inputs[0]) {
                result = 1000 + inputs[1] * 100;
            } else {
                result = inputs[2] * 100;
            }
        }

        System.out.println(result);
    }
}
