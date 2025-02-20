package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 요세푸스 순열
        // N : 1 ~ N번 까지의 N명의 사람들이 원을 이루며 앉아있음
        // K : K번째 사람 제거
        // N명의 사람이 모두 제거될 때까지 계속 수행

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int cnt = 0;

        sb.append("<");
        while(!queue.isEmpty()) {
            cnt++;

            int num = queue.poll();

            // 마지막 사람
            if(queue.isEmpty()) {
                sb.append(num);
                break;
            }

            if(cnt % K == 0) {
                sb.append(num).append(", ");
                cnt = 0;
            } else {
                queue.offer(num);
            }
        }
        sb.append(">");

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
