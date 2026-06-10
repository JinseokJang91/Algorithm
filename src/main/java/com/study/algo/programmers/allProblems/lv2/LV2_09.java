package com.study.algo.programmers.allProblems.lv2;

import java.io.*;
import java.util.StringTokenizer;

public class LV2_09 {
    public static void main(String[] args) throws IOException {
        // 백준 1427번 내림차순으로 자릿수 정렬하기
        // 선택 정렬
        // 최솟값(오름차순) 또는 최댓값(내림차순)을 찾아 기준이 되는 자리와 스왑

        // 1. 슈도코드 작성
        // 정렬할 수 N String으로 입력 받기(N은 1,000,000,000보다 작거나 같은 자연수)
        // int형 배열 numbers[]에 값 삽입(StringTokenizer 사용)
        // for(0 ~ numbers 길이 - 1)
        // {
        //    int maxIndex 초기값 i로 세팅(최대값 인덱스)
        //    for(i+1 ~ numbers 길이 -1)
        //     {
        //        numbers[maxIndex]와 numbers[j]를 비교해 최댓값 인덱스 세팅
        //     }
        //     최댓값인덱스 찾은 뒤 i 인덱스 값과 비교해서 max가 더 크면 교체(temp 사용)
        // }

        // 2. 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        int[] numbers = new int[N.length()];

        for(int i = 0; i < N.length(); i++) {
            numbers[i] = Integer.parseInt(String.valueOf(N.charAt(i)));
        }

        // 선택 정렬
        for(int i = 0; i < numbers.length; i++) {
            int maxIndex = i;
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[maxIndex] < numbers[j]) {
                    maxIndex = j;
                }
            }
            if(numbers[maxIndex] > numbers[i]) {
                int temp = numbers[i];
                numbers[i] = numbers[maxIndex];
                numbers[maxIndex] = temp;
            }
        }

        for(int num : numbers) {
            sb.append(num);
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
