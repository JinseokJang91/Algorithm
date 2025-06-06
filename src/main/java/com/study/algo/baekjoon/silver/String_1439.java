package com.study.algo.baekjoon.silver;

import java.io.*;

public class String_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 0과 1로 이루어진 문자열 S에 있는 모든 숫자를 전부 같게 만들기
        // 1. 1을 뒤집기
        // 2. 0을 뒤집기

        String input = br.readLine();
        String[] inputs = input.split("");

        boolean isOne = false;
        boolean isZero = false;
        int oneOccurCount = 0;
        int zeroOccurCount = 0;

        for(int i = 0; i < inputs.length; i++) {
            if("1".equals(inputs[i])) {
                if(!isOne) {
                    oneOccurCount++;
                    isOne = true;
                    isZero = false;
                }
            } else if("0".equals(inputs[i])) {
                if(!isZero) {
                    zeroOccurCount++;
                    isZero = true;
                    isOne = false;
                }
            }
        }

        int result = Math.min(oneOccurCount, zeroOccurCount);

        bw.write("" + result);

        bw.flush();
        bw.close();
        br.close();
    }
}
