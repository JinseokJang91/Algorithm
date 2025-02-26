package com.study.algo.baekjoon.gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy_1931 {
    static int N;
    static int[][] conferences;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N개의 회의의 수가 주어지고, 각 회의마다 시작 시간과 종료 시간이 주어짐
        // 회의의 최대 개수를 출력하려면,
        // 1. 시작 시간이 동일하면, 종료 시간이 빨리 끝나는게 우선
        // 2. 시작 시간이 더 빠르더라도 종료 시간이 늦으면 회의를 많이 잡을 수 없음
        // 3. 회의 종료와 동시에 다음 회의 시작이 가능하므로 종료 시간 기준으로 판단
        // 4. 가장 먼저 종료되는 회의를 시작으로
        //    다음 시작 시간이 이전 종료 시간과 겹치지 않으면서 다음 종료 시간이 빨리 끝나는 것을 기준으로 작업
        // 5. 시작 시간과 종료 시간이 같을 수 있음

        N = Integer.parseInt(br.readLine());

        conferences = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer times = new StringTokenizer(br.readLine(), " ");
            conferences[i][0] = Integer.parseInt(times.nextToken());
            conferences[i][1] = Integer.parseInt(times.nextToken());
        }

        // 종료시간 오름차순 정렬
        // 종료시간 같으면 시작시간 오름차순 정렬
        Arrays.sort(conferences, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

       if(N == 1) {
           // N이 1이면 최대 개수는 1
           count = 1;
       } else {
           // 이전 종료시간 (targetTime) : A
           // 다음 시작시간 (startTime) : B-1
           // 다음 종료시간 (endTime) : B-2

           int targetTime = 0;

           for(int i = 0; i < N; i++) {
               int[] conference = conferences[i];
               int startTime = conference[0];
               int endTime = conference[1];

               if(endTime >= targetTime) { // B-2 >= A (다음 회의의 시작시간과 종료시간이 동일할 수 있음)
                   if(startTime >= targetTime) { // B-1 >= A (이전 종료시간과 다음 시작시간을 겹쳐도 가능)
                       count++;
                       targetTime = endTime;
                   }
               }
           }
       }

       bw.write("" + count);

       br.close();
       bw.close();
    }
}
