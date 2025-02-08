package com.study.algo.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Graph_1012 {
    static int T, M, N, K; // 테스트케이스 수, 가로, 세로, 배추가 심어져있는 위치의 개수
    static int[][] cabbages;
    static boolean[][] visited;
    static int[] result;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 유기농 배추 재배를 위한 배추흰지렁이 배치
        // 인접한 배추끼리는 이동할 수 있어 한 마리만 배치해도 됨
        // 배추밭이 주어질 때 지렁이가 몇 마리 필요한 지 구하기

        T = Integer.parseInt(br.readLine());
        result = new int[T];

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cabbages = new int[M][N];
            visited = new boolean[M][N];

            for(int j = 0; j < K; j++) {
                StringTokenizer coordinate = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(coordinate.nextToken());
                int y = Integer.parseInt(coordinate.nextToken());

                cabbages[x][y] = 1;
            }

            int count = 0;

            for(int x = 0; x < cabbages.length; x++) {
                for(int y = 0; y < cabbages[i].length; y++) {
                    // 배추가 심어져있는 곳 하나 발견하면 인접해있는 배추를 다 찾을 수 있음
                    if(cabbages[x][y] == 1 && !visited[x][y]) {
                        findCabbages(x, y);
                        count++;
                    }
                }
            }

            result[i] = count;
        }

        for(int cnt : result) {
            System.out.println(cnt);
        }

        br.close();
    }

    private static void findCabbages(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            // 배추밭을 벗어나는 경우 제외
            if (nextX < 0 || nextX > M - 1 || nextY < 0 || nextY > N - 1) {
                continue;
            }

            if (cabbages[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                findCabbages(nextX, nextY);
            }
        }
    }
}
