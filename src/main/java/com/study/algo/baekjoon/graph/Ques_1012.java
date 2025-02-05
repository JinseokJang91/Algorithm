package com.study.algo.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ques_1012 {
    static int T;
    static int M; // 가로
    static int N; // 세로
    static int K; // 배추가 심어져있는 위치의 개수
    static final List<int[][]> caseList = new ArrayList<>();
    static boolean[][] visited;
    static int count;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static final List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 유기농 배추 재배를 위한 배추흰지렁이 배치
        // 인접한 배추끼리는 이동할 수 있어 한 마리만 배치해도 됨
        // 배추밭이 주어질 때 지렁이가 몇 마리 필요한 지 구하기

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int[][] cabbages = new int[M][N];

            for(int j = 0; j < K; j++) {
                StringTokenizer coordinate = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(coordinate.nextToken());
                int y = Integer.parseInt(coordinate.nextToken());

                cabbages[x][y] = 1;
            }

            caseList.add(cabbages);
        }

        for(int[][] cabbages : caseList) {
            System.out.println("\n======= cabbages START =======");
            for(int[] i : cabbages) {
                for(int j : i) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            System.out.println("======= cabbages END =======\n");

            visited = new boolean[M][N];
            count = 0;
            getEarthWorms(0, 0, cabbages, count);
            System.out.println("count : " + count);

            resultList.add(count);
        }

        System.out.println("resultList : " + resultList);

        br.close();
    }

    private static void getEarthWorms(int x, int y, int[][] cabbages, int earthWorms) {
        System.out.println("방문 : [" + x + ", " + y + "]");
        visited[x][y] = true;

        if(cabbages[x][y] == 1) {
            System.out.println("배추 있다 : [" + x + ", " + y + "]");
            earthWorms++;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                System.out.println(">>> 인접 방문 " + (i+1) + "번째 : [" + nextX + ", " + nextY + "]");

                // 배추밭을 벗어나는 경우 제외
                if (nextX < 0 || nextX > M - 1 || nextY < 0 || nextY > N - 1) {
                    System.out.println("==================> 배추밭 벗어남");
                    continue;
                }

                if (cabbages[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    System.out.println("==================> 방문 처리");
                    visited[nextX][nextY] = true;
                    getEarthWorms(nextX, nextY, cabbages, earthWorms);
                }
            }
        } else {
            System.out.println("배추 없다 : [" + x + ", " + y + "]");
//            System.out.println("\n======= visited START =======");
//            for(boolean[] i : visited) {
//                for(boolean j : i) {
//                    System.out.print(j + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("======= visited END =======\n");

            for(int i = 0; i < cabbages.length; i++) {
                for(int j = 0; j < cabbages[i].length; j++) {
                    if(!visited[i][j]) {
                        getEarthWorms(i, j, cabbages, earthWorms);
                        break;
                    }
                }
            }
        }
    }
}
