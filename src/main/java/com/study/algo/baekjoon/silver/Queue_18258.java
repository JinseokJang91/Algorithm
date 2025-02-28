package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.*;

public class Queue_18258 {
    static Queue<Integer> queue;
    static StringBuilder result;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        push X: 정수 X를 큐에 넣는 연산이다.
        pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        size: 큐에 들어있는 정수의 개수를 출력한다.
        empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
        front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

        출력 명령이 주어질 때마다 한 줄에 하나씩 출력
         */

        int N = Integer.parseInt(br.readLine());

        queue = new LinkedList<>();
        list = new ArrayList<>();
        result = new StringBuilder();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch(command) {
                case "push" :
                    push(Integer.parseInt(st.nextToken()));
                    break;
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

        bw.write(result.toString());

        br.close();
        bw.close();
    }

    private static void push(int x) {
        queue.offer(x);
        list.add(x);
    }

    private static void pop() {
        result.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
    }

    private static void size() {
        result.append(queue.size()).append("\n");
    }

    private static void empty() {
        result.append(queue.isEmpty() ? 1 : 0).append("\n");
    }

    private static void front() {
        result.append(queue.isEmpty() ? -1 : queue.peek()).append("\n"); // peek : 값만 확인 / poll : 값을 뽑아서 확인
    }

    private static void back() {
        result.append(queue.isEmpty() ? -1 : list.get(list.size() - 1)).append("\n");
    }
}
