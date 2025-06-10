package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Eratosthenes_2960 {
    private static int N;
    private static int K;
    private static List<Integer> numbers;
    private static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 에라토스테네스의 체 (소수 판별)
        // 1. 2부터 N까지 모든 정수를 적는다.
        // 2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라 하고, 이 수는 소수이다.
        // 3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
        // 4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.

        // K번째 지우는 수 구하기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        numbers = new ArrayList<>();
        list = new LinkedList<>();

        for(int i = 2; i <= N; i++) {
            numbers.add(i);
        }

        applyEratosthenes();

        bw.write("" + list.get(K - 1));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void applyEratosthenes() {
        if(numbers.isEmpty() || list.size() == K) {
            // numbers empty : 알고리즘 규칙이 모든 수를 지울 때까지 이므로
            // list size >= K : K번째 숫자를 구하는 것이므로
            return;
        }

        int P = numbers.get(0); // 소수
        numbers.remove(0);
        list.add(P);

        for(int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            if(num % P == 0) {
                numbers.remove(i);
                list.add(num);
            }
        }

        applyEratosthenes();
    }
}
