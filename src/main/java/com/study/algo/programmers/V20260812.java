package com.study.algo.programmers;

import java.util.*;

public class V20260812 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] answer = solution(progresses, speeds); // [1, 3, 2]
    }

    // 기능개발
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> progressQueue = new LinkedList<>();
        Queue<Integer> speedQueue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++) {
            progressQueue.add(progresses[i]);
            speedQueue.add(speeds[i]);
        }

        // 작업 소요시간: (100 - 작업 진도) / 작업 속도 => 올림 처리
        // e.g. 작업 진도 30, 작업 속도 30이면 3일 후 배포 가능
        //      100 - 30 / 30 ➡️ 70 / 30 ➡️ 2.xx ➡️ 3

        // 첫 작업 세팅
        int progress = progressQueue.poll();
        int speed = speedQueue.poll();
        int days = (int) Math.ceil((100.0 - progress) / speed);
        int distribution = 1;

        while(!progressQueue.isEmpty()) {
            progress = progressQueue.poll();
            speed = speedQueue.poll();
            int daysCompare = (int) Math.ceil((100.0 - progress) / speed);

            if(days >= daysCompare) {
                distribution++;
            } else {
                answerList.add(distribution);

                distribution = 1;
                days = daysCompare;
            }
        }

        // 큐에서 다 뽑고나면 마지막 계산된 배포일자 삽입(큐는 비어있는 상태)
        answerList.add(distribution);

        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
