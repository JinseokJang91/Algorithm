package com.study.algo.archive.baekjoon.silver;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Math_1198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 볼록 다각형의 3개의 연속된 점을 선택해서 삼각형을 만든 후 다각형제거 제거
        // => 다각형이 삼각형이 될 때까지 제거
        // => 최종 삼각형의 넓이가 최대인 케이스 구하기

        // 다각형 N개의 점중 3개를 뽑아 최대가 되는 삼각형 구하자

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        List<Point> pointList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Point point = new Point(x, y);

            pointList.add(point);
        }

        // 모든 경우의 수 탐색
        double result = 0;
        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++) {
                    result = Math.max(result, getTriangleArea(pointList.get(i), pointList.get(j), pointList.get(k)));
                }
            }
        }

        bw.write("" + result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static double getTriangleArea(Point point1, Point point2, Point point3) {
        // 신발끈 공식 사용 (외적)
        // | [(x1y2 + x2y3 + x3y1) - (x2y1 + x3y2 + x1y3)]| * 1/2

        return Math.abs(
                (point1.x * point2.y + point2.x * point3.y + point3.x * point1.y)
                - (point2.x * point1.y + point3.x * point2.y + point1.x * point3.y)
        ) * 0.5d;
    }
}
