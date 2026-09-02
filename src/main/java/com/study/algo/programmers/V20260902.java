package com.study.algo.programmers;

import java.util.Stack;

public class V20260902 {
    public static void main(String[] args) {
        int[] order = {4,3,1,2,5};
        int result = solution(order); // 2
        System.out.println("result = " + result);
    }

    // 택배 상자
    private static int solution(int[] order) {
        int answer = 0;

        Stack<Integer> sub_belt = new Stack<>(); // LIFO

        int idx = 0;
        // 메인 박스는 1~n번 까지 일렬로 전달
        for(int main_belt_box = 1; main_belt_box <= order.length; main_belt_box++) {
            if(main_belt_box != order[idx]) {
                // 택배 기사의 순서와 다르면 서브 벨트로 이동
                sub_belt.push(main_belt_box);
            } else {
                // 택배 기사의 순서와 같으면 트럭에 실기
                answer++;
                idx++;
            }

            // 서브 벨트에 같은게 있으면 트럭에 실기
            while(!sub_belt.isEmpty() && order[idx] == sub_belt.peek()) {
                sub_belt.pop();
                answer++;
                idx++;
            }
        }

        return answer;
    }
}
