package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.*;

public class Greedy_9440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // 작은 수를 만드려면 정렬 후 숫자 조합 진행

        // 1. 0 미포함 시
        // 홀짝 인덱스 별로 숫자 분리
        // 1 2 3 4 5 => 135, 24
        // 1 2 2 3 3 4 => 123, 234

        // 2. 0 포함 시
        // 0이 맨앞에 올 수 없으므로, 0을 대신할 숫자 2개를 앞으로 당겨야 함.
        // 0 0 1 2 3 => 1 2 0 0 3 => 103, 20
        // 0 0 0 2 3 3 => 2 3 0 0 0 3 => 200, 303

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int zeroCount = 0;

            int N = Integer.parseInt(st.nextToken());

            if(N == 0) {
                break;
            }

            List<Integer> sortList = new ArrayList<>();
            List<Integer> newList = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());

                if(num == 0) {
                    zeroCount++;
                }

                sortList.add(num);
            }

            Collections.sort(sortList);

            if(zeroCount > 0) {
                int num1 = sortList.get(zeroCount);
                int num2 = sortList.get(zeroCount + 1);

                sortList.remove(zeroCount);
                sortList.remove(zeroCount); // 위에서 한 번 삭제했기 때문에 index + 1 할 필요 없음

                newList.add(num1);
                newList.add(num2);
            }

            newList.addAll(sortList);

            StringBuilder number1 = new StringBuilder();
            StringBuilder number2 = new StringBuilder();
            for(int i = 0; i < newList.size(); i++) {
                if(i % 2 == 0) {
                    number1.append(newList.get(i));
                } else {
                    number2.append(newList.get(i));
                }
            }

            result.append(Integer.parseInt(number1.toString()) + Integer.parseInt(number2.toString())).append("\n");
        }

        bw.write(result.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
