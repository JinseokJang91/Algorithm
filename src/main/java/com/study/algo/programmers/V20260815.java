package com.study.algo.programmers;


import java.util.*;

public class V20260815 {
    public static void main(String[] args) {
        int[] priorities1 = {2,1,3,2};
        int location1 = 2;
        int answer1 = solution(priorities1, location1);
        System.out.println("answer1 = " + answer1);

        int[] priorities2 = {1, 1, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int location2 = 1;
        int answer2 = solution(priorities2, location2);
        System.out.println("answer2 = " + answer2); // priorities2[1]은 마지막 순서로 실행되므로 32
    }

    // 프로세스
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>(); // 프로세스별 우선순위 세팅

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }

        // 우선순위가 높은 프로세스부터 실행 처리
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            // current[0]: 현재 프로세스 번호
            // current[1]: 현재 프로세스의 우선순위

            // 큐에 현재보다 우선순위 높은 게 있는지 확인
            boolean hasHigher = false;
            for (int[] p : queue) {
                if (p[1] > current[1]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.offer(current); // 뒤로 보냄
            } else {
                answer++; // 프로세스 실행 처리
                if (current[0] == location) {
                    return answer;
                }
            }
        }

        return answer;
    }
}
