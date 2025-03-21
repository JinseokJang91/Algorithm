package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sort_1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1 - 배열 A의 크기 N
        // 2 - 배열 A의 원소

        // P : 0 ~ N-1 으로 이루어진 수열
        // 수열 P를 A에 적용했을 때 비내림차순(오름차순)이 되는 수열 P를 출력
        // e.g. A가 2, 3, 1 인 경우 => P 적용 => 1, 2, 0

        int N = Integer.parseInt(br.readLine());
        int[] sortedA = new int[N];
        boolean[] visited = new boolean[N];
        int[] origin = new int[N];
        int[] P = new int[N];
        StringBuilder resultP = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sortedA[i] = num;
            origin[i] = num;
        }

        Arrays.sort(sortedA);

        for(int i = 0; i < origin.length; i++) {
            int orgNum = origin[i];

            for(int j = 0; j < sortedA.length; j++) {
//                System.out.println("orgNum = " + orgNum);
//                System.out.println("sortedA[j] = " + sortedA[j]);
//                System.out.println("visited[j] = " + visited[j]);
                if(orgNum == sortedA[j] && !visited[j]) {
//                    System.out.println("P[" + i +"] = " + j);
                    visited[j] = true;
                    P[i] = j;
                    resultP.append(j).append(" ");
                    break;
                }
            }

//            System.out.println("======================");
        }

        bw.write(resultP.toString().trim());

        br.close();
        bw.close();
    }
}
