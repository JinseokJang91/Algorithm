package com.study.algo.baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class String_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 길이가 N으로 같은 문자열 X와 Y
        // 두 문자열의 차이는 X[i] != Y[i] 인 i의 개수

        // 문자열의 길이가 다른 경우, 연산 실행
        // => A 앞 또는 뒤에 아무 알파벳 추가 (A는 B보다 작거나 같은 길이이다.)
        // A와 B 차이를 최소로 하는 프로그램 작성

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        String B = st.nextToken();

        int result = 0;

        if(A.length() == B.length()) {
            // 1. A와 B의 길이가 같은 경우 : 각 인덱스 비교
            for(int i = 0; i < A.length(); i++) {
                if(A.charAt(i) != B.charAt(i)) {
                    result++;
                }
            }
        } else {
            // 2. A와 B의 길이가 다른 경우
            // 2-1. A가 B에 포함되는 경우 : 연산 실행 결과는 0
            // 2-2. A가 B에 포함되지 않는 경우
            //      => A에 실행할 수 있는 연산의 모든 경우의 수 체크
            //      => 경우의 수는 (B의 길이 - A의 길이 + 1) 가지 이다.
            if(!B.contains(A)) {
                int gap = B.length() - A.length();
                int count = 100;
                for(int i = 0; i < gap + 1; i++) {
                    String prefix = B.substring(0, gap - i);
                    String postfix = B.substring(B.length() - i);

                    String tmpA = prefix + A + postfix;

                    if(tmpA.length() == B.length()) {
                        count = Math.min(count, compareAandB(tmpA, B));
                    }
                }

                result = count;
            }
        }

        bw.write("" + result);

        bw.flush();
        bw.close();
        br.close();
    }

    private static int compareAandB(String a, String b) {
        int count = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}
