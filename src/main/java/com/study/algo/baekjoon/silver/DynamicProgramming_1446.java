package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DynamicProgramming_1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N : 지름길의 개수
        // D : 고속도로의 길이
        // N개 줄 : 지름길 시작위치, 도착위치, 지름길의 길이

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        // 지름길 정보 세팅
        List<Shortcut> shortcutList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            shortcutList.add(new Shortcut(start, end, distance));
        }

        // 기본 소요 거리 세팅
        int[] dp = new int[D + 1];
        for(int i = 1; i <= D; i++) {
            // 지름길을 사용하지 않고 이동했을 때 도착지점 별 거리 기본 세팅
            dp[i] = i;
        }

        // 지름길 적용 및 소요 거리 변경
        for(int i = 1; i <= D; i++) {
            // 하단 지름길 작업 완료 시 => 소요 거리는 변했으므로 다음 index부터 변경해줘야 함
            dp[i] = dp[i - 1] + 1;

            for(Shortcut shortcut : shortcutList) {
                // 도착지점에 대한 지름길 유무에 따른 거리 최솟값 설정
                if(shortcut.end == i) {
                    dp[i] = Math.min(dp[i], dp[shortcut.start] + shortcut.distance);
                }
            }
        }

        bw.write("" + dp[D]);
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Shortcut {
        private final int start;
        private final int end;
        private final int distance;

        public Shortcut(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}
