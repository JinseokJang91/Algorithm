package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BackTracking_15663 {
    static int N;
    static int M;
    static int[] arr;
    static int[] tmp;
    static boolean[] visited;
    static Set<String> ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N개의 자연수 중 M개를 고른 수열
        // nPm = n! / (n-m)!

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        tmp = new int[N];
        visited = new boolean[N];
        ans = new LinkedHashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backtracking(0);

        for(String el : ans) {
            bw.write(el + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth) {
        if(depth == M) {
            StringBuilder el = new StringBuilder();
            for(int i = 0; i < M; i++) {
                el.append(tmp[i]).append(" ");
            }
            ans.add(el.toString().trim());

            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                tmp[depth] = arr[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
