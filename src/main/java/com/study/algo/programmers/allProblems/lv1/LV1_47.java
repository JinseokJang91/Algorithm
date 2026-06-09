package com.study.algo.programmers.allProblems.lv1;

import java.io.*;
import java.util.StringTokenizer;

public class LV1_47 {
    public static void main(String[] args) throws IOException {
        // 백준 2750번 수 정렬하기 1
        // 버블 정렬: 인접한 두 수끼리 비교, 끝자리부터 정렬이 완료됨

        // 1. 슈도코드 작성
        // 수의 개수 N 입력 받기
        // N개의 줄에서 입력받고 int 배열 numbers[]에 삽입하기
        // 정렬 완료여부 판단할 int 변수 count 선언
        // for(0 ~ N-1 반복)
        // {
        //   if(count가 0) { 정렬 완료이므로 break }
        //   for(0 ~ N - 1 - i 반복) // 끝자리부터 정렬이 완료되므로
        //   { i와 i+1 값 비교하고 i가 더 크면 자리 교체 }
        // }

        // 2. 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i = 0 ; i < N - 1; i++) {
            // 두 번째 정렬부터 바뀐 값이 없으면 정렬이 완료된 것이므로 반복문 탈출
            if(i > 0 && count == 0) {
                break;
            } else {
                count = 0;
            }
            for(int j = 0; j < N - 1 - i; j++) {
                if(numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    count++;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            sb.append(numbers[i]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
