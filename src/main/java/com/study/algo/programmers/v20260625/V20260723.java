package com.study.algo.programmers.v20260625;

import java.util.Stack;

public class V20260723 {
    public static void main(String[] args) {
        int num1 = 78;
        int answer1 = solution1(num1);
        System.out.println("answer1 = " + answer1);

        String str1 = "110010101001";
        int[] answer2 = solution2(str1);
        System.out.println("answer2[0] = [" + answer2[0] + ", " + answer2[1] + "]");

        // Integer.toBinaryString(n) => 10진수 n을 2진수 문자열로 변환
        // Integer.bitCount(n) => 정수 n의 이진 변환 시 1의 개수 반환
    }

    // 다음 큰 숫자
    public static int solution1(int n) {
        int answer = 0;
        int count = getBinaryOneCount(n);

        while(answer < n) {
            n += 1;
            int newCount = getBinaryOneCount(n);

            if(count == newCount) {
                answer = n;
                break;
            }
        }

        return answer;
    }

    private static int getBinaryOneCount(int number) {
        return Integer.bitCount(number);
    }

    // 이진 변환 반복하기
    public static int[] solution2(String s) {
        int[] answer = new int[2];

        Stack<Integer> stack; // LIFO로 이진 변환 결과 추출
        StringBuilder result;
        int changeCount = 0;
        int zeroCount = 0;

        while(s.length() > 1) {
            result = new StringBuilder();

            changeCount++; // 변환 횟수 증가

            int beforeLength = s.length();
            s = s.replace("0", "");
            int afterLength = s.length();

            zeroCount += beforeLength - afterLength; // 0의 개수 누적

            stack = new Stack<>();

            // ------- 이진 변환 start
            while(afterLength > 1) {
                stack.push(afterLength % 2);
                afterLength /= 2;
            }

            stack.push(afterLength);
            // ------- 이진 변환 end
            // => Integer.toBinaryString 으로 대체 가능

            while(!stack.isEmpty()) {
                result.append(stack.pop());
            }

            s = result.toString();
        }

        answer[0] = changeCount;
        answer[1] = zeroCount;

        return answer;
    }
}
