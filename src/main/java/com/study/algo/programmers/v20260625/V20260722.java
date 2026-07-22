package com.study.algo.programmers.v20260625;

import java.util.*;
import java.util.stream.Collectors;

public class V20260722 {
    public static void main(String[] args) {
        String s1 = "3people unFollowed me";
        String answer1 = solution1(s1);
        System.out.println("answer1 = " + answer1);
        String s2 = "for the  last   week"; // 반례: 연속 공백
        String answer2 = solution1(s2);
        System.out.println("answer2 = " + answer2);
        String s3 = "1HELLO 1WORLD"; // 반례: 첫 문자 연속 숫자
        String answer3 = solution1(s3);
        System.out.println("answer3 = " + answer3);

        int[] A = {1,4,2};
        int[] B = {5,4,4};
        int answer4 = solution2(A, B);
        System.out.println("answer4 = " + answer4);
    }

    // Jaden Case 문자열 만들기
    public static String solution1(String s) {
        StringBuilder answer = new StringBuilder();

        s = s.toLowerCase();
        char[] sArr = s.toCharArray();
        boolean isBlank = false;

        for(int i = 0; i < sArr.length; i++) {
            boolean isNumber = sArr[i] - '0' >= 0 && sArr[i] - '0' < 10 ? true : false;

            if(i == 0) {
                if(isNumber) continue;

                sArr[i] -= 32;
            } else {
                if(sArr[i] == ' ') {
                    isBlank = true;
                } else {
                    if(!isBlank) continue;
                    isBlank = false;

                    if(isNumber) continue;
                    sArr[i] -= 32;
                }
            }
        }

        for(char c : sArr) {
            answer.append(c);
        }

        return answer.toString();
    }

    public static int solution2(int []A, int []B)
    {
        int answer = 0;
        List<Integer> listA = new ArrayList<>(Arrays.stream(A).boxed().collect(Collectors.toList())); // 배열 -> 리스트
        List<Integer> listB = new ArrayList<>(Arrays.stream(B).boxed().toList()); // 배열 -> 리스트

        Collections.sort(listA, Comparator.naturalOrder()); // 리스트 정렬 오름차순
        Collections.sort(listB, Comparator.reverseOrder()); // 리스트 정렬 내림차순
        listA.sort(Comparator.naturalOrder()); // 리스트 정렬 오름차순
        listB.sort(Comparator.reverseOrder()); // 리스트 정렬 내림차순

        for(int i = 0; i < listA.size(); i++) {
            answer += listA.get(i) * listB.get(i);
        }

        return answer;
    }
}
