package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Ques_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 1. 중복된 단어는 제거하고 하나만 남기기
        //Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Set<String> wordSet = new HashSet<>();
        for(String word : words) {
            wordSet.add(word);
        }

        words = wordSet.toArray(String[]::new);

        // 2. 길이가 짧은 것부터 정렬
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        // 3. 길이가 같으면 사전순
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return 0;
                }
            }
        });

        for(String s : words) {
            System.out.println(s);
        }

        br.close();
    }
}
