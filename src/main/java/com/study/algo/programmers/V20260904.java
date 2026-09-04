package com.study.algo.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class V20260904 {
    public static void main(String[] args) {
        int[] elements = {47,9,1,1,4};
        int result = solution(elements); // 18
        System.out.println("result = " + result);
    }

    // 연속 부분 수열 합의 개수
    private static int solution(int[] elements) {
        // 연속 부분 수열 합으로 만들 수 있는 수의 개수
        // => 중복 제거
        Set<Integer> result = new HashSet<>();

        // 마지막 수를 기준으로 잡고 펼치기
        // [7,9,1,1,4] => [7,9,1,1,*4*,7,9,1,1]

        // 1. 원배열 복사(마지막 수는 기준점)
        int[] full_elements = Arrays.copyOf(elements, elements.length * 2 - 1);

        // 2. 원배열 길이 인덱스부터 다시 복사(기준점만 제외)
        for(int i = elements.length; i < full_elements.length; i++) {
            full_elements[i] = full_elements[i - elements.length];
        }

        // 3. 원배열 길이 케이스별 합 계산: 1 ~ n
        for(int len = 1; len <= elements.length; len++) {
            // 펼친 배열에서 케이스에 해당하는 구간의 합 구하기
            int index = 0;
            int sum = 0;

            while(len + index <= full_elements.length) {
                for(int i = index; i < len + index; i++) {
                    sum += full_elements[i];
                }

                result.add(sum);
                index++;
                sum = 0;
            }
        }

        return result.size();
    }
}
