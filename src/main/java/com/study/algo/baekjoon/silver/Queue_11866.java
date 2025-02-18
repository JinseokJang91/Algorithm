package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer input = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(input.nextToken());
        int K = Integer.parseInt(input.nextToken());

        StringBuilder result = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int cnt = 0;
        result.append("<");
        while(!queue.isEmpty()) {
            cnt++;

            int x = queue.poll();

            if(cnt == N * K && queue.isEmpty()) {
                result.append(x).append(">");
                break;
            }

            if(cnt % K == 0) {
                result.append(x).append(", ");
            } else {
                queue.offer(x);
            }
        }

        bw.write(result.toString());

        br.close();
        bw.close();
    }
}
