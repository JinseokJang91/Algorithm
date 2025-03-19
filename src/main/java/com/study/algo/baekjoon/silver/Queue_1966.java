package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 현재 큐의 가장 앞에 있는 문서의 중요도를 확인
        // 2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서 존재 여부
        // => 존재 시, 큐의 가장 뒤에 재배치
        // => 미존재 시, 해당 문서 인쇄

        // 문서의 수(N), 중요도가 주어질 때 특정 문서(M)가 몇 번째로 인쇄되는지 알아내기

        // T : 테스트케이스의 수
        // 첫 번째 줄 - N : 문서의 개수 / M : Target 문서의 현재 큐에서의 위치
        // 두 번째 줄 - N개 문서의 중요도

        // Target 문서의 현재 큐에서의 위치를 기억하고, 조건에 따라 해당 문서의 위치가 바뀌게 되면 그걸 기억해야 함

        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < T; i++) {
            Queue<Integer> queue = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken()); // target 문서의 index

            // 문서 개수(N)이 1이면, 무조건 첫 번째 인쇄
            if(N == 1) {
                String temp = br.readLine();
                result.append(1).append("\n");
            } else {
                // 차례대로 주어지는 N개 문서의 중요도
                StringTokenizer importance = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++) {
                    queue.offer(Integer.parseInt(importance.nextToken()));
                }

                int checkCount = 0;
                int printCount = 0;
                while(!queue.isEmpty()) {
                    // 1. 문서의 중요도 확인
                    // 2. 나머지 문서와 중요도 비교
                    //    CASE 1. 내가 찾는 문서 X & 중요도 높은거 존재 O : 큐 맨뒤로 재배치
                    //    CASE 2. 내가 찾는 문서 X & 중요도 높은거 존재 X : 인쇄 (인쇄카운트++)
                    //    CASE 3. 내가 찾는 문서 O & 중요도 높은거 존재 O : 큐 맨뒤로 재배치 (나머지 문서 개수만큼 ++, 순서가 뒤로 밀렸으므로 그만큼 더함)
                    //    CASE 4. 내가 찾는 문서 O & 중요도 높은거 존재 X : 인쇄 (인쇄카운트++) 및 종료
                    int importanceLevel = queue.poll();

                    if(checkCount == M) {
                        // CASE 3
                        if(queue.stream().anyMatch(s -> s > importanceLevel)) {
                            queue.offer(importanceLevel);
                            M += queue.size();
                        // CASE 4
                        } else {
                            printCount++;
                            break;
                        }
                    } else {
                        // CASE 1
                        if(queue.stream().anyMatch(s -> s > importanceLevel)) {
                            queue.offer(importanceLevel);
                        // CASE 2
                        } else {
                            printCount++;
                        }
                    }

                    checkCount++;
                }

                result.append(printCount).append("\n");
            }
        }

        bw.write(result.toString());

        br.close();
        bw.close();
    }
}
