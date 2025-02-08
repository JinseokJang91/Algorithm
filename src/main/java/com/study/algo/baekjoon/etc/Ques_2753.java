package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ques_2753 {
    public static void main(String[] args) throws IOException {
        // 연도가 주어지고, 윤년여부 판단
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        int result = checkLeapYear(year);
        System.out.println(result);

        br.close();
    }

    private static int checkLeapYear(int year) {
        return year % 4 == 0 ? (year % 100 != 0 || year % 400 == 0 ? 1 : 0) : 0;
    }
}
