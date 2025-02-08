package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ques_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if(arr.length != N) return;

        int v = Integer.parseInt(br.readLine());

        int count = (int) Arrays.stream(arr).filter(s -> s == v).count();
        System.out.println(count);

        br.close();
    }
}
