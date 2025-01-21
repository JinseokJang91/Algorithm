package com.study.algo.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ques_10102 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split("");

        int votesA = (int) Arrays.stream(inputs).filter("A"::equals).count();
        int votesB = (int) Arrays.stream(inputs).filter("B"::equals).count();

        String result = votesA > votesB ? "A" : votesA < votesB ? "B" : "Tie";

        System.out.println(result);

        br.close();
    }
}
