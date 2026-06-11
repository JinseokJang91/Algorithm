package com.study.algo.algorithm.a_data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class E_Stack {
    public static void main(String[] args) throws Exception {
        // 스택과 큐
        // 스택: 후입선출(LIFO)
        // 큐: 선입선출(FIFO)

        // 스택(Stack) 문제

        // 백준 1874번 스택으로 오름차순 수열 만들기
        // 후입선출이므로 1부터 증가시키면서 스택에 add
        // 입력값과 같으면 pop
        // +, - 과정을 반복하면서 본 수열이 오름차순으로 이루어질 수 있는지 판단

        // 1. 슈도코드 작성
        // N(수열 개수) 입력 받기
        // N 크기의 수열 배열 A[] 선언하기
        // 수열 배열 채우기(입력 받아서)
        // for(N만큼 반복)
        // {
        //   if(현재 수열값 >= 오름차순 자연수) {
        //      while(값이 같아질 때까지) {
        //        push()
        //        + 저장
        //      }
        //    else if(현재 수열값 < 오름차순 자연수) {
        //       pop()
        //       if(스택 pop 결과값 > 수열의 수) NO 출력하고 종료
        //       else (-) 저장
        //   }
        // }
        // 저장한 값 출력

        // 2. 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for(int i = 0; i < N; i++) {
            if(A[i] >= num) {
                while(A[i] >= num) {
                    stack.push(num++);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            } else {
                int popNum = stack.pop();
                if(popNum > A[i]) {
                    sb = new StringBuilder("NO");
                    break;
                } else {
                    sb.append("-").append("\n");
                }
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
