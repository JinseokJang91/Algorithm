package com.study.algo.programmers;

import java.io.*;
import java.util.StringTokenizer;

public class V20260930 {
    public static void main(String[] args) throws IOException {
        /**
         * [구현]
         * N×N 격자가 있습니다. 0은 빈 칸, 1은 벽입니다. 로봇은 (0, 0)에서 동쪽을 보고 출발합니다.
         * 명령 문자열이 주어지면 한 글자씩 순서대로 실행합니다.
         *
         * L: 왼쪽으로 90° 회전
         * R: 오른쪽으로 90° 회전
         * F: 바라보는 방향으로 한 칸 전진합니다. 다음 칸이 격자 밖이거나 벽이면 이동하지 않고 다음 명령으로 넘어갑니다.
         *
         * 모든 명령을 실행한 뒤 로봇의 최종 위치와 한 번이라도 방문한 칸의 개수(시작 칸 포함)를 출력하세요.
         *
         * 제약
         *   - 2 ≤ N ≤ 100
         *   - 명령 길이 M ≤ 100,000
         *   - (0, 0)은 항상 빈 칸
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        String command = br.readLine();

        int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
        int[] dc = {0, 1, 0, -1}; // 북, 동, 남, 서
        boolean[][] visited = new boolean[N][N];

        // 방향(d): 북(0),동(1),남(2),서(3)
        int r = 0, c = 0;
        int d = 1;
        visited[0][0] = true;
        int count = 1;

        for(int i = 0; i < command.length(); i++) {
            switch(command.charAt(i)) {
                case 'L' -> {
                    d = (d + 3) % 4; // d가 1이면 결과가 0이므로 동 -> 북으로 왼쪽 회전
                }
                case 'R' -> {
                    d = (d + 1) % 4; // d가 1이면 결과가 2이므로 동 -> 남으로 오른쪽 회전
                }
                case 'F' -> {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // 아래 조건문 대신 순서대로 체크하는게 더 깔끔한듯
                    /*
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if(map[nr][nc] == 1) continue;
                    */

                    if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 1) { // 범위 체크가 먼저!!
                        r = nr;
                        c = nc;

                        if(!visited[r][c]) {
                            visited[r][c] = true;
                            count++;
                        }
                    }
                }
            }
        }

        bw.write(r + " " + c + "\n" + count);

        br.close();
        bw.close();
    }
}
