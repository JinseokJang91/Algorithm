package com.study.algo.algorithm.a_data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class E_PriorityQueue {
    public static void main(String[] args) throws Exception {
        // 우선순위 큐

        // 백준 11286번 절댓값 힙 구현하기
        // x가 0일 때: 큐가 비어있으면 0 출력, 비어있지 않으면 절댓값이 최소인 값 출력, 음수 우선 출력
        // x가 0이 아닐 때: 큐에 새로운 값 추가(add), 우선순위 큐 정렬로 자동 정렬

        // 1. 시간복잡도
        // N 최대 범위가 100,000이므로 O(nlogn) 알고리즘 사용 가능

        // 2. 슈도코드 작성
        // N(질의 개수)
        // 우선순위 큐 선언
        // - 절댓값 기준으로 정렬되도록 설정
        // - 단, 절댓값이 같으면 음수 우선 정렬
        // for(N만큼 반복)
        // {
        //   입력이 0일 때: 큐가 비어있으면 0, 비어있지 않으면 큐의 front값 출력(poll())
        //   입력이 0이 아닐 때: 새로운 데이터를 우선순위 큐에 더하기(add())
        // }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 우선순위 정렬 기준 설정하는 부분이 가장 중요!!
        // ---------------------------------------------------------------------------------
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);

            if(firstAbs == secondAbs) {
                return o1 > o2 ? 1 : -1; // 절댓값 같은 경우 음수 우선
            }

            return firstAbs - secondAbs; // 절댓값 작은 데이터 우선
        });
        // ---------------------------------------------------------------------------------

        for(int i = 0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());

            if(request == 0) {
                if(queue.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.add(request);
            }
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
