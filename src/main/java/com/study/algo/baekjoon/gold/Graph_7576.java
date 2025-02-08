package com.study.algo.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph_7576 {
    static int N;
    static int M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Tomato> coordinates = new LinkedList<>();
    static int[][] tomatoBox;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // M : 상자 가로 칸
        // N : 상자 세로 칸

        // 1 : 익은 토마토
        // 0 : 익지 않은 토마토
        // -1 : 토마토 들어있지 않음

        StringTokenizer tomatoBoxArea = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(tomatoBoxArea.nextToken());
        N = Integer.parseInt(tomatoBoxArea.nextToken());

        tomatoBox = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            StringTokenizer tomatoBoxWidth = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                tomatoBox[i][j] = Integer.parseInt(tomatoBoxWidth.nextToken());
            }
        }

        // * 익은 토마토 상하좌우에 위치한 익지 않은 토마토 => 익은 토마토
        // * 모든 토마토가 익는데 소요되는 일수 구하기

        // 1. 익은 토마토 좌표 찾기 & 방문 처리 (최초)
        for(int i = 0; i < tomatoBox.length; i++) {
            for(int j = 0; j < tomatoBox[i].length; j++) {
                if(tomatoBox[i][j] == 1) {
                    coordinates.offer(new Tomato(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        // 2. 너비우선탐색 (BFS)
        bfs();

        br.close();
    }

    private static void bfs() {
        int requiredDaysForAllTomatoesRipe = 0;

        while(!coordinates.isEmpty()) {
            Tomato coordinate = coordinates.poll();
            requiredDaysForAllTomatoesRipe = coordinate.day;
            System.out.println("[" + coordinate.x + ", " + coordinate.y + "]" + " ---------- Queue에서 꺼낸 값");

            for(int i = 0; i < 4; i++) {
                int nextX = coordinate.x + dx[i];
                int nextY = coordinate.y + dy[i];

                // 1. 박스 밖 제외 (토마토 박스 범위 밖)
                if(nextX >= N || nextX < 0 || nextY >= M || nextY < 0) {
                    System.out.println("[" + nextX + ", " + nextY + "]" + " ---------- 1. 박스 밖 제외 (토마토 박스 범위 밖)");
                    continue;
                }

                // 2. 이미 방문한 칸 제외 (익은 토마토가 있는 칸)
                if(visited[nextX][nextY]) {
                    System.out.println("[" + nextX + ", " + nextY + "]" + " ---------- 2. 이미 방문한 칸 제외 (익은 토마토가 있는 칸)");
                    continue;
                }

                // 3. 이동 불가능 칸 제외 (토마토가 없는 칸)
                if(tomatoBox[nextX][nextY] == -1) {
                    System.out.println("[" + nextX + ", " + nextY + "]" + " ---------- 3. 이동 불가능 칸 제외 (토마토가 없는 칸)");
                    continue;
                }

                tomatoBox[nextX][nextY] = 1;
                visited[nextX][nextY] = true;
                coordinates.add(new Tomato(nextX, nextY, requiredDaysForAllTomatoesRipe + 1));
            }

            System.out.println("===================================");
            System.out.println("day : " + requiredDaysForAllTomatoesRipe);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    System.out.print(tomatoBox[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("===================================");
        }

        // 상자 안 모든 토마토가 익었는 지 확인
        // => 못익는 케이스 존재 (한 칸 띄워서 위치하는 경우)
        boolean isAllTomatoesRipe = true;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tomatoBox[i][j] == 0) {
                    isAllTomatoesRipe = false;
                    break;
                }
            }
        }

        if(isAllTomatoesRipe) {
            System.out.println(requiredDaysForAllTomatoesRipe);
        } else {
            System.out.println(-1);
        }
    }

    public static class Tomato {
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
