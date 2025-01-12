package com.study.algo.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ques_1260 {
    static int[][] nodes;
    static boolean[] visited; // 각 노드 방문여부
    static StringTokenizer st;
    static Queue<Integer> que;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        // N : 정점(노드)의 개수
        // M : 간선의 개수
        // V : 시작 정점(노드) 번호

        // 인접한 노드가 여러개인 경우 작은 노드(오름차순)부터 방문

        // DFS, BFS 수행한 각 결과 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        nodes = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 서로 연결된 노드 표시
        // e.g. nodes[1][2] = nodes[2][1] = 1 이면, 노드 1과 2가 간선으로 연결
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[x][y] = nodes[y][x] = 1;
        }

        dfs(V);

        visited = new boolean[N + 1];
        stack = new Stack<>();
        System.out.println();
        dfs_stack(V);

        visited = new boolean[N + 1];
        que = new LinkedList<>();
        System.out.println();
        bfs(V);

        br.close();
    }

    private static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        // CASE 1 : 인접한 노드 여러개 > 오름차순
        for(int i = 1; i < nodes.length; i++) {
            if((nodes[i][node] == 1 || nodes[node][i] == 1) && !visited[i]) {
                dfs(i);
            }
        }

//        // CASE 2 : 인접한 노드 여러개 > 내림차순
//        for(int i = nodes.length - 1; i >= 1; i--) {
//            if((nodes[i][node] == 1 || nodes[node][i] == 1) && !visited[i]) {
//                dfs(i);
//            }
//        }
    }

    private static void dfs_stack(int node) {
        stack.push(node);
        visited[node] = true;

        while(!stack.isEmpty()) {
            int visitedNode = stack.pop();
            System.out.print(visitedNode + " ");

            // CASE 1 : 인접한 노드 여러개 > 내림차순 (재귀와 반대, 후입선출이므로)
            for(int i = 1; i < nodes.length; i++) {
                if((nodes[i][visitedNode] == 1 || nodes[visitedNode][i] == 1) && !visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }

            // CASE 2 : 인접한 노드 여러개 > 내림차순 (재귀와 반대, 후입선출이므로)
            for(int i = nodes.length - 1; i >= 1; i--) {
                if((nodes[i][visitedNode] == 1 || nodes[visitedNode][i] == 1) && !visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
    }

    private static void bfs(int node) {
        que.offer(node);
        visited[node] = true;

        while(!que.isEmpty()) {
            int visitedNode = que.poll();
            System.out.print(visitedNode + " ");

            // CASE 1 : 인접한 노드 여러개 > 오름차순
            for(int i = 1; i < nodes.length; i++) {
                if((nodes[i][visitedNode] == 1 || nodes[visitedNode][i] == 1) && !visited[i]) {
                    visited[i] = true;
                    que.offer(i);
                }
            }

//            // CASE 2 : 인접한 노드 여러개 > 내림차순
//            for(int i = nodes.length - 1; i >= 1; i--) {
//                if((nodes[i][visitedNode] == 1 || nodes[visitedNode][i] == 1) && !visited[i]) {
//                    visited[i] = true;
//                    que.offer(i);
//                }
//            }
        }
    }
}
