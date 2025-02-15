package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.Stack;

public class Stack_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        // K개의 정수가 주어짐
        // 1. 0이면 가장 최근에 쓴 수를 지운다. (0인 경우 지울 수 있는 수가 무조건 있음)
        // 2. 0이 아니면 해당 수를 사용
        // => 최종적으로 남아있는 수들의 합 구하기

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        bw.write("" + sum);

        br.close();
        bw.close();
    }
}
