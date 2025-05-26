package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Graph_3182 {
    private static boolean[] visited;
    private static int[] numbers;
    private static int count;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 최대한 많은 선배들을 만나기 위해 물어보려면 몇 번째 선배에게 질문을 해야 되는가?

        N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i < N + 1; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int result = 0; // 만난 선배 수(count) 비교
        int answer = 0; // 정답이 되는 선배의 번호
        for(int i = 1; i < N + 1; i++) {
            count = 0;
            countSeniors(i);

            if(count > result) {
                result = count;
                answer = i;
            }
        }

        bw.write("" + answer);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void countSeniors(int n) {
        // n번째 선배가 가리키는 선배가 이미 만난 선배면 종료
        if(visited[numbers[n]]) {
            visited = new boolean[N + 1]; // 방문여부 초기화
            return;
        }

        visited[n] = true;
        count++;

        countSeniors(numbers[n]);
    }
}
