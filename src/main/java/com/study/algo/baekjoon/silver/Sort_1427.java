package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Sort_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // 수의 각 자리수를 내림차순으로 정렬하기
        // e.g. 2143 => 4321

        String[] input = br.readLine().split("");
        Integer[] arr = new Integer[input.length];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(int i : arr) {
            result.append(i);
        }

        bw.write(result.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
