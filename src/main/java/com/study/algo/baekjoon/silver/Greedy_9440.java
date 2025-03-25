package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy_9440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());

            if(N == 0) {
                break;
            }

            int[] arr = new int[N];

            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            StringBuilder result1 = new StringBuilder();
            StringBuilder result2 = new StringBuilder();
            int[] num1 = new int[N % 2 == 0 ? N / 2 : N / 2 + 1];
            int[] num2 = new int[N / 2];
            int index1 = 0;
            int index2 = 0;

            for(int i = 0; i < N; i++) {
                if(i % 2 == 0) {
                    if(arr[i] == 0) {
                        index1++;
                    }
                    num1[i / 2] = arr[i];
                } else {
                    if(arr[i] == 0) {
                        index2++;
                    }
                    num2[i / 2] = arr[i];
                }
            }

            if(index1 != 0) {
                num1[0] = num1[index1];
                num1[index1] = 0;
            }

            if(index2 != 0) {
                num2[0] = num2[index2];
                num2[index2] = 0;
            }

            for(int i : num1) {
                result1.append(i);
            }
            for(int i : num2) {
                result2.append(i);
            }

            result.append(Integer.parseInt(result1.toString()) + Integer.parseInt(result2.toString())).append("\n");
        }

        bw.write(result.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
