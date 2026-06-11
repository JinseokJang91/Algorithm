package com.study.algo.algorithm.a_data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A_Array01 {
    public static void main(String[] args) throws Exception {
        // 백준 11720번 숫자의 합 구하기

        // 1. 슈도코드 작성
        // ------------------------------------------------------------
        // n값 입력받기
        // 길이 n의 숫자를 입력받아 String 변수 sNum에 저장하기
        // sNum을 char[] 변수 cNum에 변환하여 저장하기 (toCharArray 사용)
        // int형 변수 sum 선언하기
        // for(cNum 길이만큼 반복)
        // {
        //     배열의 각 자릿값을 정수형으로 변환하며 sum에 누적으로 더하기
        // }
        // sum 출력하기
        // ------------------------------------------------------------

        // 2. 구현
        // ------------------------------------------------------------
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String sNum = br.readLine();

        if(sNum.length() != n) {
            return;
        }

        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(char c : cNum) {
            sum += (c - 48); // '1' 아스키코드 10진수 값은 49
        }

        bw.write("" + sum);

        br.close();
        bw.close();
        // ------------------------------------------------------------
    }
}
