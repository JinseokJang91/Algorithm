package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ques_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];

        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int index = 0;
        for(int i = 0; i < 9; i++) {
            if(arr[i] == max) {
                index = i + 1;
                break;
            }
        }

        System.out.println(max + "\n" + index);

        br.close();
    }
}
