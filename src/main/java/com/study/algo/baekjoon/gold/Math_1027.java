package com.study.algo.baekjoon.gold;

import java.io.*;
import java.util.StringTokenizer;

public class Math_1027 {
    private static int N;
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N : 빌딩의 수
        // 가장 많은 고층 빌딩이 보이는 빌딩 구하기
        // (두 지붕을 잇는 선분이 다른 빌딩을 지나지 않으면 보이는 빌딩)

        // 기준 빌딩 좌/우를 나눠서 생각
        // 빌딩 높이가 5 5 5 5 10 5 5 5 5 라고 생각하고 10인 빌딩 기준으로 좌우 기울기를 구해보면
        // 좌 방향은 기울기가 감소해야 건물이 보임
        // 우 방향은 기울기가 마이너스이므로 증가해야 건물이 보임

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            arr[i][0] = i + 1;
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = 0; i < N; i++) {
            result = Math.max(result, calculateVisibleBuilding(i));
        }

        bw.write("" + result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int calculateVisibleBuilding(int idx) {
        int count = 0;
        double compare = 0;

        // 좌측
        for(int i = idx - 1; i >= 0; i--) {
            int xGap = arr[idx][0] - arr[i][0];
            int yGap = arr[idx][1] - arr[i][1];

            double slope = (double) yGap / xGap;

            if(Math.abs(i - idx) == 1) {
                // 인접한 빌딩은 무조건 보임
                count++;
                compare = slope;
            } else {
                if(slope < compare) {
                    count++;
                    compare = slope;
                }
            }
        }

        // 우측
        for(int i = idx + 1; i < N; i++) {
            int xGap = arr[idx][0] - arr[i][0];
            int yGap = arr[idx][1] - arr[i][1];

            double slope = (double) yGap / xGap;

            if(Math.abs(i - idx) == 1) {
                // 인접한 빌딩은 무조건 보임
                count++;
                compare = slope;
            } else {
                if(slope > compare) {
                    count++;
                    compare = slope;
                }
            }
        }

        return count;
    }
}
