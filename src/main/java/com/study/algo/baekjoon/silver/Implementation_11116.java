package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Implementation_11116 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // 왼쪽에서 온 차 대수 구하기
        // 1대가 오면 첫 번째 끈에서 2번, 두 번째 끈에서 2번 측정됨
        // 예제 2
        // 235 735 1235 1735 (왼쪽 > 오른쪽)
        // 451 951 1451 1951 (왼쪽 > 오른쪽)
        // 1351 1851 2351 2851 (오른쪽 > 왼쪽)

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            StringTokenizer leftRope = new StringTokenizer(br.readLine(), " ");
            StringTokenizer rightRope = new StringTokenizer(br.readLine(), " ");

            List<Integer> leftRecords = new ArrayList<>();
            List<Integer> rightRecords = new ArrayList<>();

            for(int j = 0; j < m; j++) {
                leftRecords.add(Integer.parseInt(leftRope.nextToken()));
                rightRecords.add(Integer.parseInt(rightRope.nextToken()));
            }

            int count = 0;

            for(int record : leftRecords) {
                if(leftRecords.contains(record + 500)
                        && rightRecords.contains(record + 1000)
                            && rightRecords.contains(record + 1500)) {
                    count++;
                }
            }

            result.append(count).append("\n");
        }

        bw.write(result.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
