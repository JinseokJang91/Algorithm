package com.study.algo.algorithm.a_data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_PrefixSum {
    public static void main(String[] args) throws Exception {
        // 백준 11659번 구간 합 구하기

        // 1. 공식
        // 수를 입력받음과 동시에 더해서 합 배열 생성
        // => 매번 구간 합 계산 시 시간 초과 발생할 수 있음
        // => 입력 : 5 4 3 2 1 => 합배열: 0 5 9 12 14 15
        // 구간 1 ~ 3 합은 12 --> 배열[3] - 배열[0] --> 12 - 0
        // 구간 2 ~ 4 합은 9 --> 배열[4] - 배열[1] --> 14 - 5
        // 구간 5 ~ 5 합은 1 --> 배열[5] - 배열[4] --> 15 - 14
        // 공식: 배열[j] - 배열[i-1] (합배열의 0 인덱스에는 0을 넣을 것!)

        // 2. 슈도코드 작성
        // 수의 개수 N, 합 계산 횟수 M을 입력 받기
        // 크기가 N+1 인 배열 nArr 생성하기 (0 인덱스 값은 0이므로)
        // for(개수 N만큼 반복)
        // { 합 계산해서 배열 삽입 }
        // for(횟수 M만큼 반복)
        // { 구간 i, j 입력 받고 합 공식 적용해서 계산, 결과는 M 배열에 삽입 }
        // M 배열 출력하기

        // 3. 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] nArr = new int[N + 1];

        for(int k = 1; k <= N; k++) {
            nArr[k] += Integer.parseInt(st.nextToken()) + nArr[k-1];
        }

        for(int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(nArr[j] - nArr[i - 1]).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
