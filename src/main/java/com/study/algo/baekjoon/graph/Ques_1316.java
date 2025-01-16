package com.study.algo.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ques_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int result = 0;

        for(char[] word : arr) {
            char c = 0;
            List<Character> list = new ArrayList<>();
            for(int j = 0; j < word.length; j++) {
                // 첫 index : list 추가
                if(j == 0) {
                    c = word[j];
                    list.add(c);
                // 그외 index
                } else {
                    // list 포함여부 "Y"인데, 연속되지 않는 케이스면 그룹단어가 아님
                    if(list.contains(word[j])) {
                        if(word[j] != word[j - 1]) {
                            list.clear();
                            break;
                        }
                    } else {
                        // 연속되지 않는 알파벳이면 list 추가
                        if(c != word[j]) {
                            list.add(word[j]);
                            c = word[j];
                        }
                    }
                }
            }

            if(!list.isEmpty()) {
                result++;
            }
        }

        System.out.println(result);

        br.close();
    }
}
