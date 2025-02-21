package com.study.algo.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class String_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        // 서로 다른 부분 문자열의 개수 구하기
        // e.g. ababc
        // 모든 경우의 수 : a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc, abab, babc, ababc
        // 결과 : a, b, c, ab, ba, bc, aba, bab, abc, abab, babc, ababc

        // 연속된 일부분이므로,
        // 시작 인덱스와 자를 길이를 설정

        Set<String> set = new HashSet<>();

        int beginIndex = 0; // 시작 인덱스
        int cutLength = 1; // 자를 길이
        while(cutLength < input.length()) {
            if(beginIndex + cutLength > input.length()) {
                beginIndex = 0;
                cutLength++;
            }

            String str = input.substring(beginIndex, beginIndex + cutLength);
            set.add(str);

            beginIndex++;
        }

        System.out.println(set.size());

        br.close();
    }
}
