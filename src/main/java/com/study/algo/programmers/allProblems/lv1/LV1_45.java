package com.study.algo.programmers.allProblems.lv1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LV1_45 {
    public static void main(String[] args) throws Exception {
        // 백준 1546번 평균 구하기

        // 1. 공식
        // 평균 공식 : (A / M * 100 + B / M * 100 + C / M * 100) / 3 = (A + B + C) * 100 / 3

        // 2. 슈도코드 작성
        // 변수 n에 과목 수 입력 받기
        // 과목 점수 입력 받아서 String 배열 arr로 생성하기
        // 길이가 n인 1차원 배열 A[] 생성하기
        // for(배열 A 길이 반복)
        // { A[i]에 arr[i] 점수 저장하기 }
        // 최고점 변수 max, 평균 변수 sum 선언하기
        // for(배열 A 길이 반복)
        // { 최고점은 변수 max, 총점은 변수 sum에 저장하기 }

        // 공식 적용해서 최종 값 sum * 100 / max / N 출력하기

        // 3. 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for(int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int sum = 0;
        for(int i : A) {
            max = Math.max(max, i);
            sum += i;
        }

        bw.write("" + (sum * 100.0 / max / n));

        br.close();
        bw.close();
    }
}
