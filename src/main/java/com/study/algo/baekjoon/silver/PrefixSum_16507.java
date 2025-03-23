package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class PrefixSum_16507 {
    static int R;
    static int C;
    static int Q;
    static int[][] pictureInfo;
    static StringBuilder result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1 - 사진의 크기(R, C), 케이스 개수 Q
        // R - RxC 크기의 사진정보
        // Q - 케이스 별 꼭짓점 r1, c1, r2, c2

        // pictureInfo : 행 별 누적합 삽입

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        pictureInfo = new int[R+1][C+1]; // 사진의 밝기 정보
        result = new StringBuilder();

        for(int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= C; j++) {
                pictureInfo[i][j] = pictureInfo[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int brightnessAverage = getBrightnessAverage(r1, c1, r2, c2);
            result.append(brightnessAverage).append("\n");
        }

        bw.write(result.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static int getBrightnessAverage(int r1, int c1, int r2, int c2) {
        int brightnessSum = 0;
        for(int i = r1; i <= r2; i++) {
            // 행 별로 지정 영역(c1 ~ c2)의 누적합이므로 (c1 - 1) 위치의 누적합 차감
            brightnessSum += pictureInfo[i][c2] - pictureInfo[i][c1 - 1];
        }
        //System.out.println("brightnessSum = " + brightnessSum);
        int width = (r2 - r1 + 1) * (c2 - c1 + 1);
        //System.out.println("width = " + width);

        return brightnessSum / width;
    }
}
