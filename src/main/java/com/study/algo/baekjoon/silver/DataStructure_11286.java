package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.PriorityQueue;

public class DataStructure_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>();
        StringBuilder answer = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        // N개의 정수 x
        // 1. x가 0이 아니라면 배열에 x라는 값을 넣는 연산
        // 2. x가 0이면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거
        // 3. 배열이 비어있는 경우인데 절댓값이 가장 작은 값을 출력해야 하면 0을 출력

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x != 0) {
                if(x > 0) {
                    plusQueue.add(x);
                } else {
                    minusQueue.add(Math.abs(x));
                }
            } else {
                if(plusQueue.isEmpty() && minusQueue.isEmpty()) {
                    answer.append(0).append("\n");
                } else if(plusQueue.isEmpty() && !minusQueue.isEmpty()){
                    answer.append(-minusQueue.poll()).append("\n");
                } else if(!plusQueue.isEmpty() && minusQueue.isEmpty()){
                    answer.append(plusQueue.poll()).append("\n");
                } else {
                    int minus = minusQueue.poll();
                    int plus = plusQueue.poll();

                    if(minus < plus) {
                        answer.append(-minus).append("\n");
                        plusQueue.offer(plus);
                    } else if(minus > plus) {
                        answer.append(plus).append("\n");
                        minusQueue.offer(minus);
                    } else {
                        answer.append(-minus).append("\n");
                        plusQueue.offer(plus);
                    }
                }
            }
        }

        bw.write(answer.toString());

        br.close();
        bw.close();
    }
}
