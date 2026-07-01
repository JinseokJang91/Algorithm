package com.study.algo.programmers.v20260625;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class V20260701 {
    public static void main(String[] args) {
        Solution1 sol1 = new Solution1();
        int[] sol1Arrray = sol1.solution(5, 555);
    }
}

// 배열 만들기 2
class Solution1 {
    public int[] solution(int l, int r) {
        // 0과 5로 이루어짐 => 나누면 0 또는 1로 이루어짐

        int[] answer = {};

        List<Integer> fiveMultiples = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // 5의 배수만 리스트에 추가
        for(int i = l; i <= r; i++) {
            if(i % 5 == 0) {
                fiveMultiples.add(i);
            }
        }

        for(int fiveMultiple : fiveMultiples) {
            int quota = fiveMultiple / 5; // 몫만 계산

            if(checkNumber(String.valueOf(quota))) {
                result.add(fiveMultiple);
            }
        }

        if(result.isEmpty()) {
            result.add(-1);
        } else {
            Collections.sort(result); // 작은 수부터 해서 필수는 아님
        }

        answer = result.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    // 각 자릿수가 0 또는 1인지 확인
    private boolean checkNumber(String quota) {
        boolean isZeroOrFive = true;
        char[] numberArray = quota.toCharArray();

        for(int number : numberArray) {
            // 0도 1도 아니면 탈락
            if(number != '0' && number != '1') {
                isZeroOrFive = false;
                break;
            }
        }

        return isZeroOrFive;
    }
}