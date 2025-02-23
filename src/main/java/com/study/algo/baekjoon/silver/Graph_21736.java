package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Graph_21736 {
    static int N;
    static int M;
    static String[][] campus;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int startX;
    static int startY;
    static int friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new String[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String[] campusInfo = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                campus[i][j] = campusInfo[j];

                if("I".equals(campusInfo[j])) {
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(startX, startY);

        if(friends == 0) {
            bw.write("TT");
        } else {
            bw.write("" + friends);
        }

        br.close();
        bw.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        if("P".equals(campus[x][y])) {
            friends++;
        }

        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= N || nextY >= M || nextX < 0 || nextY < 0) {
                continue;
            }

            if("X".equals(campus[nextX][nextY])) {
                continue;
            }

            if(visited[nextX][nextY]) {
                continue;
            }

            dfs(nextX, nextY);
        }
    }
}
