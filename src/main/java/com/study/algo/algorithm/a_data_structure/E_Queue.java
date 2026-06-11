package com.study.algo.algorithm.a_data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class E_Queue {
    public static void main(String[] args) throws Exception {
        // 큐(Queue) 문제
        // 선입선출

        // 백준 2164번 카드 게임
        // 맨 위 카드 버리기 -> 맨 위 카드 맨 아래로 옮기기

        // 1. 슈도코드 작성
        // N(카드 개수) 입력 받기
        // 큐에 1부터 N까지 차례대로 삽입
        // for(N-1만큼 반복) // 마지막 1장만 남겨야 하므로
        // {
        //   poll() // 맨위 카드 제거
        //   int card = poll() // 다음 맨위 카드는 빼내서 삽입
        // }
        // 마지막 카드 뽑아서 출력

        // 2. 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }
        for(int i = 0; i < N-1; i++) {
            queue.poll();

            if(!queue.isEmpty()) {
                int card = queue.poll();
                queue.add(card);
            }
        }

        // while 로도 구현 가능
        /*
        while(queue.size() > 1) {
            queue.poll();
            int card = queue.poll();
            queue.add(card);
        }
         */

        if(!queue.isEmpty()) {
            int lastCard = queue.poll();
            bw.write("" + lastCard);
        }

        br.close();
        bw.close();
    }
}
