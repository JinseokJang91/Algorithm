package com.study.algo.baekjoon.silver;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_2178 {
    static int[][] coordinates;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0}; // x방향 상하좌우
    static int[] dy = {0, 0, -1 ,1}; // y방향 상하좌우
    // 💡 현재 좌표에서 [dx, dy] 만큼 움직이기 위한 변수값
    //    => [-1,0] / [1,0] / [0,-1] / [0,1] 로 구성되면 되기 때문에
    //       각 dx, dy 배열 내 원소의 순서는 크게 상관 없다. 위 구성의 결과만 나오면 됨
    //       e.g. dx={0,0,-1,1} / dy={1,-1,0,0} 이어도 동일
    
    public static void main(String[] args) throws IOException {
        // 미로 최단거리 통과
        // [1,1]에서 출발 => [N,M] 위치로 이동 시에 최소 칸 수
        // 최단거리 = BFS 활용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        coordinates = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");

            if(input.length != M) return;

            for(int j = 0; j < M; j++) {
                coordinates[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 시작점 1,1 = > 좌표상 [0,0]
        int x = 0;
        int y = 0;

        //dfs(x, y);

        bfs(x, y);

        System.out.println(coordinates[N - 1][M - 1]);

//        // 좌표 별 이동순서 확인
//        for (int[] coordinate : coordinates) {
//            for (int i : coordinate) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();

            for(int i = 0; i < 4; i++) {
                // 각 방위(상하좌우) 별로 이동했을 때 가능한 지 확인
                // e.g. [0,0] 시작점에서 좌로

                // 1. 미로 범위 밖 제외
                // 2. 이동 불가능 칸 제외
                // 3. 이미 방문한 칸 제외
                int nextX = curPoint.x + dx[i];
                int nextY = curPoint.y + dy[i];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if(coordinates[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                        queue.offer(new Point(nextX, nextY));
                        visited[nextX][nextY] = true;
                        coordinates[nextX][nextY] = coordinates[curPoint.x][curPoint.y] + 1;
                    }
                }
            }
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                if(coordinates[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    coordinates[nextX][nextY] = coordinates[x][y] + 1;
                    dfs(nextX, nextY);
                }
            }
        }
    }
}
