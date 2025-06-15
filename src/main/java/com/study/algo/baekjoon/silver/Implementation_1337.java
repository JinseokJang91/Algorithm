package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Implementation_1337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 올바른 배열 : 배열 속 원소 중 5개가 연속적인 것(인접한 수의 차이가 1인 것)
        // 올바른 배열이 되게 하기 위해 추가되어야 할 원소의 개수 출력하기

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        List<Integer> results = new ArrayList<>();

        int count = 0; // 연속되는 숫자가 list 포함 시 카운트
        for(int i = 0; i < N; i++) {
            int num = list.get(i);
            count++; // 자기 자신 먼저 카운트

            // 오름차순 배열 했으므로 인덱스 값 별 연속되는 숫자도 오름차순이어야 함
            int num1 = num + 1;
            int num2 = num + 2;
            int num3 = num + 3;
            int num4 = num + 4;

            if(list.contains(num1)) {
                count++;
            }
            if(list.contains(num2)) {
                count++;
            }
            if(list.contains(num3)) {
                count++;
            }
            if(list.contains(num4)) {
                count++;
            }

            results.add(5 - count);

            count = 0;
        }

        Collections.sort(results);

        bw.write("" + results.get(0));

        bw.flush();
        bw.close();
        br.close();
    }
}
