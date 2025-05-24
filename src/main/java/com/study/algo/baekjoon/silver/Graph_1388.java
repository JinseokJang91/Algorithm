package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class Graph_1388 {
    private static boolean[][] visited;
    private static String[][] arr;
    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // '-' 와 '|'로 이루어진 바닥 장식
        // '-' : 같은 행에 이어져있으면 같은 나무판자
        // '|' : 같은 열에 이어져있으면 같은 나무판자

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    count++;

//                    visited[i][j] = true;
//
//                    if("-".equals(arr[i][j])) {
//                        count++;
//                        // 같은 행 & 이어진 열에 동일 모양이 있는 지 확인해서 방문 처리
//                        int index = j + 1;
//                        while(index < M) {
//                            if (!visited[i][index] && "-".equals(arr[i][index])) {
//                                visited[i][index] = true;
//                                index++;
//                            } else {
//                                break;
//                            }
//                        }
//                    } else if("|".equals(arr[i][j])) {
//                        count++;
//
//                        // 같은 열 & 이어진 행에 동일 모양이 있는 지 확인해서 방문 처리
//                        int index = i + 1;
//                        while(index < N) {
//                            if (!visited[index][j] && "|".equals(arr[index][j])) {
//                                visited[index][j] = true;
//                                index++;
//                            } else {
//                                break;
//                            }
//                        }
//                    }
                }
            }
        }
        bw.write("" + count);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;

        if ("-".equals(arr[i][j])) {
            if(j + 1 < M) {
                if("-".equals(arr[i][j + 1]) && !visited[i][j + 1]) {
                    dfs(i, j + 1);
                }
            }
        } else if("|".equals(arr[i][j])) {
            if(i + 1 < N) {
                if("|".equals(arr[i + 1][j]) && !visited[i + 1][j]) {
                    dfs(i + 1, j);
                }
            }
        }
    }
}
