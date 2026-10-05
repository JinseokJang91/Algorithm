package com.study.algo.claude;

import java.io.*;
import java.util.StringTokenizer;

public class V20261005 {
    public static void main(String[] args) throws IOException {
        /** [구현]
         * > 문제 - 얼음 녹이기
         * N×M 격자의 각 칸은 물(0)이거나 두께 1~10의 얼음입니다.
         *
         * 1시간이 지날 때마다 모든 얼음 칸이 동시에 다음 규칙대로 녹습니다.
         *
         * 각 얼음 칸은 상하좌우로 맞닿은 물 칸의 개수만큼 두께가 줄어듭니다.
         * 두께가 0 이하가 되면 그 칸은 물(0)이 됩니다.
         * 격자 테두리 칸은 항상 0으로 주어집니다.
         *
         * 모든 얼음이 녹을 때까지 걸리는 시간 T와, 얼음이 마지막으로 남아 있던 시점(T−1시간 후)의 얼음 칸 개수를 공백으로 구분해 출력하세요. 처음부터 얼음이 없으면 0 0을 출력합니다.
         *
         * > 입력
         * 첫 줄: N M  (3 ≤ N, M ≤ 50)
         * 다음 N줄: 각 칸의 값 M개 (0 ~ 10)
         */
        String result1 = solution();
        String result2 = answer();
    }

    private static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][M];
        int[][] melted = new int[N][M]; // 녹은 양은 따로 저장
        boolean[][] isWater = new boolean[N][M]; // 해당 칸이 물인지 여부
        int checkNoWater = 0;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                checkNoWater += input;
                grid[i][j] = input;
                if(input == 0) isWater[i][j] = true;
            }
        }

        if(checkNoWater == 0) {
            bw.write("0 0");
        } else {
            boolean isAllWater = false;
            int T = 0;
            int count = 0;

            while(!isAllWater) {
                T++;
                count = 0;

                // 녹은 만큼 얼음 칸 감소
                for (int i = 1; i < N; i++) {
                    for (int j = 1; j < M; j++) {
                        grid[i][j] -= melted[i][j];
                        if(grid[i][j] > 0) count++; // 얼음 칸 개수 카운트
                    }
                }

                // 격자 테두리는 항상 물(0)이므로 인덱스 1부터 체크
                for (int i = 1; i < N; i++) {
                    for (int j = 1; j < M; j++) {
                        // 얼음일 때
                        if (grid[i][j] > 0) {
                            int southWater = grid[i + 1][j] <= 0 ? 1 : 0;
                            int northWater = grid[i - 1][j] <= 0 ? 1 : 0;
                            int eastWater = grid[i][j + 1] <= 0 ? 1 : 0;
                            int westWater = grid[i][j - 1] <= 0 ? 1 : 0;
                            int waterCount = southWater + northWater + eastWater + westWater;

                            melted[i][j] = waterCount;
                            if (grid[i][j] - waterCount <= 0) isWater[i][j] = true;
                        } else {
                            melted[i][j] = 0;
                        }
                    }
                }

                // 모두 물인지 체크
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if(!isWater[i][j]) {
                            sum++;
                        }
                    }
                }

                if (sum == 0) {
                    isAllWater = true;
                }
            }


            result.append(T).append(" ").append(count);
            bw.write(result.toString());
        }

        br.close();
        bw.close();

        return result.toString();
    }

    private static String answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][M];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        StringBuilder result = new StringBuilder();

        int T = 0, last = 0;
        while (true) {
            // 1) 세기: 지금 grid = T시간 후 상태
            int ice = 0;
            for (int i = 1; i < N - 1; i++)
                for (int j = 1; j < M - 1; j++)
                    if (grid[i][j] > 0) ice++;
            if (ice == 0) break;          // 판정: 얼음이 없으면 종료
            last = ice;                   // 마지막으로 얼음이 남아 있던 시점의 개수

            // 2) 계산: 원본은 읽기만 하고, 결과는 새 배열에 쓴다 → "동시에"가 자동으로 보장됨
            int[][] next = new int[N][M];
            for (int i = 1; i < N - 1; i++)
                for (int j = 1; j < M - 1; j++) {
                    if (grid[i][j] == 0) continue;
                    int water = 0;
                    for (int d = 0; d < 4; d++)
                        if (grid[i + dr[d]][j + dc[d]] == 0) water++;
                    next[i][j] = Math.max(0, grid[i][j] - water);   // 음수 방지 → 물은 항상 0
                }

            // 3) 적용
            grid = next;
            T++;
        }
// 처음부터 얼음이 없으면 T=0, last=0 → "0 0"이 따로 처리하지 않아도 나온다

        result.append(T).append(" ").append(last);
        bw.write(result.toString());
        br.close();
        bw.close();

        return result.toString();
    }
}
