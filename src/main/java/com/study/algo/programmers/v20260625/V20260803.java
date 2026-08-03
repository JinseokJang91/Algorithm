package com.study.algo.programmers.v20260625;

import java.util.Arrays;

public class V20260803 {
    public static void main(String[] args) {
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int k = 6;
        int result1 = solution1(k, tangerine);
        System.out.println("result1 = " + result1);

        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int result2 = solution2(people, limit);
        System.out.println("result2 = " + result2);
    }

    // 귤 고르기
    public static int solution1(int k, int[] tangerine) {
        // 귤 크기: 1 ~ 10,000,000
        int answer = 0;
        int[] tangerineCounts = new int[10000001]; // 귤 크기 별 개수 측정을 위한 배열

        for(int t : tangerine) {
            tangerineCounts[t] += 1;
        }

        Arrays.sort(tangerineCounts);

        // 어떤 크기가 몇개인지는 안 중요함
        // => 종류 개수를 최소화하려면 크기별 개수가 많은 것부터 차례대로 구하면 됨
        for(int i = tangerineCounts.length - 1; i > 0; i--) {
            if(tangerineCounts[i] == 0) {
                continue;
            }

            if(k <= tangerineCounts[i]) {
                answer++;
                break;
            }

            k -= tangerineCounts[i];
            answer++;
        }

        return answer;
    }

    // 구명보트
    public static int solution2(int[] people, int limit) {
        // 정렬 후 뒤 -> 앞 순서로 체크
        Arrays.sort(people);

        int right = people.length - 1;
        int left = 0;
        int boat = 0;

        while(right >= left) {
            // 앞뒤 합이 limit에 충족하는 경우에만 left 이동
            if(people[right] + people[left] <= limit) {
                left++;
            }

            right--; // 충족 안하면 무거운 사람이 혼자 타는 것
            boat++;
        }

        System.out.println(boat);

        return boat;
    }
}
