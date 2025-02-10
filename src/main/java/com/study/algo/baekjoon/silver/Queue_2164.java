package com.study.algo.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_2164 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // N장의 카드 : 1 ~ N 번호, 1번 카드가 제일 위에 위치
        // 1. 제일 위에 있는 카드를 바닥에 버린다.
        // 2. 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
        // 제일 마지막에 남게 되는 카드?

        // 결과 1 : 164ms
//        Queue<Integer> queue = new LinkedList<>();
//
//        for(int i = 1; i <= N; i++) {
//            queue.offer(i);
//        }
//
//        while(queue.size() > 1) {
//            queue.remove();
//
//            if(queue.size() == 1) {
//                break;
//            } else {
//                queue.offer(queue.poll());
//                System.out.println(queue);
//            }
//        }
//
//        System.out.println(queue.peek());

        // 결과 2 : 228ms
        otherSolution();

        // 결과 3 : 156ms
        anotherSolution();

        br.close();
    }

    public static void otherSolution() {
        // cf. 손으로 직접 해보니 1,3,5,7,... 순으로 홀수 먼저 없어짐 (최종적으로는 짝수만 살아남음)
        // 단, N이 홀수면 제일 앞에 N이 들어감
        Queue<Integer> queue = new LinkedList<>();

        if(N % 2 == 1) {
            queue.offer(N);
        }

        for(int i = 1; i <= N; i++) {
            if(i % 2 == 0) {
                queue.offer(i);
            }
        }

        while(queue.size() > 1) {
            queue.remove();

            if(queue.size() == 1) {
                break;
            } else {
                queue.offer(queue.poll());
            }
        }

        System.out.println(queue.peek());
    }

    public static void anotherSolution() {
        Queue<Integer> queue = new LinkedList<>();

        if(N % 2 == 1) {
            queue.offer(N);
        }

        // otherSolution 조건문 삭제 후 짝수만 넣기
        if(N > 1) {
            for(int i = 2; i <= N; i+=2) {
                queue.offer(i);
            }

            while(queue.size() > 1) {
                queue.remove();

                if(queue.size() == 1) {
                    break;
                } else {
                    queue.offer(queue.poll());
                }
            }
        }

        System.out.println(queue.peek());
    }

    // 다른 사람 해결법 보니 비트연산자 사용
    // 참고 : https://www.acmicpc.net/source/73068956
}
