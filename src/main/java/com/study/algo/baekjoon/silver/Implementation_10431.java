package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.*;

public class Implementation_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // 키 순서대로 줄 세우기
        // 문제 조건
        // 1. 자기 앞에 자기보다 키가 큰 학생이 없다면 그냥 그 자리에 서고 차례가 끝난다.
        // 2. 자기 앞에 자기보다 키가 큰 학생이 한 명 이상 있다면 그중 가장 앞에 있는 학생(A)의 바로 앞에 선다.
        //    이때, A부터 그 뒤의 모든 학생들은 공간을 만들기 위해 한 발씩 뒤로 물러서게 된다.

        // 정렬 후 정렬된 배열과 기존 배열 비교
        // e.g. 4명이 순서대로 줄을 선다고 가정
        // X = 902 901 903 900
        // Y = 900 901 902 903 - 정렬된 버전
        // 900을 배열에서 찾으면 index=3에 위치, 맨 앞으로 이동, 나머지 학생들은 한 발씩 뒤로 물러서므로 총 3걸음 이동
        // X의 index 3, Y의 index 0 => 3 - 0 = 3걸음 이동

        // X` = 900 902 901 903 - 900이 맨앞으로 이동
        // Y = 900 901 902 903
        // 901을 배열에서 찾으면 index=2에 위치, 902 앞으로 이동, 902만 한 발 뒤로 물러서므로 총 1걸음 이동
        // X의 index 2, Y의 index 1 => 2 - 1 = 1걸음 이동

        // 기존 문제 조건대로 902부터 나열해도 총 걸음 수는 동일함.

        int P = Integer.parseInt(br.readLine());

        for(int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int moves = 0;

            int caseNum = Integer.parseInt(st.nextToken());
            List<Integer> orders = new LinkedList<>();
            List<Integer> sorted = new ArrayList<>();
            for(int j = 0; j < 20; j++) {
                int height = Integer.parseInt(st.nextToken());
                orders.add(height);
                sorted.add(height);
            }

            Collections.sort(sorted);

            for(int j = 0; j < 20; j++) {
                int ordersIndex = orders.indexOf(sorted.get(j));

                if(ordersIndex > j) {
                    moves += ordersIndex - j;
                    orders.remove(ordersIndex);
                    orders.add(j, sorted.get(j));
                }
            }

            result.append(caseNum).append(" ").append(moves).append("\n");
        }

        bw.write(result.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
