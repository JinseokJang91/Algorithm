package com.study.algo.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ques_10026 {
    // 정상
    static String[][] nodes;
    static int[][] orders;
    static boolean[][] visited;
    static int count;
    static int areaNum = 1; // 영역번호
    // 색약
    static String[][] nodes_colorWeak;
    static int[][] orders_colorWeak;
    static boolean[][] visited_colorWeak;
    static int count_colorWeak;
    static int areaNum_colorWeak = 1; // 영역번호

    static int N;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nodes = new String[N][N];
        visited = new boolean[N][N];
        orders = new int[N][N];

        nodes_colorWeak = new String[N][N];
        visited_colorWeak = new boolean[N][N];
        orders_colorWeak = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] RGBs = br.readLine().split("");
            //System.arraycopy(RGBs, 0, nodes[i], 0, RGBs.length);
            for(int j = 0; j < RGBs.length; j++) {
                nodes[i][j] = RGBs[j];

                if("G".equals(RGBs[j])) {
                    RGBs[j] = "R";
                }
                nodes_colorWeak[i][j] = RGBs[j];
            }
        }

        for(int i = 0; i < nodes.length; i++) {
            for(int j = 0; j <nodes[i].length; j++) {
                if(visited[i][j]) continue;

                dfs(i, j);
                count++;
                areaNum++;
            }
        }
        System.out.println("count : " + count);

        for(int i = 0; i < nodes_colorWeak.length; i++) {
            for(int j = 0; j <nodes_colorWeak[i].length; j++) {
                if(visited_colorWeak[i][j]) continue;

                dfs_colorWeak(i, j);
                count_colorWeak++;
                areaNum_colorWeak++;
            }
        }
        System.out.println("count_colorWeak : " + count_colorWeak);

        System.out.println("=========================");
        System.out.println("[정상 영역]");
        // 영역 별 번호를 매겨 확인
        for (int[] order : orders) {
            for (int i : order) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println("\n[색약 영역]");
        for (int[] order : orders_colorWeak) {
            for (int i : order) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("=========================");
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        orders[x][y] = areaNum;

        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if(!visited[nextX][nextY]) {
                    if(nodes[nextX][nextY].equals(nodes[x][y])) {
                        dfs(nextX, nextY);
                    }
                }
            }
        }
    }

    private static void dfs_colorWeak(int x, int y) {
        visited_colorWeak[x][y] = true;
        orders_colorWeak[x][y] = areaNum_colorWeak;

        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if(!visited_colorWeak[nextX][nextY]) {
                    if(nodes_colorWeak[nextX][nextY].equals(nodes_colorWeak[x][y])) {
                        dfs_colorWeak(nextX, nextY);
                    }
                }
            }
        }
    }
}
