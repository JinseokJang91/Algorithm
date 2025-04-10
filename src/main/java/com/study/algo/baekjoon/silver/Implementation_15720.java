package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.*;

public class Implementation_15720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int B = Integer.parseInt(st.nextToken()); // 버거 개수
        int C = Integer.parseInt(st.nextToken()); // 사이드 개수
        int D = Integer.parseInt(st.nextToken()); // 음료 개수

        int minCombination = Math.min(Math.min(B, C), D);

        List<Integer> burgers = new ArrayList<>();
        List<Integer> sides = new ArrayList<>();
        List<Integer> drinks = new ArrayList<>();

        int totalAmount = 0;
        int discountedAmount = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < B; i++) {
            int burger = Integer.parseInt(st.nextToken());
            burgers.add(burger);
            totalAmount += burger;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < C; i++) {
            int side = Integer.parseInt(st.nextToken());
            sides.add(side);
            totalAmount += side;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < D; i++) {
            int drink = Integer.parseInt(st.nextToken());
            drinks.add(drink);
            totalAmount += drink;
        }

        Collections.sort(burgers, Comparator.reverseOrder());
        Collections.sort(sides, Comparator.reverseOrder());
        Collections.sort(drinks, Comparator.reverseOrder());

        for(int i = 0; i < minCombination; i++) {
            discountedAmount += (burgers.get(i) + sides.get(i) + drinks.get(i)) / 10;
        }

        result.append(totalAmount).append("\n").append(totalAmount - discountedAmount);

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
