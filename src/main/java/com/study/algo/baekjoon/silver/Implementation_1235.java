package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Implementation_1235 {
    private static int N;
    private static String[] studentNumbers;
    private static int length;
    private static final Set<Integer> set = new HashSet<>();
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N : 학생의 수
        // N 개의 학생 번호 (길이는 동일)
        // 뒷자리 특정 개수만 남겨 놓았을 때 모든 학생들의 번호를 서로 다르게 만들 수 있는 최소 k 구하기

        N = Integer.parseInt(br.readLine());
        studentNumbers = new String[N];

        for(int i = 0; i < N; i++) {
            String number = br.readLine();
            studentNumbers[i] = number;

            if(i == 0) {
                length = number.length();
            }
        }

        getMinimumDigit(length - 1);
        bw.write("" + result);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void getMinimumDigit(int beginIndex) {
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(studentNumbers[i].substring(beginIndex, length));

            set.add(input);
        }

        if(set.size() == N) {
            result = length - beginIndex;
        } else {
            set.clear();
            getMinimumDigit(beginIndex - 1);
        }
    }
}
