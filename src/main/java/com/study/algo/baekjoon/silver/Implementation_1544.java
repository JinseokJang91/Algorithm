package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Implementation_1544 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사이클 단어 : 단어를 원형 모양으로 쓴 것
        // e.g. picture = turepic 동일 단어

        // N개의 단어가 주어질 때, 서로 다른 단어가 몇 개 있는지 구하기
        // 예제 1. picture, word 2개
        // 예제 2. ast, ats, ttt

        // 사이클 단어이므로 동일 단어 반복 시 비교대상은 반드시 포함됨
        // e.g. picturepicture => pic + turepic + ture

        int N = Integer.parseInt(br.readLine());
        String[] cycleWords = new String[N];
        Map<Integer, Integer> mapping = new HashMap<>();

        for(int i = 0; i < N; i++) {
            cycleWords[i] = br.readLine();
            mapping.put(i + 1, 0);
        }

        for(int i = 0; i < N; i++) {
            String cycleWord = cycleWords[i] + cycleWords[i];

            for(int j = 0; j < N; j++) {
                // 자기 자신과 비교는 pass
                if(i != j) {
                    int length = cycleWords[j].length();

                    // 문자 길이가 같은 경우에만 비교
                    if(cycleWords[i].length() == length) {
                        if(cycleWord.contains(cycleWords[j])) {
                            // 배열 j번째 단어가 i번째 단어와 같다면 j번째 단어 초기화 처리
                            cycleWords[j] = "";
                        }
                    }
                }
            }
        }

        int result = (int) Arrays.stream(cycleWords).filter(s -> !s.isEmpty()).count();

        bw.write("" + result);

        bw.flush();
        bw.close();
        br.close();
    }
}
