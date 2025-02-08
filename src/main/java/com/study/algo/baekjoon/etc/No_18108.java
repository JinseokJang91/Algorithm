package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_18108 {
    public static void main(String[] args) throws IOException {
        // 불기연도 : 2564
        // 서기연도 : 2025

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int buddhistYear = Integer.parseInt(input);

        System.out.println(buddhistYear - 543);
    }
}
