package com.study.algo.programmers;

public class V20260824 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3, 1};
        int[] answer = solution(prices); // [5, 4, 1, 2, 1, 0]
    }

    // 주식가격
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            int seconds = 0;
            int price = prices[i];
            for(int j = i + 1; j < prices.length; j++) {
                seconds++;

                if(prices[j] < price) { // 가격이 떨어지면 stop
                    break;
                }
            }

            answer[i] = seconds;
        }

        return answer;
    }
}
