package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.*;

public class HashSort_1764 {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        // N : 듣도 못한 사람의 수
        // M : 보도 못한 사람의 수
        // 듣보잡(듣도 보도 못한 사람 수) = 교집합
        //  - 이름은 알파벳 소문자
        //  - N, M에 중복 이름은 없음

        // 1. HashSet 사용
        useHashSet();

        // 2. 우선순위 Queue 사용
        //usePriorityQueue();

        // 추가 풀이 가능방법
        // 3. 이분탐색 (Binary Search)
    }

    private static void useHashSet() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<String> notHeardPeople = new HashSet<>();
        ArrayList<String> notHeardAndSeendPeople = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            notHeardPeople.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            String name = br.readLine();
            if(notHeardPeople.contains(name)) {
                notHeardAndSeendPeople.add(name);
            }
        }

        Collections.sort(notHeardAndSeendPeople, Comparator.naturalOrder());

        bw.write(notHeardAndSeendPeople.size() + "\n");
        for(String name : notHeardAndSeendPeople) {
            bw.write(name + "\n");
        }

        br.close();
        bw.close();
    }

    private static void usePriorityQueue() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] names = new String[N + M];
        PriorityQueue<String> queue = new PriorityQueue<>();

        for(int i = 0; i < N + M; i++) {
            names[i] = br.readLine();
        }

        Arrays.sort(names);

        for(int i = 0; i < N + M - 1; i++) {
            if(names[i].equals(names[i + 1])) {
                queue.offer(names[i]);
            }
        }

        bw.write(queue.size() + "\n");
        while(!queue.isEmpty()) {
            bw.write(queue.poll() + "\n");
        }

        br.close();
        bw.close();
    }
}
