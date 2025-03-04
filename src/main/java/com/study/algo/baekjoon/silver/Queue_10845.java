package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_10845 {
    static Queue<Integer> queue;
    static StringBuilder result;
    static int finalNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        queue = new LinkedList<>();
        result = new StringBuilder();
        finalNum = 0;
        for(int i = 0; i < N; i++) {
            String input = br.readLine();

            if(input.contains("push")) {
                String[] arr = input.split(" ");
                queue.offer(Integer.parseInt(arr[1]));

                finalNum = Integer.parseInt(arr[1]);
            } else {
                switch(input) {
                    case "pop" :
                        pop();
                        break;
                    case "size" :
                        size();
                        break;
                    case "empty" :
                        empty();
                        break;
                    case "front" :
                        front();
                        break;
                    case "back" :
                        back();
                        break;
                    default :
                        break;
                }
            }
        }

        bw.write(result.toString());

        br.close();
        bw.close();
    }

    private static void pop() {
        if(queue.isEmpty()) {
            result.append(-1).append("\n");
        } else {
            result.append(queue.poll()).append("\n");

            if(queue.isEmpty()) {
                finalNum = 0;
            }
        }
    }

    private static void size() {
        result.append(queue.size()).append("\n");
    }

    private static void empty() {
        if(queue.isEmpty()) {
            result.append(1).append("\n");
        } else {
            result.append(0).append("\n");
        }
    }

    private static void front() {
        if(queue.isEmpty()) {
            result.append(-1).append("\n");
        } else {
            result.append(queue.peek()).append("\n");
        }
    }

    private static void back() {
        if(queue.isEmpty()) {
            result.append(-1).append("\n");
        } else {
            result.append(finalNum).append("\n");
        }
    }
}
