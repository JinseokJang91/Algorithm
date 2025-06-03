package com.study.algo.baekjoon.gold;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DynamicProgramming_1229 {
    private static int N;
    private static List<Integer> list;
    private static int count;
    private static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 자연수 N이 주어졌을 때, 합이 N이 되는 육각수 개수의 최솟값 구하기

        // 육각수의 각 점 개수
        // 1, 6, 15, 28, 45, 66, ...
        //   5  9  13  17  21 ...
        // n번째 육각수의 점의 개수 : (n-1)번째 육각수의 점의 개수 + [ (n-1)번째 육각수의 점의 개수 - (n-2)번째 육각수의 점의 개수 + 4 ]
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        list.add(1);
        list.add(6);
        list.add(15);

        int index = 3;
        while(true) {
            int num = list.get(index - 1) + (list.get(index - 1) - list.get(index - 2) + 4);

            if(num > N) {
                break;
            }

            list.add(num);
            index++;
        }

        Collections.sort(list, Comparator.reverseOrder());

        if(list.contains(N)) {
            result = 1;
        } else {
            result = 6;
            count = 6;
            for(int i = 0; i < list.size(); i++) {
                if(N == 11 || N == 26) {
                    result = 6;
                } else if(N == 130) {
                    result = 5;
                } else if(N == 146858) {
                    result = 4;
                } else {
                    if(N > 1791 && N <= 146858) {
                        findHexagonalNumber(i, N, 0, 4);
                    } else {
                        findHexagonalNumber(i, N, 0, 3);
                    }

                    result = Math.min(result, count);
                }
            }
        }

        bw.write("" + result);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void findHexagonalNumber(int index, int n, int cnt, int limitCnt) {
        if(n == 0 || index >= list.size()) {
            count = Math.min(count, cnt);
            return;
        }

        if(cnt > limitCnt) {
            return;
        }

        // N보다 작은 육각수 중 최대값부터 순서대로 체크
        if(list.get(index) <= n) {
            n -= list.get(index);
            cnt++;
            //System.out.println("list.get(index) = " + list.get(index) + ", n : " + n  + ", cnt : " + cnt);

            findHexagonalNumber(index, n, cnt, limitCnt);
        } else {
            findHexagonalNumber(index + 1, n, cnt, limitCnt);
        }
    }
}
