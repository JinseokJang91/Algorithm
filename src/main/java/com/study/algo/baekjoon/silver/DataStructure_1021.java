package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DataStructure_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 연산 세 가지 방법
        // 1. 첫 번째 원소 추출
        // 2. 왼쪽으로 한 칸 이동
        // 3. 오른쪽으로 한 칸 이동

        // 주어진 순서대로 뽑아내는데 드는 연산의 최솟값. 단 2,3번 연산만 카운팅
        // 뽑으려는 수가 제일 앞에 오도록 해야 1번 연산을 사용해 종료됨
        // => 타켓 넘버가 제일 앞에 위치하도록 2,3번 연산 중 적절히 선택하여 사용

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> rotatingQueue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            rotatingQueue.offer(i);
        }

        int[] targetNumberIndexes = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            targetNumberIndexes[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for(int i = 0; i < M; i++) {
            int targetNumberIndex = rotatingQueue.indexOf(targetNumberIndexes[i]);
            int middleIndex = rotatingQueue.size() % 2 == 0 ? rotatingQueue.size() / 2 - 1 : rotatingQueue.size() / 2;

            if(targetNumberIndex <= middleIndex) {
                // 타겟 넘버의 위치가 중간 지점보다 앞에 있는 경우, 2번 연산 수행
                for(int j = 0; j < targetNumberIndex; j++) {
                    int number = rotatingQueue.pollFirst();
                    rotatingQueue.offerLast(number);
                    count++;
                }
            } else {
                // 타겟 넘버의 위치가 중간 지점보다 뒤에 있는 경우, 3번 연산 수행
                for(int j = 0; j < rotatingQueue.size() - targetNumberIndex; j++) {
                    int number = rotatingQueue.pollLast();
                    rotatingQueue.offerFirst(number);
                    count++;
                }
            }
            rotatingQueue.pollFirst(); // 1번 연산 수행 후 종료
        }

        bw.write("" + count);

        bw.flush();
        bw.close();
        br.close();
    }
}
