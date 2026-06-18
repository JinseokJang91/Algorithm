package com.study.algo.algorithm.c_greedy;

import java.io.*;

public class B_Greedy {
    public static void main(String[] args) throws IOException {
        // 백준 1541번 최솟값을 만드는 괄호 배치 찾기
        // 마이너스 값을 크게 하면 최솟값
        // 100-40+50+74-30 이면 100-(40+50+74)-30이 최솟값
        //  => 100-(40+50+74)-30 == 100-40-50-74-30
        //  => +를 -로 그냥 바꾸면 됨

        // 1. 슈도코드 작성
        // String으로 수식 input 입력 받기
        // - 기준으로 나누기
        // - 기준으로 나눈 input 부분 배열들을 + 기준으로 나눠서 계산
        // 최초값 - 나머지 값의 합 계산

        // 2. 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine(); // 100-40+50+74-30+29-45+43+11
        String[] inputSplitArray = input.split("-"); // {100}, {40+50+74}, {30+29}, {45+43+11}

        int min = 0;
        for(int i = 0; i < inputSplitArray.length; i++) {
            if(i == 0) {
                min += calculate(inputSplitArray[i]);
            } else {
                min -= calculate(inputSplitArray[i]);
            }
        }

        bw.write("" + min);

        br.close();
        bw.close();
    }

    private static int calculate(String inputSplit) {
        int result = 0;
        String[] inputDoubleSplitArray = inputSplit.split("\\+");
        // 정규식에서 사용되는 특수문자(메타문자) 앞에는 `\\` 붙이기 또는 대괄호 사용 [+]

        for(String number: inputDoubleSplitArray) {
            result += Integer.parseInt(number);
        }

        return result;
    }
}
