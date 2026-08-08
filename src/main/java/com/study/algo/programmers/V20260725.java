package com.study.algo.programmers;

import java.util.Stack;

public class V20260725 {
    public static void main(String[] args) {
        String s1 = "baabaa";
        int result1 = solution(s1);
        System.out.println("result1 = " + result1);

        String s2 = "cdcd";
        int result2 = solution(s2);
        System.out.println("result2 = " + result2);
    }

    public static int solution(String s)
    {
        // 문자열 길이가 1일 때
        if(s.length() == 1) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        char[] alphaArray = s.toCharArray();

        for(char alpha : alphaArray) {
            if(stack.isEmpty()) { // 스택이 비어있으면 추가(비교대상)
                stack.push(alpha);
            } else if (alpha == stack.peek()) {
                // stack.peek(): 바로 직전에 추가된 값(붙어있는 짝중 앞순서)
                // alpha: 현재 차례에 해당하는 값(붙어있는 짝중 뒤순서)
                stack.pop();
            } else {
                stack.push(alpha);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
