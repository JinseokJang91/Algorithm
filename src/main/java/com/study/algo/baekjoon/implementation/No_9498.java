package com.study.algo.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testScore = Integer.parseInt(br.readLine());

        if(testScore >= 90 && testScore <= 100) {
            System.out.println("A");
        } else if(testScore >= 80 && testScore < 90) {
            System.out.println("B");
        } else if(testScore >= 70 && testScore < 80) {
            System.out.println("C");
        } else if(testScore >= 60 && testScore < 70) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
