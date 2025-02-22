package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.*;

public class List_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // N : 연산의 개수
        // x가 자연수 : 배열에 x값 추가
        // x가 0 : 배열에서 가장 큰 값 출력
        // 배열이 비어있는 경우 : 0 출력

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x > 0) {
                queue.offer(x);
            } else {
                if(queue.isEmpty()) {
                    result.append(0).append("\n");
                } else {
                    result.append(queue.poll()).append("\n");
                }
            }
        }

        bw.write(result.toString());

        br.close();
        bw.close();
    }
}
