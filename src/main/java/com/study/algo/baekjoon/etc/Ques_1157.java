package com.study.algo.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ques_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().toUpperCase(); // 다 대문자로 치환

        char[] inputs = input.toCharArray();

        // 알파벳 총 26개
        // A ~ Z : 65 ~ 90
        int[] alphabets = new int[26];

        for(char c : inputs) {
            alphabets[c - 65] += 1;
        }

        int max = 0;
        int maxIdx = -1;
        for(int i = 0; i < alphabets.length; i++) {
            if(alphabets[i] > max) {
                max = alphabets[i];
                maxIdx = i;
            } else if(alphabets[i] == max) {
                maxIdx = -1; // break 걸지말고 끝까지 다 검사해야 함 (초반에 같은개 여러개 나오다 뒤에 큰 숫자가 나올 수 있음)
            }
        }

        System.out.println(maxIdx < 0 ? "?" : (char)(maxIdx + 65));

        br.close();
    }
}
