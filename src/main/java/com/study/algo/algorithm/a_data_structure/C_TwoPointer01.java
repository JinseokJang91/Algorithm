package com.study.algo.algorithm.a_data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C_TwoPointer01 {
    public static void main(String[] args) throws Exception {
        // 투포인터

        // 백준 2018번 연속된 자연수의 합 구하기
        // N의 최댓값은 10,000,000으로 매우 큰 편 => O(n) 시간복잡도 사용 필요 => 투 포인터

        // 1. 슈도코드 작성
        // N 변수 저장
        // 사용 변수 초기화(count=1, start_index=1, end_index=1, sum=1)
        // while(end_index != N)
        // {
        //   if(sum == N) count 증가, end_index 증가, sum값 변경(sum = N)
        //   else if(sum > N) sum값 변경(sum = sum + end_index), start_index 증가
        //   else if(sum < N) sum값 변경(sum = sum - start_index), end_index 증가
        // }

        // 2. 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while(end_index != N) {
            if(sum == N) {
                count++;
                end_index++; // end_index 오른쪽으로 이동
                sum += end_index;
            } else if(sum > N) {
                sum -= start_index;
                start_index++; // start_index 오른쪽으로 이동
            } else {
                end_index++;
                sum += end_index;
            }
        }

        bw.write("" + count);

        br.close();
        bw.close();
    }
}
