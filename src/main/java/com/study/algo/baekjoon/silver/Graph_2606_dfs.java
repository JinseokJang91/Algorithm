package com.study.algo.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph_2606_dfs {
    static int[][] arr;
    static boolean[] visited;
    static int answer;


    public static void main(String[] args) throws IOException {
        // 바이러스
        // N : 컴퓨터의 수 (노드 수)
        // M : 직접 연결되어 있는 컴퓨터 쌍의 수
        // M의 개수만큼 한 줄에 한 쌍씩 직접 연결되어 있는 컴퓨터의 번호 쌍

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        int N = Integer.parseInt(input1);

        arr = new int[N+1][N+1]; // index 1 ~ 7 사용 목적으로 N+1 사용
        visited = new boolean[N+1];

        String input2 = br.readLine();
        int M = Integer.parseInt(input2);


        for(int i = 0; i < M; i++) {
            String input3 = br.readLine();
            StringTokenizer st = new StringTokenizer(input3);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 1로 노드 간 간선 표시
            // 1-2면 2-1과도 같음 (양방향 연결)
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        dfs(1);
        System.out.println(answer - 1);

        br.close();
    }

    private static void dfs(int virusNode) {
        System.out.println("virusNode : " + virusNode);
        if(visited[virusNode]) {
            return;
        }

        visited[virusNode] = true;
        answer++;

        for(int i = 1; i < arr.length; i++) {
            // 바이러스에 감연된노드와 i번 노드가 간선으로 연결되어 있으면
            // i번 노드와 연결된 노드를 찾는다
            if(arr[virusNode][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
