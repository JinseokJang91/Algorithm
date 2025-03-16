package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.*;

public class String_14425 {
    static int N;
    static int M;
    static int count;
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 집합 S : N개의 문자열
        // M개의 문자열 : 집합 S에 포함되어 있는지 확인

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = 0;

        //solution_arraylist(); // 시간 : 2768 ms
        //solution_hashset(); // 시간 : 368 ms
        solution_hashmap(); // 시간 : 384 ms

        bw.write("" + count);

        br.close();
        bw.close();
    }

    // ArrayList 사용
    public static void solution_arraylist() throws IOException {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            String input = br.readLine();

            if(list.contains(input)) {
                count++;
            }
        }
    }

    // HashSet 사용
    public static void solution_hashset() throws IOException {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            String input = br.readLine();

            if(set.contains(input)) {
                count++;
            }
        }
    }

    // HashMap 사용
    public static void solution_hashmap() throws IOException {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            map.put(br.readLine(), 0);
        }

        for(int i = 0; i < M; i++) {
            String input = br.readLine();

            if(map.containsKey(input)) {
                count++;
            }
        }
    }
}
