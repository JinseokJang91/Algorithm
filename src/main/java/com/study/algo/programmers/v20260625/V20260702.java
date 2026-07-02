package com.study.algo.programmers.v20260625;

import java.util.*;

public class V20260702 {
    public static void main(String[] args) {
        int sol1_1 = solution1(2,2,2,2);
        int sol1_2 = solution1(4,1,4,4);

        String my_string = "rermgorpsam";
        int[][] queries = {{2, 3}, {0, 7}, {5, 9}, {6, 10}};
        String sol2 = solution2(my_string, queries);
    }

    // 주사위 게임 3
    public static int solution1(int a, int b, int c, int d) {
        int answer = 0;
        int[] diceCounts = new int[7];

        // 배열 인덱스 = 주사위 숫자
        diceCounts[a] += 1;
        diceCounts[b] += 1;
        diceCounts[c] += 1;
        diceCounts[d] += 1;

        // 숫자 별 개수
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i < diceCounts.length; i++) {
            if(diceCounts[i] > 0) {
                map.put(i, diceCounts[i]);
            }
        }

        Iterator<Integer> iter = map.keySet().iterator();
        switch(map.size()) {
            // 네 숫자가 모두 같은 경우
            case 1 -> {
                int p = iter.next();
                answer = 1111 * p;
            }
            // 세 주사위가 같은 경우, 두 개씩 같은 경우
            case 2 -> {
                int temp = iter.next();
                if(map.get(temp) == 1) {
                    int p = iter.next();
                    int q = temp;
                    answer = (10 * p + q) * (10 * p + q);
                } else if(map.get(temp) == 3) {
                    int p = temp;
                    int q = iter.next();
                    answer = (10 * p + q) * (10 * p + q);
                } else if(map.get(temp) == 2) {
                    int p = temp;
                    int q = iter.next();
                    answer = (p + q) * Math.abs(p - q);
                }
            }
            // 두 주사위가 같고 나머지 두 주사위는 다른 경우
            case 3 -> {
                int p = 0;
                int q = 0;
                int r = 0;
                while(iter.hasNext()) {
                    int temp = iter.next();
                    if(map.get(temp) == 2) {
                        p = temp;
                    } else {
                        if(q > 0) {
                            r = temp;
                        } else {
                            q = temp;
                        }
                    }
                }
                answer = q * r;
            }
            // 다 다른 경우
            case 4 -> {
                answer = iter.next();
                while(iter.hasNext()) {
                    answer = Math.min(answer, iter.next());
                }
            }
        }

        return answer;
    }

    // 문자열 여러 번 뒤집기
    public static String solution2(String my_string, int[][] queries) {
        StringBuilder answer = new StringBuilder();

        char[] my_chars = my_string.toCharArray();

        for(int[] query : queries) {
            int s = query[0];
            int e = query[1];

            while(s < e) {
                char temp = my_chars[e];
                my_chars[e] = my_chars[s];
                my_chars[s] = temp;

                s++;
                e--;
            }
        }

        for(char my_char : my_chars) {
            answer.append(my_char);
        }

        return answer.toString();
    }
}
